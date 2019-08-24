package tesis.entities.builders.mercadopago;

import tesis.entities.dtos.account.Subscription;
import tesis.entities.dtos.mercadopago.MerchantOrder;

import java.util.Date;

public class SubscriptionBuilder {

    public static Subscription orderBuilder(MerchantOrder merchantOrder) {
        return new Subscription().setDateCreated(merchantOrder.getDateCreated() != null ? merchantOrder.getDateCreated() : new Date())
                .setItemId(merchantOrder.getItems().get(0).getId())
                .setQuantity(merchantOrder.getItems().get(0).getQuantity())
                .setPaidAmount(merchantOrder.getPaidAmount())
                .setPayment(merchantOrder.getPayments())
                .setPreferenceId(merchantOrder.getPreferenceId())
                .setRefundedAmount(merchantOrder.getRefundedAmount())
                .setShipments(merchantOrder.getShipments())
                .setTotalAmount(merchantOrder.getTotalAmount());
                /*.setVendorName(); TODO necesito obtener el vendor name , puede que no sea el misom en mp que en cognito*/

    }
}
