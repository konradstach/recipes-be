package konradstach.recipesbe.domain.recipes;

import com.amazonaws.services.kms.model.NotFoundException;
import konradstach.recipesbe.domain.model.*;
import konradstach.recipesbe.infrastructure.repository.RecipesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
        Recipe recipe = recipesRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Entity with id %s not found", id)));
        return RecipeMapper.toFullRecipeDTO(recipe);
    }

    public FullRecipeDTO createNewRecipe(CreateNewRecipeRequest request) {
        Recipe recipe = RecipeMapper.toRecipe(request);
        Recipe savedRecipe = recipesRepository.save(recipe);
        log.info("New recipe added: {}", savedRecipe);
        return RecipeMapper.toFullRecipeDTO(savedRecipe);
    }

    public FullRecipeDTO editRecipe(String id, CreateNewRecipeRequest request) {
        return null;
    }
}
