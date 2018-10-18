package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    private final static Long ID_VALUE = new Long(1L);
    private static final String DESCRIPTION = "description";

    CategoryCommandToCategory categoryConverter;

    @Before
    public void setUp() throws Exception {
        categoryConverter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(categoryConverter.convert(null));
    }


    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(categoryConverter.convert(new CategoryCommand()));
    }

    @Test
    public void testConvert() {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = categoryConverter.convert(categoryCommand);

        //then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}