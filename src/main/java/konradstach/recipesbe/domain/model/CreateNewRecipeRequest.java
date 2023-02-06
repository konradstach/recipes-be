package konradstach.recipesbe.domain.model;

import lombok.Data;

@Data
public class CreateNewRecipeRequest {

    private String name;
    private short portions;
    private short prepTime;
    private short withCookTime;
    private short energy;
    private String imgUrl;
    private String ingredients;
    private String steps;
}
