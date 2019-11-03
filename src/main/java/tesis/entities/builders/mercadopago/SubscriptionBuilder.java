package tesis.entities.builders.mercadopago;

import tesis.entities.dtos.account.Subscription;
import tesis.entities.dtos.account.User;
import tesis.entities.dtos.mercadopago.MerchantOrder;
import tesis.entities.enums.user.SubscriptionStatus;

import java.util.Date;

public class SubscriptionBuilder {

    public static Subscription orderBuilder(MerchantOrder merchantOrder, String vendorName, User consumer) {
        return new Subscription().setDateCreated(merchantOrder.getDateCreated() != null ? merchantOrder.getDateCreated() : new Date())
                .setMerchantOrderId(merchantOrder.getId())
                .setSubscriptionStatus(SubscriptionStatus.IN_PROGRESS)
                .setItemId(merchantOrder.getItems().get(0).getId())
                .setItemTitle(merchantOrder.getItems().get(0).getTitle())
                .setQuantity(merchantOrder.getItems().get(0).getQuantity())
                .setPayment(merchantOrder.getPayments())
                .setPreferenceId(merchantOrder.getPreferenceId())
                .setRefundedAmount(merchantOrder.getRefundedAmount())
                .setShipments(ShipmentBuilder.buildShipment())
                .setPaidAmount(merchantOrder.getPaidAmount())
                .setTotalAmount(merchantOrder.getTotalAmount())
                .setVendorName(vendorName)
                .setUsername(consumer.getUsername());
    }
}
