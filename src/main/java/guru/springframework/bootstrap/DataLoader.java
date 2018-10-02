package guru.springframework.bootstrap;

import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;

    public DataLoader(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(loadData());
    }

    private List<Recipe> loadData(){

        List<Recipe> recipes = new ArrayList<>(2);

        Recipe recipe = new Recipe();
        Ingredient ingredient = new Ingredient();

        ingredient.setDesctiption("ripe tomato, seeds and pulp removed, chopped");
        ingredient.setAmount(new BigDecimal(".5"));
        ingredient.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Each").get());
        ingredient.setRecipe(recipe);
        recipe.getIngredients().add(ingredient);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setDesctiption("ripe avocados");
        ingredient2.setAmount(new BigDecimal(2));
        ingredient2.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Each").get());
        ingredient2.setRecipe(recipe);
        recipe.getIngredients().add(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setDesctiption("Kosher salt");
        ingredient3.setAmount(new BigDecimal(".5"));
        ingredient3.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Teaspoon").get());
        ingredient3.setRecipe(recipe);
        recipe.getIngredients().add(ingredient3);

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setDesctiption("resh lime juice or lemon juice");
        ingredient4.setAmount(new BigDecimal(1));
        ingredient4.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        ingredient4.setRecipe(recipe);
        recipe.getIngredients().add(ingredient4);

        Ingredient ingredient5 = new Ingredient();
        ingredient5.setDesctiption("minced red onion or thinly sliced green onion");
        ingredient5.setAmount(new BigDecimal(2));
        ingredient5.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        ingredient5.setRecipe(recipe);
        recipe.getIngredients().add(ingredient5);

        Ingredient ingredient6 = new Ingredient();
        ingredient6.setDesctiption("serrano chiles, stems and seeds removed, minced");
        ingredient6.setAmount(new BigDecimal(2));
        ingredient6.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Each").get());
        ingredient6.setRecipe(recipe);
        recipe.getIngredients().add(ingredient6);

        Ingredient ingredient7 = new Ingredient();
        ingredient7.setDesctiption("cilantro (leaves and tender stems), finely chopped");
        ingredient7.setAmount(new BigDecimal(2));
        ingredient7.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon").get());
        ingredient7.setRecipe(recipe);
        recipe.getIngredients().add(ingredient7);

        Ingredient ingredient8 = new Ingredient();
        ingredient8.setDesctiption("freshly grated black pepper");
        ingredient8.setAmount(new BigDecimal(1));
        ingredient8.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Dash").get());
        ingredient8.setRecipe(recipe);
        recipe.getIngredients().add(ingredient8);

        Notes note = new Notes();
        note.setRecipeNotes("Variations\n" +
                "\n" +
                "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");
        note.setRecipe(recipe);
        recipe.setNotes(note);

        recipe.setDescription("Perfect Guacamole");
        recipe.getCategories().add(categoryRepository.findByDescription("Mexican").get());
        recipe.getCategories().add(categoryRepository.findByDescription("American").get());

        recipe.setPrepTime(10);
        recipe.setCookTime(0);
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n"
        );
        recipe.setServings(3);
        recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

        recipes.add(recipe);
        return recipes;
    }

}
