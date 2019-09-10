package tesis.controllers.mercadopago;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.mercadopago.Shipment;
import tesis.services.mercadopago.ShippingService;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    @Autowired
    ShippingService shippingService;

    @PutMapping()
    public String updateShipmentStatus(@RequestBody Shipment shipment) throws JsonProcessingException {
        return shippingService.updateShipment(shipment);
    }

    @PostMapping()
    public String createShipment(@RequestBody Shipment shipment) throws JsonProcessingException {
        return shippingService.createShipment(shipment);
    }
}
