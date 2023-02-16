package konradstach.recipesbe.interfaces;

import konradstach.recipesbe.domain.model.ScrappedRecipeDTO;
import konradstach.recipesbe.domain.recipes.RecipesService;
import konradstach.recipesbe.domain.model.CreateEditRecipeRequest;
import konradstach.recipesbe.domain.model.FullRecipeDTO;
import konradstach.recipesbe.domain.model.RecipeDTO;
import konradstach.recipesbe.domain.recipes.WebPageScrapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/recipes")
@CrossOrigin(origins = "http://localhost:3000")
public class RecipesController {

    private RecipesService recipesService;
    private WebPageScrapper webPageScrapper;

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
    public FullRecipeDTO createNewRecipe(@RequestBody CreateEditRecipeRequest request) {
        return recipesService.createNewRecipe(request);
    }
//
//    @PutMapping("/{id}")
//    public FullRecipeDTO editRecipe(@PathVariable String id, @RequestBody CreateEditRecipeRequest request) {
//        return recipesService.editRecipe(id, request);
//    }

    @PatchMapping("/{id}")
    public FullRecipeDTO editRecipe(@PathVariable String id, @RequestBody CreateEditRecipeRequest request) {
        if(request.getName()==null){
            return recipesService.toggleFavourites(id, request.isFavourite());
        }
        return recipesService.editRecipe(id, request);
    }

    @GetMapping("/scrap")
    public ScrappedRecipeDTO scrapRecipeFromWebPage(@RequestParam String url){
        return webPageScrapper.getScrappedRecipeFromKwestiaSmaku(url);
    }
}
