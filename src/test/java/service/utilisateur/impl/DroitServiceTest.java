package service.utilisateur.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import persistance.utilisateur.dao.IDroitDao;
import persistance.utilisateur.entity.DroitDo;
import presentation.utilisateur.dto.DroitDto;

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
    void testFindAll() {
        Mockito.when(this.dao.findAll()).thenReturn(Collections.emptyList());
        Assertions.assertEquals(0, this.droitService.findAll().size());
    }

    /**
     * Test pour {@link service.utilisateur.IDroitService#findAll()}, retourne 1 droit
     */
    @Test
    void testFindAll2() {
        final DroitDo droitDo = new DroitDo();

        droitDo.setIdDroit(1);
        droitDo.setUrl("test");

        Mockito.when(this.dao.findAll()).thenReturn(Collections.singletonList(droitDo));
        Assertions.assertEquals(1, this.droitService.findAll().size());
    }

    /**
     * Test pour {@link service.utilisateur.IDroitService#findAll()}, retourne liste vide
     */
    @Test
    void testFindRole() {
        Mockito.when(this.dao.findRole(Mockito.any(DroitDo.class))).thenReturn(Collections.emptyList());
        Assertions.assertEquals(0, this.droitService.findRole(new DroitDto()).size());
    }

    /**
     * Test pour {@link service.utilisateur.IDroitService#findAll()}, retourne 2 role
     */
    @Test
    void testFindRole2() {
        Mockito.when(this.dao.findRole(Mockito.any(DroitDo.class))).thenReturn(Arrays.asList("admin", "client"));

        final List<String> roles = this.droitService.findRole(new DroitDto());

        Assertions.assertEquals(2, roles.size());

        roles.stream().forEach(Assertions::assertNotNull);
    }

}
