package tesis.controllers.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tesis.entities.dtos.mercadopago.PreferenceDTO;
import tesis.services.mercadopago.PreferenceService;
import tesis.services.mercadopago.UserServices;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MPController {
    @Autowired
    UserServices userServices;
    @Autowired
    PreferenceService preferenceService;

    @PostMapping("/mp/users/marketplace_auth")
    public String createMarketplaceAuth(@RequestParam Map<String, String> allParams) throws JsonProcessingException {
        return userServices.createMarketplaceAuth(allParams.get("code"), allParams.get("user_id"));
    }

    @PostMapping("/mp/preferences/create")
    public HashMap<String, String> createPreference(@RequestBody PreferenceDTO preferenceDTO) throws MPException, JsonProcessingException {
        return preferenceService.createPreference(preferenceDTO);
    }

}
