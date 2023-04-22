package com.finance.portfolio.core;

import com.finance.portfolio.config.CucumberSpringConfiguration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoreContext extends CucumberSpringConfiguration {

    @Autowired
    public TestRestTemplate testRestTemplate;

    @LocalServerPort
    public int port;

    public ResponseEntity<?> executeGet(String url) {
        String baseUrl = String.format("http://localhost:%d/%s", port, url);
        ResponseEntity<String> response = testRestTemplate.
                getForEntity("http://localhost:"+ port + "/" + url, String.class);
        return response;
    }
}
