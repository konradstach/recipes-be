package konradstach.recipesbe.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RecipeMapper {

    public static List<RecipeDTO> toDTOList(List<Recipe> recipe) {
        return recipe.stream().map(RecipeMapper::toDTO).collect(Collectors.toList());
    }

    public static RecipeDTO toDTO(Recipe recipe) {
        RecipeDTO dto = new RecipeDTO();
        dto.setId(recipe.getId());
        dto.setName(recipe.getName());
        dto.setPrepTime(recipe.getPrepTime());
        dto.setWithCookTime(recipe.getWithCookingTime());
        dto.setImgUrl(recipe.getImgUrl());
        dto.setEnergy(recipe.getEnergy());
        dto.setFavourite(recipe.isFavourite());
        return dto;
    }

    public static FullRecipeDTO toFullRecipeDTO(Recipe recipe) {
        FullRecipeDTO dto = new FullRecipeDTO();
        dto.setId(recipe.getId());
        dto.setName(recipe.getName());
        dto.setFavourite(recipe.isFavourite());
        dto.setPrepTime(recipe.getPrepTime());
        dto.setWithCookTime(recipe.getWithCookingTime());
        dto.setImgUrl(recipe.getImgUrl());
        dto.setEnergy(recipe.getEnergy());
        dto.setServings(recipe.getPortions());
        dto.setTags(recipe.getTags());
        dto.setSteps(recipe.getSteps());
        dto.setIngredients(RecipeMapper.toDTOIngredientsList(recipe.getIngredients()));
        return dto;
    }

    public static List<IngredientDTO> toDTOIngredientsList(List<Ingredient> ingredients) {
        return ingredients.stream().map(RecipeMapper::toDTO).collect(Collectors.toList());
    }

    private static IngredientDTO toDTO(Ingredient ingredient) {
        IngredientDTO dto = new IngredientDTO();
        dto.setAmount(ingredient.getAmount());
        dto.setIngredientName(ingredient.getIngredientName());
        return dto;
    }

    public static Recipe toRecipe(CreateNewRecipeRequest request) {
        Recipe newRecipe = new Recipe();
        newRecipe.setId(request.getName().toLowerCase().replace(" ", "-"));
        newRecipe.setName(request.getName());
        newRecipe.setPortions(request.getPortions());
        newRecipe.setPrepTime(request.getPrepTime() + "min");
        newRecipe.setWithCookingTime(request.getWithCookTime() + "min");
        newRecipe.setImgUrl(request.getImgUrl());
        newRecipe.setEnergy(request.getEnergy());
        newRecipe.setTags(Arrays.asList("Jedzenie")); //TODO
        newRecipe.setIngredients(extractIngredientsFromString(request.getIngredients()));
        newRecipe.setSteps(extractStepsFromString(request.getSteps()));

        return newRecipe;
    }

    public static List<Ingredient> extractIngredientsFromString(String ingredientsString) {
        List<Ingredient> ingredientsList = new ArrayList<>();

        String commaReplacedString = ingredientsString.replace(",", ".");
        String[] split = commaReplacedString.split("\n");

        for (String ingredientString : split) {
            String trimmed = ingredientString.trim();
            OptionalInt firstLetterIndex = IntStream.range(0, trimmed.length())
                    .filter(i -> Character.isLetter(trimmed.charAt(i)))
                    .findFirst();

            if (firstLetterIndex.isPresent()) {
                if (firstLetterIndex.getAsInt() > 0) {
                    String numbers = trimmed.substring(0, firstLetterIndex.getAsInt());
                    String letters = trimmed.substring(firstLetterIndex.getAsInt());
                    ingredientsList.add(new Ingredient(Double.valueOf(numbers), letters));
                } else {
                    ingredientsList.add(new Ingredient(trimmed));
                }
            }

        }
        return ingredientsList;
    }

    private static List<String> extractStepsFromString(String steps) {
        return Arrays
                .stream(steps.split("\n"))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
