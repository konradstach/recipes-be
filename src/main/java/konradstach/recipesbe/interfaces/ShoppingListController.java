package konradstach.recipesbe.interfaces;

import konradstach.recipesbe.domain.model.ShoppingListItemDTO;
import konradstach.recipesbe.domain.shopping.ShoppingListService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/shopping-list")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class ShoppingListController {

    private ShoppingListService shoppingListService;

    @GetMapping()
    public List<ShoppingListItemDTO> getCurrentShoppingList() {
        return shoppingListService.getCurrentShoppingList();
    }

    @PutMapping()
    public List<ShoppingListItemDTO> updateShoppingList(@RequestBody List<ShoppingListItemDTO> updatedList) {
        return shoppingListService.saveUpdatedShoppingList(updatedList.stream().filter(e-> !e.isChecked()).collect(Collectors.toList()));
    }

    @PostMapping()
    public void addToShoppingList(@RequestBody List<ShoppingListItemDTO> productsToAdd) {
        log.info(productsToAdd.toString());
        shoppingListService.addToShoppingList(productsToAdd);
    }
    @PostMapping("/product")
    public void addSingleProductToShoppingList(@RequestBody ShoppingListItemDTO productToAdd) {
        shoppingListService.addToShoppingList(productToAdd);
    }
}
