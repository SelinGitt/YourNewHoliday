package service.utilisateur.impl;

import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import persistance.utilisateur.dao.IDroitDao;
import persistance.utilisateur.entity.DroitDo;
import persistance.utilisateur.entity.PossedeDo;
import persistance.utilisateur.entity.RoleDo;

/**
 * JUnit test classe pour {@link service.utilisateur.impl.DroitService}
 *
 * @author Valentin
 */
class DroitServiceTest {

    @Mock
    private IDroitDao    dao;

    @InjectMocks
    private DroitService droitService;

    @BeforeEach
    void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test pour {@link service.utilisateur.IDroitService#findAll()}, retourne liste vide
     */
    @Test
    void testFindAllEmpty() {
        Mockito.when(this.dao.findAll()).thenReturn(Collections.emptyList());
        Assertions.assertEquals(0, this.droitService.findAll().size());
    }

    /**
     * Test pour {@link service.utilisateur.IDroitService#findAll()}, retourne 1 droit
     */
    @Test
    void testFindAll() {
        final DroitDo droitDo = new DroitDo();

        droitDo.setIdDroit(1);
        droitDo.setUrl("test");

        final RoleDo roleDo = new RoleDo();

        roleDo.setIdRole(1);
        roleDo.setLibelle("libelle");

        final PossedeDo possedeDo = new PossedeDo();

        possedeDo.setId(1);
        possedeDo.setDroit(droitDo);
        possedeDo.setRole(roleDo);

        droitDo.setPossede(Collections.singletonList(possedeDo));

        Mockito.when(this.dao.findAll()).thenReturn(Collections.singletonList(droitDo));
        Assertions.assertEquals(1, this.droitService.findAll().size());
    }

}
