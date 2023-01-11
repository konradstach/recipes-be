package konradstach.recipesbe;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import konradstach.recipesbe.domain.model.Ingredient;
import konradstach.recipesbe.domain.model.Recipe;
import konradstach.recipesbe.infrastructure.repository.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class RecipesBeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RecipesBeApplication.class, args);
	}

	@Autowired
	RecipesRepository recipesRepository;

	@Override
	public void run(String... args) throws Exception {
//		Recipe recipe1 = new Recipe();
//		recipe1.setName("szakszuka");
//		recipe1.setPortions(2);
//		recipe1.setSteps(Arrays.asList("step1", "step2", "step3"));
//		recipe1.setIngredients(Arrays.asList(new Ingredient(1.0, "pomidor"), new Ingredient(2.0, "cebula")));
//		recipe1.setPrepTime("25 min");
//		recipe1.setWithCookingTime("30 min");
//		recipe1.setImgUrl("https://i2.wp.com/www.downshiftology.com/wp-content/uploads/2018/12/Shakshuka-19.jpg");
//		recipe1.setEnergy(650);
//		recipe1.setFavourite(true);
//
//		Recipe recipe2 = new Recipe();
//		recipe2.setName("chilli con carne");
//		recipe2.setPortions(2);
//		recipe2.setSteps(Arrays.asList("step1", "step2", "step3"));
//		recipe2.setIngredients(Arrays.asList(new Ingredient(1.0, "pomidor"), new Ingredient(2.0, "cebula")));
//		recipe2.setPrepTime("30 min");
//		recipe2.setWithCookingTime("45 min");
//		recipe2.setImgUrl("https://naszprzepis.pl/wp-content/uploads/2020/09/chili_con_carne_after-1024x768.jpg");
//		recipe2.setEnergy(520);
//		recipe2.setFavourite(false);
//
//		Recipe recipe3 = new Recipe();
//		recipe3.setName("carbonara");
//		recipe3.setPortions(2);
//		recipe3.setSteps(Arrays.asList("step1", "step2", "step3"));
//		recipe3.setIngredients(Arrays.asList(new Ingredient(1.0, "pomidor"), new Ingredient(2.0, "cebula")));
//		recipe3.setPrepTime("30 min");
//		recipe3.setWithCookingTime("40 min");
//		recipe3.setImgUrl("https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/0346a29a89ef229b1a0ff9697184f944/Derivates/cb5051204f4a4525c8b013c16418ae2904e737b7.jpg");
//		recipe3.setEnergy(578);
//		recipe3.setFavourite(true);
//
//		recipesRepository.save(recipe1);
//		recipesRepository.save(recipe2);
//		recipesRepository.save(recipe3);
	}
}
