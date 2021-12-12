package uz.bank.kapital.appkapitalbank.service;

import uz.bank.kapital.appkapitalbank.payload.ApiResponse;

public interface StatisticsService {

    ApiResponse overpaidInvoice();

    ApiResponse expiredInvoices();

    ApiResponse wrongDateInvoices();

    ApiResponse ordersWithoutDetails();

    ApiResponse customerWithoutOrder();

    ApiResponse customerLastOrder();

    ApiResponse highDemandProducts();

    ApiResponse bulkProducts();

    ApiResponse numberOfProductsInYear();

    ApiResponse ordersWithoutInvoices();
}
