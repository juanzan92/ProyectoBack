package tesis.services.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.item.Review;
import tesis.services.RestClient;

import java.util.Map;

@Service
public class ReviewService {
    @Autowired
    RestClient restClient;
    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";
    ForDynamo forDynamo = new ForDynamo("reviews", "review_id");

    public String createReview(Review review) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(review, forDynamo), HttpMethod.POST, String.class);
    }

    public Review getReview(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getObject(param, forDynamo, urlBase), HttpMethod.GET, Review.class);
    }

    public Review[] getAllReview() throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getAllObject(forDynamo, urlBase + "/get_all"), HttpMethod.GET, Review[].class);
    }

    public Review[] searchReviews(Map<String, String> param) throws JsonProcessingException {
        ForDynamo searchParams = new ForDynamo("reviews", "review_id");
        searchParams.setSearchParams("item_id", param.get("item_id"));
        return restClient.request(DynamoBuilder.searchObjects(param, searchParams, urlBase + "/index_search"), HttpMethod.GET, Review[].class);
    }

    public String updateReview(Review review) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(review, forDynamo), HttpMethod.PUT, String.class);
    }

    public String deleteReview(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.getObject(param, forDynamo), HttpMethod.DELETE, String.class);
    }

}
