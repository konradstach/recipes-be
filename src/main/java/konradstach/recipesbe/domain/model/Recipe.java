package konradstach.recipesbe.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@DynamoDBTable(tableName = "recipes")
@Getter
@Setter
public class Recipe {

    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "steps")
    private List<String> steps;

    @DynamoDBAttribute(attributeName = "tags")
    private List<String> tags;

    @DynamoDBAttribute(attributeName = "portions")
    private short portions;

    @DynamoDBAttribute(attributeName = "ingredients")
    private List<Ingredient> ingredients;

    @DynamoDBAttribute(attributeName = "favourite")
    private boolean favourite;

    @DynamoDBAttribute(attributeName = "prepTime")
    private String prepTime;

    @DynamoDBAttribute(attributeName = "withCookingTime")
    private String withCookingTime;

    @DynamoDBAttribute(attributeName = "imgUrl")
    private String imgUrl;

    @DynamoDBAttribute(attributeName = "energy")
    private short energy;

}
