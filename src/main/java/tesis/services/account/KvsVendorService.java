package tesis.services.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.ForReportsSimpleRadar;
import tesis.entities.dtos.account.KvsVendor;
import tesis.services.RestClient;

import java.util.ArrayList;
import java.util.Map;

@Service
public class KvsVendorService {

    @Autowired
    RestClient restClient;

    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/user_ep";
    ForDynamo forDynamo = new ForDynamo("kvs_vendor", "username");

    public KvsVendor getKvsVendor(Map<String, String> param) throws JsonProcessingException {
        return restClient.request(DynamoBuilder.getObject(param, forDynamo, urlBase), HttpMethod.GET, KvsVendor.class);
    }

    public String updateKvsVendor(String username, String graph, String category, Integer quantity) throws JsonProcessingException {
        KvsVendor kvsVendor = getKvsVendor(DynamoBuilder.buildMap("username", username));
        if (kvsVendor == null) {
            kvsVendor = new KvsVendor();
            kvsVendor.setUsername(username);
        }
        ArrayList<ForReportsSimpleRadar> graphList = graph == "graph01" ? kvsVendor.getGraph01() : kvsVendor.getGraph02();
        kvsVendor.updateGraphSimpleRadar(category, quantity, graphList);
        return restClient.request(urlBase, DynamoBuilder.saveObject(kvsVendor, forDynamo), HttpMethod.PUT, String.class);
    }
}
