package konradstach.recipesbe.domain.shopping;

import konradstach.recipesbe.domain.model.ShoppingListItem;
import konradstach.recipesbe.domain.model.ShoppingListItemDTO;
import konradstach.recipesbe.infrastructure.repository.ShoppingListRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public List<ShoppingListItemDTO> getCurrentShoppingList() {
        return shoppingListRepository.findAll()
                .stream()
                .map(e-> new ShoppingListItemDTO(e.getName(), e.isChecked())).collect(Collectors.toList());
    }

    public List<ShoppingListItemDTO> saveUpdatedShoppingList(List<ShoppingListItemDTO> updatedList) {
        shoppingListRepository.deleteAll();

        shoppingListRepository.saveAll(updatedList.stream().map(e-> new ShoppingListItem(e.getName(), e.isChecked())).collect(Collectors.toList()));

        return shoppingListRepository.findAll()
                .stream()
                .map(e-> new ShoppingListItemDTO(e.getName(), e.isChecked())).collect(Collectors.toList());
    }

    public void addToShoppingList(List<ShoppingListItemDTO> productsToAdd){
        shoppingListRepository.saveAll(productsToAdd.stream().map(e-> new ShoppingListItem(e.getName(), e.isChecked())).collect(Collectors.toList()));
    }

    public void addToShoppingList(ShoppingListItemDTO productToAdd){
        shoppingListRepository.save(new ShoppingListItem(productToAdd.getName(), false));
    }
}
