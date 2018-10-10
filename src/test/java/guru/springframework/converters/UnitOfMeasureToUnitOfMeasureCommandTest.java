package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    private final static Long ID_VALUE = new Long(1L);
    private static final String DESCRIPTION = "description";

    UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    @Before
    public void setUp() throws Exception {
        uomConverter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(uomConverter.convert(null));
    }


    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(uomConverter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(ID_VALUE);
        uom.setDescription(DESCRIPTION);

        //when
        UnitOfMeasureCommand uomCommand = uomConverter.convert(uom);

        //then
        assertEquals(ID_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }

}