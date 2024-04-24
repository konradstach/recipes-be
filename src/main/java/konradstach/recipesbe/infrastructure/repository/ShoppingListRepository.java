package konradstach.recipesbe.infrastructure.repository;

import konradstach.recipesbe.domain.model.ShoppingListItem;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableScan
public interface ShoppingListRepository extends CrudRepository<ShoppingListItem, String> {

    List<ShoppingListItem> findAll();

    <S extends ShoppingListItem> Iterable<S> saveAll(Iterable<S> entities);

    void deleteAll();
}
