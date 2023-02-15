package konradstach.recipesbe.domain.model;

import lombok.Data;

@Data
public class RecipeDTO {

    private String id;
    private String name;
    private short prepTime;
    private short withCookTime;
    private String imgUrl;
    private int energy;
    private boolean favourite;
}
