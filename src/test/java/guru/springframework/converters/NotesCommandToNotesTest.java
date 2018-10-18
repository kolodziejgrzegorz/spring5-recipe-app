package guru.springframework.converters;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesCommandToNotesTest {
    private final static Long ID_VALUE = new Long(1L);
    private static final String DESCRIPTION = "notes";

    NotesCommandToNotes notesConverter;

    @Before
    public void setUp() throws Exception {
        notesConverter = new NotesCommandToNotes();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(notesConverter.convert(null));
    }


    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(notesConverter.convert(new NotesCommand()));
    }

    @Test
    public void testConvert() {
        //given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(DESCRIPTION);

        //when
        Notes notes = notesConverter.convert(notesCommand);

        //then
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(DESCRIPTION, notes.getRecipeNotes());
    }
}