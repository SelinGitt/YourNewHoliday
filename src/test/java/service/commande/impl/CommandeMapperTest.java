/**
 * 
 */
package service.commande.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;

import persistance.commande.entity.CommandeDo;
import presentation.commande.dto.CommandeDto;
import service.commande.CommandeMapper;
import service.util.DateFormatUtil;

/**
 * JUnit pour tester le Mapper de commande
 *
 * @author Hanan anghari
 */
class CommandeMapperTest {

	/**
	 * Test method for {@link service.commande.CommandeMapper#mapperToDto(persistance.commande.entity.CommandeDo)}.
	 * 
	 * @throws ParseException
	 */
	@Test
	void testMapperToDto() throws ParseException {

		final CommandeDo commandeDo = new CommandeDo();

		commandeDo.setId(20);
		commandeDo.setReference("ABC9");
		final Date date = DateFormatUtil.formaterStringToDate("01/01/1970");
		commandeDo.setDate(date);
		commandeDo.setPrixTotal(new BigDecimal(200.40).setScale(2, RoundingMode.FLOOR));
		commandeDo.setQuaniteTotale(5);

		final CommandeDto commandeDto = CommandeMapper.mapperToDto(commandeDo);

		assertNotNull(commandeDto);
		assertEquals("20", commandeDto.getId());
		assertEquals("ABC9", commandeDto.getReference());
		assertEquals("01/01/1970", commandeDto.getDate());
		assertEquals("200,40", commandeDto.getPrixTotal());
		assertEquals("5", commandeDto.getQuantiteTotale());
		final CommandeDto commandeDtoNull = CommandeMapper.mapperToDto(null);
		assertNull(commandeDtoNull);

	}

	/**
	 * Test method for {@link service.commande.CommandeMapper#mapperListDoToDto(java.util.List)}.
	 * 
	 * @throws ParseException
	 */
	@Test
	void testMapperListDoToDto() throws ParseException {

		final CommandeDo commandeDo = new CommandeDo();
		commandeDo.setId(20);
		commandeDo.setReference("ABC9");
		final Date date = new SimpleDateFormat("dd/MM/yyyy").parse("12/12/1990");
		commandeDo.setDate(date);
		commandeDo.setPrixTotal(new BigDecimal(2785.40).setScale(2, RoundingMode.FLOOR));

		final CommandeDo commandeDo2 = new CommandeDo();
		commandeDo2.setId(23);
		commandeDo2.setReference("EFG4");
		final Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("13/06/1990");
		commandeDo2.setDate(date2);
		commandeDo2.setPrixTotal(new BigDecimal(2785.40).setScale(2, RoundingMode.FLOOR));

		assertEquals(2, CommandeMapper.mapperListDoToDto(Arrays.asList(commandeDo, commandeDo2)).size());

	}

}
