package tesis.services.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForBarReport;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.ForReportsSimpleRadar;
import tesis.entities.dtos.account.KvsVendor;
import tesis.entities.dtos.account.Subscription;
import tesis.entities.dtos.item.Item;
import tesis.services.RestClient;

import java.util.ArrayList;
import java.util.Date;
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

    public String updateKvsVendor(String username, String category, Integer quantity) throws JsonProcessingException {
        KvsVendor kvsVendor = getKvsVendor(DynamoBuilder.buildMap("username", username));
        if (kvsVendor == null) {
            kvsVendor = new KvsVendor();
            kvsVendor.setUsername(username);
        }

        updateGraphSimpleRadar(category, 1, kvsVendor.getGraph01());
        updateGraphSimpleRadar(category, quantity, kvsVendor.getGraph02());
        updateBarGraph(kvsVendor.getGraph03(), quantity);

        return restClient.request(urlBase, DynamoBuilder.saveObject(kvsVendor, forDynamo), HttpMethod.PUT, String.class);
    }

    public void updateGraphSimpleRadar(String category, Integer quantity, ArrayList<ForReportsSimpleRadar> graph) {
        boolean found = false;
        for (ForReportsSimpleRadar radar : graph) {
            if (radar.getSubject() != null && radar.getSubject().contains(category)) {
                radar.setValueA(radar.getValueA() + quantity);
                radar.setValueB(radar.getValueA());
                radar.setFullMark(radar.getValueA());
                found = true;
            }
        }
        if (!found) {
            graph.add(new ForReportsSimpleRadar(category, quantity, quantity, quantity));
        }
    }

    public void updateBarGraph(ArrayList<ForBarReport> graph, int quantity) {
        Integer month = new Date().getMonth()+1;

        if (graph.size() == 0) {
            for (int i = 1; i <= 12; i++) {
                ForBarReport barReport = new ForBarReport();
                barReport.setMonth(new Integer(i));
                barReport.setQuantity(new Integer(0));
                ForBarReport newMonth = barReport;
                graph.add(newMonth);
            }
        }
        for (ForBarReport monthReport : graph) {
            if (monthReport.getMonth().equals(new Integer(month))) {

                monthReport.setQuantity(monthReport.getQuantity() + new Integer(quantity));
                break;
            }
        }
    }

    public String updateKvs(Item item, Subscription subscription) throws JsonProcessingException {
        return updateKvsVendor(item.getVendorUsername(), item.getCategory(), subscription.getQuantity());
    }
}
