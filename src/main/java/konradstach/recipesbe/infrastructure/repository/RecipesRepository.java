package konradstach.recipesbe.infrastructure.repository;

import konradstach.recipesbe.domain.model.Recipe;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableScan
public interface RecipesRepository extends CrudRepository<Recipe, String> {

    List<Recipe> findAll();
    List<Recipe> findByNameContaining(String name);
}
