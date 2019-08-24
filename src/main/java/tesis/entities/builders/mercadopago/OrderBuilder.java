package tesis.entities.builders.mercadopago;

import tesis.entities.dtos.mercadopago.MerchantOrder;
import tesis.entities.dtos.mercadopago.Order;

import java.util.Date;

public class OrderBuilder {

    public static Order orderBuilder(MerchantOrder merchantOrder) {
        return new Order().setDateCreated(merchantOrder.getDateCreated() != null ? merchantOrder.getDateCreated() : new Date())
                .setItemId(merchantOrder.getItems().get(0).getId())
                .setPaidAmount(merchantOrder.getPaidAmount())
                .setPayment(merchantOrder.getPayments())
                .setPreferenceId(merchantOrder.getPreferenceId())
                .setRefundedAmount(merchantOrder.getRefundedAmount())
                .setShipments(merchantOrder.getShipments())
                .setTotalAmount(merchantOrder.getTotalAmount());
        /*.setVendorName(); TODO necesito obtener el vendor name , puede que no sea el misom en mp que en cognito*/

    }
}
