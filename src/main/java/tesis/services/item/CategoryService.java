package tesis.services.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.services.RestClient;
import tesis.entities.dtos.item.Category;

import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    RestClient restClient;
    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";
    ForDynamo forDynamo = new ForDynamo("categories", "category_id");

    public String createCategory(Category category) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(category, forDynamo), HttpMethod.POST, String.class);
    }

    public Category getCategory(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getObject(param, forDynamo, urlBase), HttpMethod.GET, Category.class);
    }

    public Category[] searchCategories(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.searchObjects(param, forDynamo, urlBase + "/index_search"), HttpMethod.GET, Category[].class);
    }

    public String updateCategory(Category category) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(category, forDynamo), HttpMethod.PUT, String.class);
    }

    public String deleteCategory(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.getObject(param, forDynamo), HttpMethod.DELETE, String.class);
    }
}
