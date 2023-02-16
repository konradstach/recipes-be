package konradstach.recipesbe.domain.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FullRecipeDTO {
    private String id;
    private String name;
    private boolean favourite;
    private short prepTime;
    private short withCookTime;
    private String imgUrl;
    private short energy;
    private short servings;
    private List<String> tags = new ArrayList<>();
    private List<IngredientDTO> ingredients = new ArrayList<>();
    private List<String> steps = new ArrayList<>();
}
