package io.github.radixhomework.configuration;

import io.github.radixhomework.JoomeoApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Value("${joomeo.base-url}")
    private String baseUrl;
    @Value("${joomeo.api-key}")
    private String apiKey;
    @Value("${joomeo.login}")
    private String login;
    @Value("${joomeo.password}")
    private String password;

    @Bean
    public JoomeoApiClient getClient() {
        JoomeoApiClient client = new JoomeoApiClient();
        client.setBaseUrl(baseUrl);
        client.setKey(apiKey);
        client.setLogin(login);
        client.setPassword(password);
        return client;
    }
}
