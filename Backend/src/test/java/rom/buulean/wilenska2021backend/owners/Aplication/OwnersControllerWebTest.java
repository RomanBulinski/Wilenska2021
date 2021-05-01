package rom.buulean.wilenska2021backend.owners.Aplication;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rom.buulean.wilenska2021backend.owners.Aplication.port.OwnersUseCase;
import rom.buulean.wilenska2021backend.owners.Domain.Owner;
import rom.buulean.wilenska2021backend.owners.Web.OwnersController;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({OwnersController.class})
public class OwnersControllerWebTest {

    @MockBean
    OwnersUseCase ownersUseCase;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldGetAllOwners() throws Exception {
        // given
        Owner jan =  new Owner("Jan Kowalski");
        Owner stefan =  new Owner("Stefan Nowak");
        Mockito.when(ownersUseCase.findAll()).thenReturn(List.of(jan,stefan ));
        // expect
        mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

}
