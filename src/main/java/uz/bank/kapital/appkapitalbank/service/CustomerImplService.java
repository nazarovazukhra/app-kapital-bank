package uz.bank.kapital.appkapitalbank.service;

import org.springframework.stereotype.Service;
import uz.bank.kapital.appkapitalbank.entity.Customer;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.repository.CustomerRepository;

@Service
public class CustomerImplService implements CustomerService {

    final CustomerRepository customerRepository;

    public CustomerImplService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ApiResponse add(Customer customer) {

        boolean exists = customerRepository.existsByNameAndSurnameAndPhone(
                customer.getName(),
                customer.getSurname(),
                customer.getPhone());

        if (exists)
            return new ApiResponse("Such customer already exits", false);

        Customer newCustomer = new Customer(
                customer.getName(),
                customer.getSurname(),
                customer.getCountry(),
                customer.getAddress(),
                customer.getPhone()
        );
        customerRepository.save(newCustomer);
        return new ApiResponse("Customer added", true);
    }
}
