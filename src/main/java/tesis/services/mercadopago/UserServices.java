package tesis.services.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import tesis.entities.builders.mercadopago.VendorBuilder;
import tesis.entities.dtos.mercadopago.Vendor;
import tesis.services.RestClient;
import tesis.services.account.UserService;

@Service
public class UserServices {
    @Autowired
    RestClient restClient;
    @Autowired
    UserService userService;

    public String createMarketplaceAuth(String authCode, String username) throws JsonProcessingException {
        try {
            MultiValueMap<String, String> requestBody = VendorBuilder.buildVendorForDynamo(authCode, username);

            Vendor vendor = restClient.formRequest("https://api.mercadopago.com/oauth/token", requestBody, Vendor.class);
            vendor.setUsername(username);

            return userService.createVendorUser(vendor);
        } catch (Exception e) {
            throw e;
        }
    }
}
