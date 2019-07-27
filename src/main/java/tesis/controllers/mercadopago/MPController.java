package tesis.controllers.mercadopago;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadopago.core.MPResourceArray;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Card;
import com.mercadopago.resources.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.mercadopago.PreferenceDTO;
import tesis.services.mercadopago.PreferenceService;
import tesis.services.mercadopago.UserServices;

import java.util.ArrayList;
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
    public HashMap<String, String> createPreference(@RequestBody PreferenceDTO preferenceDTO) throws MPException {
        return preferenceService.createPreference(preferenceDTO);
    }

}
