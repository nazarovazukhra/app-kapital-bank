package uz.bank.kapital.appkapitalbank.payload;

import java.sql.Date;

public interface OrderWithoutDetails {

    Integer getOrderId();
    Date getOrderDate();
    Integer customerId();
    String getName();
    String getSurname();
}
