package tesis.services.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.ForReportsSimpleRadar;
import tesis.entities.dtos.account.Subscription;
import tesis.entities.dtos.item.Category;
import tesis.entities.dtos.item.Item;
import tesis.services.RestClient;
import tesis.services.item.CategoryService;
import tesis.services.item.ItemService;

import java.util.ArrayList;

@Service
public class ReportService {

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    RestClient restClient;

    @Autowired
    ItemService itemService;

    @Autowired
    SubscriptionService subscriptionService;

    String urlBase = "https://rtge19cj13.execute-api.us-east-1.amazonaws.com/prod/generic_ep";

    public ForReportsSimpleRadar[] getSoldItemsByCategories() throws JsonProcessingException {
        ForDynamo forDynamo = new ForDynamo("items", "item_id");
        forDynamo.setIndexName("category");
        Category categories[] = categoryService.getAllCategory();
        ArrayList<ForReportsSimpleRadar> simpleRadar = new ArrayList<>();

        for (int i = 0; i < categories.length; i++) {

            ForReportsSimpleRadar simpleReport = new ForReportsSimpleRadar();
            simpleReport.setSubject(categories[i].getCategoryName());
            forDynamo.setSearchPattern(categories[i].getCategoryName());
            Item[] items = itemService.searchItems(forDynamo);

            for (Item item : items) {
                simpleReport.setValueA(simpleReport.getValueA() + (item.getInitialStock() - item.getStock()));
                simpleReport.setValueB(simpleReport.getValueA());
                simpleReport.setFullMark(simpleReport.getValueA());
            }
            simpleRadar.add(simpleReport);
        }

        return (ForReportsSimpleRadar[]) simpleRadar.toArray();
    }

    public ForReportsSimpleRadar[] getSubscriptionByCategories() throws JsonProcessingException {
        ForDynamo forDynamo = new ForDynamo("subscriptions", "subscription_id");
        forDynamo.setIndexName("category_name");    // TODO: Falta agregar el index category al a tabla para que funcione
        Category categories[] = categoryService.getAllCategory();
        ForReportsSimpleRadar simpleRadar[] = new ForReportsSimpleRadar[categories.length];
        Subscription subscription[] = new Subscription[0];
        Integer i = 0;
        for (Category category : categories) {
            simpleRadar[i] = new ForReportsSimpleRadar("", 0, 0, 0);
            simpleRadar[i].setSubject(category.getCategoryName());
            forDynamo.setSearchPattern(category.getCategoryName());
            subscription = subscriptionService.searchSubscription(forDynamo);
            simpleRadar[i].setSubject(category.getCategoryName());
            simpleRadar[i].setValueA(subscription.length);
            simpleRadar[i].setValueB(subscription.length);
            simpleRadar[i].setFullMark(subscription.length);
            i++;
        }
        return simpleRadar;
    }
}
