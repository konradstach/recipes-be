package konradstach.recipesbe.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScrappedRecipeDTO {
    private String name;
    private String imgUrl;
    private String servings;
    private String ingredients;
    private String steps;
}
