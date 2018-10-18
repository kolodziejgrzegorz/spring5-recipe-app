package guru.springframework.converters;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesToNotesCommandTest {

    private final static Long ID_VALUE = new Long(1L);
    private static final String DESCRIPTION = "description";

    UnitOfMeasureToUnitOfMeasureCommand notesConverter;

    @Before
    public void setUp() throws Exception {
        notesConverter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(notesConverter.convert(null));
    }


    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(notesConverter.convert(new UnitOfMeasure()));
    }

    @Test
    public void testConvert() {
        //given
        UnitOfMeasure notes = new UnitOfMeasure();
        notes.setId(ID_VALUE);
        notes.setDescription(DESCRIPTION);

        //when
        UnitOfMeasureCommand notesCommand = notesConverter.convert(notes);

        //then
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(DESCRIPTION, notes.getDescription());
    }

}