package konradstach.recipesbe.domain.model;

import java.util.List;

public class FullRecipeDTO {
    private String name;
    private List<String> steps;
    private List<String> tags;
    private int portions;
    private List<Ingredient> ingredients;

}
