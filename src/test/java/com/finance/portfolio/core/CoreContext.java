package com.finance.portfolio.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finance.portfolio.config.CucumberSpringConfiguration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@WebMvcTest
public class CoreContext extends CucumberSpringConfiguration {

    @Autowired
    public MockMvc mockMvc;

    @LocalServerPort
    public int port;

    public static <T>  Object convertJSONStringToObject(String json, Class<T> objectClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return mapper.readValue(json, objectClass);
    }

    public MvcResult executeGet(String endpoint) throws Exception {
        String url = String.format("http://localhost:%d/%s", port, endpoint);
        return mockMvc.perform(get(url))
                .andReturn();
    }

    @WithMockUser(username = "user", password = "pwd", roles = "ADMIN")
    public MvcResult executeGetWithAuthentication(String endpoint) throws Exception {
        String url = String.format("http://localhost:%d/%s", port, endpoint);
        return mockMvc.perform(get(url)
                        .with(jwt()))
                .andReturn();
    }
}
