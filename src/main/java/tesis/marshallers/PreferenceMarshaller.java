package tesis.marshallers;

import com.mercadopago.resources.Preference;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

public class PreferenceMarshaller {

    public static HashMap<String, String> buildUrlPreference(@NotNull Preference preference) {
        HashMap<String, String> map = new HashMap<>();
        map.put("redirect_url", preference.getInitPoint());

        return map;
    }
}
