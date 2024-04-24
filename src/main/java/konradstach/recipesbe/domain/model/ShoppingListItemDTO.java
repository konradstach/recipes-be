package konradstach.recipesbe.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingListItemDTO {
    private String name;
    private boolean checked;
}
