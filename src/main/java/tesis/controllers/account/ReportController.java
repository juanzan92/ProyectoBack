package tesis.controllers.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.ForReportsSimpleRadar;
import tesis.entities.dtos.account.KvsVendor;
import tesis.services.account.KvsVendorService;
import tesis.services.account.ReportService;

import java.util.Map;

@RestController
@CrossOrigin(allowedHeaders = "*", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    ReportService reportService;

    @Autowired
    KvsVendorService kvsVendorService;

    @GetMapping("/sold_by_category")
    public ForReportsSimpleRadar[] getSoldItemsByCategory() throws JsonProcessingException {
        return reportService.getSoldItemsByCategories();
    }

    @GetMapping("/subscription_by_cat")
    public ForReportsSimpleRadar[] getSubscriptionByCategory() throws JsonProcessingException {
        return reportService.getSubscriptionByCategories();
    }

    @GetMapping()
    public KvsVendor getKvsVendor(@RequestParam Map<String, String> param) throws JsonProcessingException {
        return kvsVendorService.getKvsVendor(param);
    }

    @PutMapping()
    public String updateKvsVendor(@RequestParam Map<String, String> param) throws JsonProcessingException {
        return kvsVendorService.updateKvsVendor(param.get("username"), param.get("category"), new Integer(param.get("quantity")));
    }
}
