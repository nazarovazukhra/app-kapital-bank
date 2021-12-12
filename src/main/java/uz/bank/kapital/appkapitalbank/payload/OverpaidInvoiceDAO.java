package uz.bank.kapital.appkapitalbank.payload;

public interface OverpaidInvoiceDAO {

    Double getPayedAmount();

    Double getTotalAmount();

    Double getDiffAmount();

    Integer getCustomerId();

    String getName();

    String getSurname();

}
