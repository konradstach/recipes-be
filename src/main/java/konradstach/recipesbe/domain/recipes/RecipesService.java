package konradstach.recipesbe.domain.recipes;

import konradstach.recipesbe.domain.model.*;
import konradstach.recipesbe.infrastructure.repository.RecipesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipesService {

    private final RecipesRepository recipesRepository;

    public List<RecipeDTO> getAll() {
        return recipesRepository.findAll().stream().map(RecipeMapper::toDTO).collect(Collectors.toList());
    }

    public List<RecipeDTO> getAllByName(String name) {
        String nameLowerCase = name.toLowerCase();
        List<Recipe> recipesFiltered = recipesRepository.findByNameContaining(nameLowerCase);
        return RecipeMapper.toDTOList(recipesFiltered);
    }

    public FullRecipeDTO getFullRecipeById(String id) {
        return null;
    }

    public FullRecipeDTO createNewRecipe(CreateNewRecipeRequest request) {
        return null;
    }

    public FullRecipeDTO editRecipe(String id, CreateNewRecipeRequest request){
        return null;
    }
}
