package konradstach.recipesbe.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@DynamoDBTable(tableName = "recipes")
@Getter
@Setter
@ToString
public class Recipe {

    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "steps")
    private List<String> steps = new ArrayList<>();

    @DynamoDBAttribute(attributeName = "tags")
    private List<String> tags = new ArrayList<>();

    @DynamoDBAttribute(attributeName = "portions")
    private short portions;

    @DynamoDBAttribute(attributeName = "ingredients")
    private List<Ingredient> ingredients = new ArrayList<>();

    @DynamoDBAttribute(attributeName = "favourite")
    private boolean favourite;

    @DynamoDBAttribute(attributeName = "prepTime")
    private short prepTimeMins;

    @DynamoDBAttribute(attributeName = "withCookingTime")
    private short withCookingTimeMins;

    @DynamoDBAttribute(attributeName = "imgUrl")
    private String imgUrl;

    @DynamoDBAttribute(attributeName = "energy")
    private short energy;

}
