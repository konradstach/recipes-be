package konradstach.recipesbe.infrastructure.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "konradstach.recipesbe.infrastructure.repository")
public class DynamoDbConfig {
    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AWSCredentialsProvider credentials =
                new ProfileCredentialsProvider("konradstach");

        return AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(credentials)
                .withRegion(Regions.US_EAST_1)
                .build();
    }
}
