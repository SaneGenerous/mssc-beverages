package tp.msk.service;

import org.springframework.stereotype.Service;
import tp.msk.web.model.CustomerDTO;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .customerName("Ali Merrouni")
                .build();
    }
}
