package tesis.services.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tesis.entities.builders.dynamo.DynamoBuilder;
import tesis.entities.dtos.ForDynamo;
import tesis.entities.dtos.ForReportsSimpleRadar;
import tesis.entities.dtos.account.Subscription;
import tesis.entities.dtos.item.Category;
import tesis.entities.dtos.item.Item;
import tesis.services.RestClient;
import tesis.services.item.CategoryService;
import tesis.services.item.ItemService;

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
        ForReportsSimpleRadar simpleRadar[] = new ForReportsSimpleRadar[categories.length];
        Item items[] = new Item[0];
        Integer i = 0;
        for (Category category : categories) {
            simpleRadar[i] = new ForReportsSimpleRadar("", 0, 0, 0);
            simpleRadar[i].setSubject(category.getCategoryName());
            forDynamo.setSearchPattern(category.categoryName);
            items = itemService.searchItems(forDynamo);
            for (Item item : items) {
                simpleRadar[i].setValueA(simpleRadar[i].getValueA() + (item.getInitialStock() - item.getStock()));
                simpleRadar[i].setValueB(simpleRadar[i].getValueA());
                simpleRadar[i].setFullMark(simpleRadar[i].getValueA());
            }
            i++;
        }
        return simpleRadar;
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
            forDynamo.setSearchPattern(category.categoryName);
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
