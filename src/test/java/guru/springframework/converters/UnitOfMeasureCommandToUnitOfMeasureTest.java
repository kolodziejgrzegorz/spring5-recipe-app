package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    private final static Long ID_VALUE = new Long(1L);
    private static final String DESCRIPTION = "description";

    UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    @Before
    public void setUp() throws Exception {
        uomConverter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(uomConverter.convert(null));
    }


    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(uomConverter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
        uomCommand.setId(ID_VALUE);
        uomCommand.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = uomConverter.convert(uomCommand);

        //then
        assertEquals(ID_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }
}