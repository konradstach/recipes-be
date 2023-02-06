package konradstach.recipesbe.interfaces;

import konradstach.recipesbe.domain.recipes.RecipesService;
import konradstach.recipesbe.domain.model.CreateNewRecipeRequest;
import konradstach.recipesbe.domain.model.FullRecipeDTO;
import konradstach.recipesbe.domain.model.RecipeDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/recipes")
@CrossOrigin(origins = "http://localhost:3000")
public class RecipesController {

    private RecipesService recipesService;

    @GetMapping()
    public List<RecipeDTO> getAllRecipes(@RequestParam(required = false) String name) {
        if(name == null || name.isEmpty()){
            return recipesService.getAll();
        }
        return recipesService.getAllByName(name);
    }

    @GetMapping("/{id}")
    public FullRecipeDTO getFullRecipe(@PathVariable String id) {
        return recipesService.getFullRecipeById(id);
    }

    @PostMapping()
    public FullRecipeDTO createNewRecipe(@RequestBody CreateNewRecipeRequest request) {
        return recipesService.createNewRecipe(request);
    }

    @PutMapping("/{id}")
    public FullRecipeDTO editRecipe(@PathVariable String id, @RequestBody CreateNewRecipeRequest request) {
        return recipesService.editRecipe(id, request);
    }
}
