package tp.msk.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tp.msk.service.BeerService;
import tp.msk.web.model.BeerDTO;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = BeerController.class)
@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDTO validBeer;

    @BeforeEach
    void setUp() {
        validBeer = BeerDTO.builder()
                .beerName("Yummy")
                .beerStyle("Cola")
                .upc(123456L)
                .build();
    }

    @Test
    void getBeer() throws Exception {
        when(beerService.getBeerById(any(UUID.class))).thenReturn(validBeer);

        mockMvc.perform(get("/api/v1/beer" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(validBeer.getId().toString())))
                .andExpect(jsonPath("$.beerName", is("Yummy")));
    }

    @Test
    void createNewBeer() throws Exception{
        BeerDTO beerDTO = validBeer;
        beerDTO.setId(null);
        BeerDTO savedBeer = BeerDTO.builder().id(UUID.randomUUID()).beerName("New Lemonade").build();
        String beerDTOJson =objectMapper.writeValueAsString(beerDTO);

        when(beerService.saveNewBeer(any())).thenReturn(savedBeer);

        mockMvc.perform(post("/api/v1/beer/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDTOJson))
                .andExpect(status().isCreated());
    }

    @Test
    void handleUpdateBeer() throws Exception {
        //given
        BeerDTO beerDTO = validBeer;
        beerDTO.setId(null);
        String beerDToJson = objectMapper.writeValueAsString(beerDTO);

        //when
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDToJson))
                .andExpect(status().isNoContent());

        //then
        then(beerService).should().updateBeer(any(), any());
    }
}