package uz.bank.kapital.appkapitalbank.payload;

import java.sql.Date;

public interface OrdersWithoutInvoices {


    Integer getOrderId();

    Date getDate();

    String getName();

    Integer getQuantity();

    Double getPrice();

    Double getEachProductTotalPrice();

}
