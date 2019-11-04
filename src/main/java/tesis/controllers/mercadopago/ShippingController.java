package tesis.controllers.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.mercadopago.Shipment;
import tesis.services.mercadopago.ShippingService;

import java.util.ArrayList;

@RestController
@CrossOrigin(allowedHeaders = "*", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/shipping")
public class ShippingController {
    @Autowired
    ShippingService shippingService;

    @PutMapping()
    public String updateShipmentStatus(@RequestHeader("subscription_id") String subscriptionId, @RequestBody Shipment shipment) throws Exception {
        return shippingService.updateShipment(subscriptionId, shipment);
    }

    @PostMapping()
    public String createShipment(@RequestBody Shipment shipment) throws JsonProcessingException {
        return shippingService.createShipment(shipment);
    }

    @GetMapping
    public ArrayList<Shipment> getShipments(@RequestParam("subscription_id") String subscriptionId) throws JsonProcessingException {
        return shippingService.getShipments(subscriptionId);
    }
}
