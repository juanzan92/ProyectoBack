package tesis.entities.builders.mercadopago;

import tesis.entities.dtos.account.Subscription;
import tesis.entities.dtos.mercadopago.MerchantOrder;

import java.util.Date;

public class SubscriptionBuilder {

    public static Subscription orderBuilder(MerchantOrder merchantOrder) {
        return new Subscription().setDateCreated(merchantOrder.getDateCreated() != null ? merchantOrder.getDateCreated() : new Date())
                .setItemId(merchantOrder.getItems().get(0).getId())
                .setQuantity(merchantOrder.getItems().get(0).getQuantity())
                .setPayment(merchantOrder.getPayments())
                .setPreferenceId(merchantOrder.getPreferenceId())
                .setRefundedAmount(merchantOrder.getRefundedAmount())
                .setShipments(merchantOrder.getShipments())
                .setPaidAmount(merchantOrder.getPaidAmount())
                .setTotalAmount(merchantOrder.getTotalAmount())
                .setUsername("pepito_comprador");
                /*.setUsername(merchantOrder.getPayer().getNickname())*test_user_94940646@testuser.com/
                .setVendorName(merchantOrder.getCollector().getNickname()); //TODO necesito obtener el vendor name , puede que no sea el misom en mp que en cognito*/
    }
}
