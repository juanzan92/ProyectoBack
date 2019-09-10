package tesis.services.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.mercadopago.Shipment;
import tesis.services.RestClient;

import javax.validation.constraints.NotNull;

@Service
public class ShippingService {
    @Autowired
    RestClient restClient;
    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";
    ForDynamo forDynamo = new ForDynamo("shipments", "shipment_id");

    public String createShipment(@NotNull Shipment shipment) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(shipment, forDynamo), HttpMethod.POST, String.class);
    }

    public String updateShipment(@NotNull Shipment shipment) throws JsonProcessingException {
        return restClient.request(urlBase, DynamoBuilder.saveObject(shipment, forDynamo), HttpMethod.PUT, String.class);
    }
}
