package konradstach.recipesbe.domain.model;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeMapper {

    public static List<RecipeDTO> toDTOList(List<Recipe> recipe) {
        return recipe.stream().map(RecipeMapper::toDTO).collect(Collectors.toList());
    }

    public static RecipeDTO toDTO(Recipe recipe) {
        RecipeDTO dto = new RecipeDTO();
        dto.setId(recipe.getId());
        dto.setName(recipe.getName());
        dto.setPrepTime(recipe.getPrepTime());
        dto.setWithCookTime(recipe.getWithCookingTime());
        dto.setImgUrl(recipe.getImgUrl());
        dto.setEnergy(recipe.getEnergy());
        dto.setFavourite(recipe.isFavourite());
        return dto;
    }


}
