package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.NotesCommand;
import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Recipe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeCommandToRecipeTest {

    private static final String DESCRIPTION = "description";
    private static final Integer PREP_TIME = Integer.valueOf("10");
    private static final Integer COOK_TIME = Integer.valueOf("7");
    private static final Integer SERVINGS = Integer.valueOf("3");
    private static final String SOURCE = "source";
    private static final String URL = "url";
    private static final String DIRECTIONS = "directions";
    private static final Difficulty DIFFICULTY = Difficulty.EASY;
    private static final Long RECIPE_ID = new Long(1L);
    private static final Long ING_ID_1 = new Long(2L);
    private static final Long ING_ID_2 = new Long(3L);
    private static final Long CAT_ID_1 = new Long(4L);
    private static final Long CAT_ID_2 = new Long(5L);
    private static final Long NOTES_ID = new Long(7L);


    RecipeCommandToRecipe converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeCommandToRecipe(
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new CategoryCommandToCategory(), new NotesCommandToNotes());
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(converter.convert(null));
    }


    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    public void testConvert() {
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setId(RECIPE_ID);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);
        recipeCommand.setPrepTime(PREP_TIME);

        NotesCommand notes = new NotesCommand();
        notes.setId(NOTES_ID);

        recipeCommand.setNotes(notes);

        IngredientCommand ingredientCommand1 = new IngredientCommand();
        ingredientCommand1.setId(ING_ID_1);
        IngredientCommand ingredientCommand2 = new IngredientCommand();
        ingredientCommand2.setId(ING_ID_2);

        recipeCommand.getIngredients().add(ingredientCommand1);
        recipeCommand.getIngredients().add(ingredientCommand2);

        CategoryCommand categoryCommand1 = new CategoryCommand();
        CategoryCommand categoryCommand2 = new CategoryCommand();
        categoryCommand1.setId(CAT_ID_1);
        categoryCommand2.setId(CAT_ID_2);

        recipeCommand.getCategories().add(categoryCommand1);
        recipeCommand.getCategories().add(categoryCommand2);

        //when
        Recipe recipe = converter.convert(recipeCommand);

        //then
        assertNotNull(recipe);
        assertEquals(RECIPE_ID, recipe.getId());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(NOTES_ID, recipe.getNotes().getId());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(2, recipe.getIngredients().size());




    }
}