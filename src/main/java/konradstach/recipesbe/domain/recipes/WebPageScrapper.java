package konradstach.recipesbe.domain.recipes;

import konradstach.recipesbe.domain.model.ScrappedRecipeDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class WebPageScrapper {

    public ScrappedRecipeDTO getScrappedRecipeFromKwestiaSmaku(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Element body = doc.body();
            String recipeName = getRecipeName(body);
            String imgUrl = getImgUrl(body);
            String servings = getPortions(body);
            String ingredients = getIngredients(body);
            String steps = getSteps(body);

            return new ScrappedRecipeDTO(recipeName, imgUrl, servings, ingredients, steps);
        } catch (IOException e) {

        }
        return null;
    }

    private String getPortions(Element body) {
        Element porcje = body.getElementsByClass("field-name-field-ilosc-porcji").first();
        if (porcje != null) {
            String servingsText = porcje.text();
            return servingsText.replaceAll("\\D+","");
        }
        return null;
    }

    private String getRecipeName(Element body) {
        Element pageHeader = body.getElementsByClass("page-header").first();
        return pageHeader.text();
    }

    private String getIngredients(Element body) {
        Element skladniki = body.getElementsByClass("field-name-field-skladniki").first();
        Element ul = skladniki.getElementsByTag("ul").first();
        Elements listItems = ul.getElementsByTag("li");
        return listItems.stream().map(Element::text).collect(Collectors.joining("\n"));
    }

    private String getSteps(Element body) {
        Element przygotowanie = body.getElementsByClass("field-name-field-przygotowanie").first();
        Element ul = przygotowanie.getElementsByTag("ul").first();
        Elements listItems = ul.getElementsByTag("li");
        return listItems.stream().map(Element::text).collect(Collectors.joining("\n"));
    }

    private String getImgUrl(Element body) {
        Element img = body.getElementsByClass("img-responsive").first();
        return img.attr("src");
    }
}
