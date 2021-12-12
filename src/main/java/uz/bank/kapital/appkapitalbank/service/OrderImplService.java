package uz.bank.kapital.appkapitalbank.service;

import org.springframework.stereotype.Service;
import uz.bank.kapital.appkapitalbank.entity.*;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.OrderDto;
import uz.bank.kapital.appkapitalbank.repository.*;

import java.sql.Date;
import java.util.*;

@Service
public class OrderImplService implements OrderService {

    final CustomerRepository customerRepository;
    final OrderRepository orderRepository;

    public OrderImplService(CustomerRepository customerRepository,OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public ApiResponse add(OrderDto orderDto) {

        Optional<Customer> optionalCustomer = customerRepository.findById(orderDto.getCustomerId());
        if (!optionalCustomer.isPresent())
            return new ApiResponse("Such customer not found", false);

        Order order = new Order();
        order.setDate(new Date(System.currentTimeMillis()));
        order.setCustomer(optionalCustomer.get());

        Invoice invoice = new Invoice(
                order, (double) 0,
                new Date(System.currentTimeMillis()), orderDto.getDue());

        order.setInvoice(invoice);
        orderRepository.save(order);
//
//        List<DetailDto> detailDto = orderDto.getDetailDto();
//
//        Double totalPriceOfProducts = (double) 0;
//        List<Detail> detailSet = new LinkedList<>();
//
//        if(detailDto!=null) {
//            for (DetailDto listDetailsItem : detailDto) {
//
//                Integer productId = listDetailsItem.getProductId();
//                Optional<Product> optionalProduct = productRepository.findById(productId);
//                if (!optionalProduct.isPresent())
//                    return new ApiResponse("Such product not found", false);
//
//                Detail detail = new Detail(
//                        savedOrder,
//                        optionalProduct.get(),
//                        listDetailsItem.getQuantity());
//                detailSet.add(detail);
//
//                Double price = optionalProduct.get().getPrice();
//                Short quantity = listDetailsItem.getQuantity();
//                totalPriceOfProducts += (price * quantity);
//
//            }
//
//            detailRepository.saveAll(detailSet);
//            Invoice orderInvoice = savedOrder.getInvoice();
//            orderInvoice.setAmount(totalPriceOfProducts);
//            invoiceRepository.save(orderInvoice);

            return new ApiResponse("SUCCESS", true, invoice.getId());

//        return new ApiResponse("There is no detail in order",true);
    }
}
