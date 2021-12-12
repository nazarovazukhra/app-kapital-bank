package uz.bank.kapital.appkapitalbank.service;

import org.springframework.stereotype.Service;
import uz.bank.kapital.appkapitalbank.entity.Detail;
import uz.bank.kapital.appkapitalbank.entity.Invoice;
import uz.bank.kapital.appkapitalbank.entity.Order;
import uz.bank.kapital.appkapitalbank.entity.Product;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.DetailDto;
import uz.bank.kapital.appkapitalbank.repository.DetailRepository;
import uz.bank.kapital.appkapitalbank.repository.InvoiceRepository;
import uz.bank.kapital.appkapitalbank.repository.OrderRepository;
import uz.bank.kapital.appkapitalbank.repository.ProductRepository;

import java.util.*;

@Service
public class DetailImplService implements DetailService {

    final DetailRepository detailRepository;
    final OrderRepository orderRepository;
    final ProductRepository productRepository;
    final InvoiceRepository invoiceRepository;

    public DetailImplService(DetailRepository detailRepository, OrderRepository orderRepository, ProductRepository productRepository, InvoiceRepository invoiceRepository) {
        this.detailRepository = detailRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public ApiResponse add(Set<DetailDto> detailDto) {

        Double totalPriceOfProducts = 0d;
        Set<Detail> detailSet = new LinkedHashSet<>();
        Integer orderId = null;
        for (DetailDto listDetailsItem : detailDto) {

            orderId = listDetailsItem.getOrderId();
            Optional<Order> optionalOrder = orderRepository.findById(orderId);
            if (!optionalOrder.isPresent())
                return new ApiResponse("Such order not found", false);

            Integer productId = listDetailsItem.getProductId();
            Optional<Product> optionalProduct = productRepository.findById(productId);
            if (!optionalProduct.isPresent())
                return new ApiResponse("Such product not found", false);

            Detail detail = new Detail(
                    optionalOrder.get(),
                    optionalProduct.get(),
                    listDetailsItem.getQuantity());

            detailSet.add(detail);

            Double price = optionalProduct.get().getPrice();
            Short quantity = listDetailsItem.getQuantity();
            totalPriceOfProducts += (price * quantity);

        }

        Optional<Invoice> optionalInvoice = invoiceRepository.findByOrderId(orderId);
        if (!optionalInvoice.isPresent())
            return new ApiResponse("Such invoice with this orderId not found", false);

        detailRepository.saveAll(detailSet);

        Invoice invoice = optionalInvoice.get();
        invoice.setAmount(totalPriceOfProducts);
        invoiceRepository.save(invoice);

        return new ApiResponse("Detail added", true);
    }

    @Override
    public ApiResponse getProductDetailsByProductId(Integer productId) {


        List<Detail> allDetailsByProductId = detailRepository.findAllByProductId(productId);
        if (!allDetailsByProductId.isEmpty())
            return new ApiResponse("Such detail not found with this product id", false);
        return new ApiResponse(true, allDetailsByProductId);
    }
}
