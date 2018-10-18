package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    private final static Long ID_VALUE = new Long(1L);
    private static final String DESCRIPTION = "description";

    CategoryToCategoryCommand categoryConverter;

    @Before
    public void setUp() throws Exception {
        categoryConverter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(categoryConverter.convert(null));
    }


    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(categoryConverter.convert(new Category()));
    }

    @Test
    public void testConvert() {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = categoryConverter.convert(category);

        //then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}