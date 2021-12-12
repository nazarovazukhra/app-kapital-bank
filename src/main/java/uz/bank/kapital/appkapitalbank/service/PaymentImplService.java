package uz.bank.kapital.appkapitalbank.service;

import org.springframework.stereotype.Service;
import uz.bank.kapital.appkapitalbank.entity.Invoice;
import uz.bank.kapital.appkapitalbank.entity.Payment;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.PaymentDto;
import uz.bank.kapital.appkapitalbank.repository.InvoiceRepository;
import uz.bank.kapital.appkapitalbank.repository.PaymentRepository;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class PaymentImplService implements PaymentService {


    final InvoiceRepository invoiceRepository;
    final PaymentRepository paymentRepository;

    public PaymentImplService(InvoiceRepository invoiceRepository, PaymentRepository paymentRepository) {
        this.invoiceRepository = invoiceRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public ApiResponse add(PaymentDto paymentDto) {

        Optional<Invoice> optionalInvoice = invoiceRepository.findById(paymentDto.getInvoiceId());
        if (!optionalInvoice.isPresent())
            return new ApiResponse("Such invoice not found", false);

        if (optionalInvoice.get().getAmount() > 0d) {
            Payment payment = new Payment();
            payment.setTime(new Timestamp(System.currentTimeMillis()));
            payment.setAmount(paymentDto.getAmount());
            payment.setInvoice(optionalInvoice.get());

            Payment savedPayment = paymentRepository.save(payment);
            return new ApiResponse("SUCCESS", true, savedPayment);
        }
        return new ApiResponse("FAILED", false);
    }
}
