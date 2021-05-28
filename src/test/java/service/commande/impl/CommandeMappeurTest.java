/**
 * 
 */
package service.commande.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;

import persistance.commande.entity.CommandeDo;
import presentation.commande.dto.CommandeDto;
import service.CommandeMappeur;

/**
 * JUnit pour tester le Mapper de commande
 *
 * @author Hanan anghari
 */
class CommandeMappeurTest {

    /**
     * Test method for {@link service.CommandeMappeur#mapperToDto(persistance.commande.entity.CommandeDo)}.
     * 
     * @throws ParseException
     */
    @Test
    void testMapperToDto() throws ParseException {

        final CommandeDo commandeDo = new CommandeDo();

        commandeDo.setId(20);
        commandeDo.setReference("ABC9");
        final Date date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1970");
        commandeDo.setDate(date);
        commandeDo.setPrixTotal(200);

        final CommandeDto commandeDto = CommandeMappeur.mapperToDto(commandeDo);

        assertNotNull(commandeDto);
        assertEquals("20", commandeDto.getId());
        assertEquals("ABC9", commandeDto.getReference());
        assertEquals("01/01/1970", commandeDto.getDate());
        assertEquals("200", commandeDto.getPrixTotal());
        final CommandeDto commandeDtoNull = CommandeMappeur.mapperToDto(null);
        assertEquals(null, commandeDtoNull);

    }

    /**
     * Test method for {@link service.CommandeMappeur#mapperListDoToDto(java.util.List)}.
     */
    @Test
    void testMapperListDoToDto() {

        final CommandeDo commandeDo = new CommandeDo();
        final CommandeDo commandeDo2 = new CommandeDo();
        assertEquals(2, CommandeMappeur.mapperListDoToDto(Arrays.asList(commandeDo, commandeDo2)).size());

    }

}
