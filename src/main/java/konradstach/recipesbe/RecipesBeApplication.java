package konradstach.recipesbe;

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
//        Recipe recipe1 = new Recipe();
//        recipe1.setId("szakszuka");
//        recipe1.setName("szakszuka");
//        recipe1.setPortions((short) 2);
//        recipe1.setSteps(Arrays.asList(
//                "Przygotować pomidory: sparzyć, obrać ze skórki, pokroić na ćwiartki, wykroić szypułki, miąższ pokroić w kosteczkę.",
//                "Na niedużą patelnię (około 20 cm średnicy) włożyć masło lub wlać oliwę oraz starty czosnek, chwilę podsmażyć.",
//                "Pomidory włożyć na patelnię, doprawić solą, pieprzem i przyprawami. Wymieszać i intensywnie smażyć na większym ogniu przez około 4 minuty, już bez mieszania (wówczas pomidory odparują i zachowają swoją strukturę, jeśli będziemy mieszać zrobi się przecier).",
//                "Do podsmażonych pomidorów wbić jajka, doprawić solą. Przykryć i gotować przez około 3 minuty lub do czasu aż białka jajek będą ścięte. Podawać ze świeżą bazylią i bagietką."));
//        recipe1.setIngredients(Arrays.asList(
//                new Ingredient(2.0, "pomidory"),
//                new Ingredient(0.5, "łyżki masła lub oliwy"),
//                new Ingredient(0.5, "ząbka czosnku"),
//                new Ingredient("świeża bazylia"),
//                new Ingredient("bagietka czosnkowa")));
//        recipe1.setPrepTimeMins((short)15);
//        recipe1.setWithCookingTimeMins((short)25);
//        recipe1.setImgUrl("https://i2.wp.com/www.downshiftology.com/wp-content/uploads/2018/12/Shakshuka-19.jpg");
//        recipe1.setEnergy((short) 650);
//        recipe1.setFavourite(true);
//        recipe1.setTags(Arrays.asList("Śniadanie", "Kolacja", "Wegetariańskie"));
//
//        Recipe recipe2 = new Recipe();
//        recipe2.setId("chilli-con-carne");
//        recipe2.setName("chilli con carne");
//        recipe2.setPortions((short) 2);
//        recipe2.setSteps(Arrays.asList("step1", "step2", "step3"));
//        recipe2.setIngredients(Arrays.asList(new Ingredient(1.0, "pomidor"), new Ingredient(2.0, "cebula")));
//        recipe2.setPrepTimeMins((short)30);
//        recipe2.setWithCookingTimeMins((short)45);
//        recipe2.setImgUrl("https://naszprzepis.pl/wp-content/uploads/2020/09/chili_con_carne_after-1024x768.jpg");
//        recipe2.setEnergy((short) 520);
//        recipe2.setTags(Arrays.asList("Obiad"));
//        recipe2.setFavourite(false);
//
//        Recipe recipe3 = new Recipe();
//        recipe3.setId("carbonara");
//        recipe3.setName("carbonara");
//        recipe3.setPortions((short) 2);
//        recipe3.setSteps(Arrays.asList("step1", "step2", "step3"));
//        recipe3.setIngredients(Arrays.asList(new Ingredient(1.0, "pomidor"), new Ingredient(2.0, "cebula")));
//        recipe3.setPrepTimeMins((short)30);
//        recipe3.setWithCookingTimeMins((short)40);
//        recipe3.setImgUrl("https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/0346a29a89ef229b1a0ff9697184f944/Derivates/cb5051204f4a4525c8b013c16418ae2904e737b7.jpg");
//        recipe3.setEnergy((short) 578);
//        recipe3.setTags(Arrays.asList("Obiad"));
//        recipe3.setFavourite(true);
//
//        Recipe recipe4 = new Recipe();
//        recipe4.setId("zurek");
//        recipe4.setName("Żurek");
//        recipe4.setPortions((short) 6);
//        recipe4.setSteps(Arrays.asList(
//                "Rozmieszać zaczyn i wlać do dużego garnka z 1,5l wody. Dodać przeciśnięty przez praskę czosnek, zagotować i gotować 15-20min.",
//                "Cebule zeszklić, dodać do niej drobno pokrojone pieczarki, doprawić solą, pieprzem i usmażyć. Kiełbasę pokroić, delikatnie podsmażyć bez tłuszczu. Pieczarki i kiełbasę dodać do żurku.",
//                "Do garnuszka wlać 5 łyżek wody, kopiatą łyżkę śmietany 18%, cały żurek w proszku i przyprawę do żurku. Zamieszać. Dodać szklankę gorącej wody i wymieszać. Wlać wszystko do garnka z żurkiem, zagotować.",
//                "Gdyby żurek był zbyt rzadki, zagęścić go śmietaną z mąką (wymieszać z żurkiem, aby konsystencja była jednolita i dopiero wtedy dolać do żurku i zagotować ponownie).",
//                "Podawać z pieczywem i jajkiem."));
//        recipe4.setIngredients(Arrays.asList(
//                new Ingredient(0.33, "szklanki zaczynu do żurku"),
//                new Ingredient(1.0, "duży ząbek czosnku"),
//                new Ingredient(0.5, "cebuli"),
//                new Ingredient(150.0, "g kiełbasy wiejskiej"),
//                new Ingredient(150.0, "g pieczarek"),
//                new Ingredient(1.0, "kopiata łyżka śmietany 18%"),
//                new Ingredient(1.0, "żurek w proszku"),
//                new Ingredient(1.0, "łyżeczka przyprawy do żurku"),
//                new Ingredient("mąka")));
//        recipe4.setPrepTimeMins((short)45);
//        recipe4.setWithCookingTimeMins((short)60);
//        recipe4.setImgUrl("https://cdn.aniagotuje.com/pictures/articles/2022/04/26826532-v-1500x1500.jpg");
//        recipe4.setEnergy((short) 450);
//        recipe4.setTags(Arrays.asList("Jedzenie"));
//        recipe4.setFavourite(true);
//
//        recipesRepository.save(recipe1);
//        recipesRepository.save(recipe2);
//        recipesRepository.save(recipe3);
//        recipesRepository.save(recipe4);
    }
}
