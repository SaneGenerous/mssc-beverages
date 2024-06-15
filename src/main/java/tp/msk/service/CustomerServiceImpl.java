package tp.msk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tp.msk.web.model.CustomerDTO;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .customerName("Ali Merrouni")
                .build();
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .customerName("Jamal Mashburn")
                .build();
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customerDTO) {
        //todo - impl customer update
        log.debug("Updating ....");
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("Deleting a customer....");
    }
}
