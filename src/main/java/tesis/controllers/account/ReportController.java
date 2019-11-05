package tesis.controllers.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tesis.entities.dtos.ForReportsSimpleRadar;
import tesis.services.account.ReportService;

@RestController
@CrossOrigin(allowedHeaders = "*", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/sold_by_category")
    public ForReportsSimpleRadar[] getSoldItemsByCategory() throws JsonProcessingException {
        return reportService.getSoldItemsByCategories();
    }

    @GetMapping("/subscription_by_cat")
    public ForReportsSimpleRadar[] getSubscriptionByCategory() throws JsonProcessingException {
        return reportService.getSubscriptionByCategories();
    }

}
