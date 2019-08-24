package tesis.entities.builders.mercadopago;

import tesis.entities.dtos.account.Subscription;
import tesis.entities.dtos.mercadopago.MerchantOrder;

import java.util.Date;

public class SubscriptionBuilder {

    public static Subscription orderBuilder(MerchantOrder merchantOrder, String vendorName, String consumerName) {
        return new Subscription().setDateCreated(merchantOrder.getDateCreated() != null ? merchantOrder.getDateCreated() : new Date())
                .setItemId(merchantOrder.getItems().get(0).getId())
                .setQuantity(merchantOrder.getItems().get(0).getQuantity())
                .setPayment(merchantOrder.getPayments())
                .setPreferenceId(merchantOrder.getPreferenceId())
                .setRefundedAmount(merchantOrder.getRefundedAmount())
                .setShipments(merchantOrder.getShipments())
                .setPaidAmount(merchantOrder.getPaidAmount())
                .setTotalAmount(merchantOrder.getTotalAmount())
                .setVendorName(vendorName)
                .setUsername(consumerName);
    }
}
