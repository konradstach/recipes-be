package konradstach.recipesbe.domain.recipes;

import com.amazonaws.services.kms.model.NotFoundException;
import konradstach.recipesbe.domain.model.*;
import konradstach.recipesbe.infrastructure.repository.RecipesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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

    public FullRecipeDTO createNewRecipe(CreateEditRecipeRequest request) {
        Recipe recipe = RecipeMapper.toRecipe(request);
        Recipe savedRecipe = recipesRepository.save(recipe);
        log.info("New recipe added: {}", savedRecipe);
        return RecipeMapper.toFullRecipeDTO(savedRecipe);
    }

    public FullRecipeDTO editRecipe(String id, CreateEditRecipeRequest request) {
        Recipe recipe = RecipeMapper.toRecipe(request);
        recipe.setId(id);
        Recipe updatedRecipe = recipesRepository.save(recipe);
        log.info("Recipe updated: {}.", updatedRecipe);
        return RecipeMapper.toFullRecipeDTO(updatedRecipe);
    }

    public FullRecipeDTO toggleFavourites(String id, boolean favouriteValue) {
        Recipe recipe = recipesRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        recipe.setFavourite(favouriteValue);

        Recipe updatedRecipe = recipesRepository.save(recipe);

        String addedRemovedString = recipe.isFavourite() ? "added to" : "removed from";
        String logInfo = "Recipe " + recipe.getName() + " was " + addedRemovedString + " favourites.";
        log.info(logInfo);

        return RecipeMapper.toFullRecipeDTO(updatedRecipe);
    }
}
