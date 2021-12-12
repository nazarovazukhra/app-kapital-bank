package uz.bank.kapital.appkapitalbank.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.service.StatisticsImplService;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    final StatisticsImplService statisticsImplService;

    public StatisticsController(StatisticsImplService statisticsImplService) {
        this.statisticsImplService = statisticsImplService;
    }

    /**
     * This return expired invoices
     *
     * @return expired invoice list
     */
    @GetMapping("/expired_invoices")
    public HttpEntity<?> expiredInvoices() {
        ApiResponse apiResponse = statisticsImplService.expiredInvoices();
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);

    }

    /**
     * This return wrong date invoice
     *
     * @return wrong date invoice
     */
    @GetMapping("/wrong_date_invoices")
    public HttpEntity<?> wrongDateInvoices() {
        ApiResponse apiResponse = statisticsImplService.wrongDateInvoices();
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);

    }

    /**
     * This return order  without details
     *
     * @return order  without details
     */
    @GetMapping("/orders_without_details")
    public HttpEntity<?> ordersWithoutDetails() {
        ApiResponse apiResponse = statisticsImplService.ordersWithoutDetails();
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);

    }

    /**
     * This return customer without order
     *
     * @return customer without order
     */

    @GetMapping("/customer_without_order")
    public HttpEntity<?> customerWithoutOrder() {

        ApiResponse apiResponse = statisticsImplService.customerWithoutOrder();
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);

    }

    /**
     * This return customer last order
     *
     * @return customer last order
     */

    @GetMapping("/customer_last_order")
    public HttpEntity<?> customerLastOrder() {

        ApiResponse apiResponse = statisticsImplService.customerLastOrder();
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);

    }

    /**
     * This return overpaid invoice
     *
     * @return overpaid invoice
     */


    @GetMapping("/overpaid_invoice")
    public HttpEntity<?> overpaidInvoice() {
        ApiResponse apiResponse = statisticsImplService.overpaidInvoice();
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);
    }

    /**
     * This return high demand products
     *
     * @return high demand products
     */
    @GetMapping("/high_demand_products")
    public HttpEntity<?> highDemandProducts() {
        ApiResponse apiResponse = statisticsImplService.highDemandProducts();
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);
    }

    /**
     * This return bulk products
     *
     * @return bulk products
     */
    @GetMapping("/bulk_products")
    public HttpEntity<?> bulkProducts() {
        ApiResponse apiResponse = statisticsImplService.bulkProducts();
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);
    }

    /**
     * This return number of products in year
     *
     * @return number of products in year
     */

    @GetMapping("/number_of_products_in_year")
    public HttpEntity<?> numberOfProductsInYear() {
        ApiResponse apiResponse = statisticsImplService.numberOfProductsInYear();
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);
    }

    /**
     * This return orders without invoices
     *
     * @return orders without invoices
     */
    @GetMapping("/orders_without_invoices")
    public HttpEntity<?> ordersWithoutInvoices() {
        ApiResponse apiResponse = statisticsImplService.ordersWithoutInvoices();
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);
    }

}
