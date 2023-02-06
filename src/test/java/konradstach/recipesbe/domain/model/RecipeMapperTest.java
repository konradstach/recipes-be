package konradstach.recipesbe.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeMapperTest {

    @Test
    void extractIngredientsFromString() {
        //given
        String ingredientsListToParse = "0,5 litra wody\n2 jaja\n1 kg mąki 650\npieprz i sól";

        //when
        List<Ingredient> result = RecipeMapper.extractIngredientsFromString(ingredientsListToParse);

        //then
        List<Ingredient> expectedIngredients = Arrays.asList(
                new Ingredient(0.5, "litra wody"),
                new Ingredient(2.0, "jaja"),
                new Ingredient(1.0, "kg mąki 650"),
                new Ingredient("pieprz i sól"));

        assertEquals(expectedIngredients, result);
    }


}