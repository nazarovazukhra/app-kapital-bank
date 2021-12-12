package uz.bank.kapital.appkapitalbank.payload;

import java.sql.Date;

public interface CustomerLastOrder {

    Integer getCustomerId();

    String getName();

    String getSurname();

    Date getLastOrderDate();


}

