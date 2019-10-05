package tesis.controllers.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tesis.entities.dtos.ForReportsSimpleRadar;
import tesis.services.account.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/get_sold_items_by_cat")
    public ForReportsSimpleRadar[] get_sold_items_by_cat() throws JsonProcessingException {
        return reportService.getSoldItemsByCategories();
    }

    @GetMapping("/get_sub_by_cat")
    public ForReportsSimpleRadar[] get_sub_by_cat() throws JsonProcessingException {
        return reportService.getSubscriptionByCategories();
    }

}
