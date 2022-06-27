package dev.lambdac.clibatchgenrestinterface;

import dev.lambdac.clibatchgenrestinterface.repository.DataRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
public class ApiControllerTests extends BaseTest {

    @Autowired
    DataRecordRepository repository;

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void when_fetchData_then_Success() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                        get("/api/cli-batch-tx/get-data-file")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .param("queryString", "blah")
                                .param("pageNo", "0")
                                .param("pageSize", "100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse();

        Map<String, Object> respMap = jsonParser.parseMap(response.getContentAsString());
        assertTrue(respMap.size() > 0);
    }


}
