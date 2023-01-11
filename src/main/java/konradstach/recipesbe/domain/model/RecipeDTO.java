package konradstach.recipesbe.domain.model;

import lombok.Data;

@Data
public class RecipeDTO {

    private String id;
    private String name;
    private String prepTime;
    private String withCookTime;
    private String imgUrl;
    private int energy;
    private boolean favourite;
}
