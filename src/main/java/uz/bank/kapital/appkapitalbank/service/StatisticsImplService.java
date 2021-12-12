package uz.bank.kapital.appkapitalbank.service;

import org.springframework.stereotype.Service;
import uz.bank.kapital.appkapitalbank.entity.Invoice;
import uz.bank.kapital.appkapitalbank.payload.*;
import uz.bank.kapital.appkapitalbank.repository.DetailRepository;
import uz.bank.kapital.appkapitalbank.repository.InvoiceRepository;
import uz.bank.kapital.appkapitalbank.repository.OrderRepository;
import uz.bank.kapital.appkapitalbank.repository.PaymentRepository;

import java.util.List;

@Service
public class StatisticsImplService implements StatisticsService {

    final InvoiceRepository invoiceRepository;
    final OrderRepository orderRepository;
    final DetailRepository detailRepository;
    final PaymentRepository paymentRepository;

    public StatisticsImplService(InvoiceRepository invoiceRepository, OrderRepository orderRepository, DetailRepository detailRepository, PaymentRepository paymentRepository) {
        this.invoiceRepository = invoiceRepository;
        this.orderRepository = orderRepository;
        this.detailRepository = detailRepository;
        this.paymentRepository = paymentRepository;
    }

    /**
     * expiredInvoices
     *
     * @return invoiceList
     */
    @Override
    public ApiResponse expiredInvoices() {
        List<Invoice> invoiceList = invoiceRepository.expiredInvoices();

        try {
            if (!invoiceList.isEmpty())
                return new ApiResponse("SUCCESS", true, invoiceList);

            return new ApiResponse("EXPIRED INVOICE NOT FOUND", true);
        } catch (Exception e) {
            return new ApiResponse("FAILED", false);

        }

    }

    @Override
    public ApiResponse wrongDateInvoices() {

        List<Invoice> invoiceList = invoiceRepository.wrongDateInvoices();

        try {
            if (!invoiceList.isEmpty())
                return new ApiResponse("SUCCESS", true, invoiceList);

            return new ApiResponse("EXPIRED INVOICE NOT FOUND", true);
        } catch (Exception e) {
            return new ApiResponse("FAILED", false);

        }
    }

    @Override
    public ApiResponse ordersWithoutDetails() {
        List<OrderWithoutDetails> ordersWithoutDetails = orderRepository.ordersWithoutDetails();

        try {
            if (!ordersWithoutDetails.isEmpty())
                return new ApiResponse("SUCCESS", true, ordersWithoutDetails);

            return new ApiResponse("ORDERS WITHOUT NOT FOUND", true);
        } catch (Exception e) {
            return new ApiResponse("FAILED", false);

        }
    }


    @Override
    public ApiResponse customerWithoutOrder() {
        List<CustomerWithoutOrder> customerWithoutOrder = orderRepository.customerWithoutOrder();

        try {
            if (!customerWithoutOrder.isEmpty())
                return new ApiResponse("SUCCESS", true, customerWithoutOrder);

            return new ApiResponse("ORDERS WITHOUT NOT FOUND", true);
        } catch (Exception e) {
            return new ApiResponse("FAILED", false);

        }
    }


    @Override
    public ApiResponse customerLastOrder() {
        List<CustomerLastOrder> customerLastOrder = orderRepository.customerLastOrder();

        try {
            if (!customerLastOrder.isEmpty())
                return new ApiResponse("SUCCESS", true, customerLastOrder);

            return new ApiResponse("ORDERS WITHOUT NOT FOUND", true);
        } catch (Exception e) {
            return new ApiResponse("FAILED", false);

        }
    }

    @Override
    public ApiResponse overpaidInvoice() {
        List<OverpaidInvoiceDAO> overpaidInvoiceDAOS = paymentRepository.overpaidInvoice();
        if (!overpaidInvoiceDAOS.isEmpty())
            return new ApiResponse(true, overpaidInvoiceDAOS);
        return new ApiResponse("ERROR", false);
    }


    @Override
    public ApiResponse highDemandProducts() {
        List<HighDemandProducts> highDemandProducts = detailRepository.highDemandProducts();

        try {
            if (!highDemandProducts.isEmpty())
                return new ApiResponse("SUCCESS", true, highDemandProducts);

            return new ApiResponse("ORDERS WITHOUT NOT FOUND", true);
        } catch (Exception e) {
            return new ApiResponse("FAILED", false);

        }
    }

    @Override
    public ApiResponse bulkProducts() {
        List<BulkProducts> bulkProducts = detailRepository.bulkProducts();

        try {
            if (!bulkProducts.isEmpty())
                return new ApiResponse("SUCCESS", true, bulkProducts);

            return new ApiResponse("ORDERS WITHOUT NOT FOUND", true);
        } catch (Exception e) {
            return new ApiResponse("FAILED", false);

        }
    }

    @Override
    public ApiResponse numberOfProductsInYear() {

        List<NumberOfProductsInYear> numberOfProductsInYear = orderRepository.numberOfProductsInYear();

        try {
            if (!numberOfProductsInYear.isEmpty())
                return new ApiResponse("SUCCESS", true, numberOfProductsInYear);

            return new ApiResponse("ORDERS WITHOUT NOT FOUND", true);
        } catch (Exception e) {
            return new ApiResponse("FAILED", false);

        }
    }

    @Override
    public ApiResponse ordersWithoutInvoices() {
        List<OrdersWithoutInvoices> ordersWithoutInvoices = invoiceRepository.ordersWithoutInvoices();

        try {
            if (!ordersWithoutInvoices.isEmpty())
                return new ApiResponse("SUCCESS", true, ordersWithoutInvoices);

            return new ApiResponse("ORDERS WITHOUT NOT FOUND", true);
        } catch (Exception e) {
            return new ApiResponse("FAILED", false);

        }

    }
}
