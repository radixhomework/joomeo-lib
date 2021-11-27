package io.github.radixhomework.configuration;

import io.github.radixhomework.JoomeoApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class RestConfiguration {

    private final JoomeoApiClient client;

    /**
     * <p>Default RestTemplate configuration.</p>
     * <p><b>Must be extended/super-called for modifications.</b></p>
     *
     * @return A RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate =
                new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new JoomeoRequestInterceptor(client));
        restTemplate.setInterceptors(interceptors);

        restTemplate.setErrorHandler(new JoomeoResponseHandler());

        return restTemplate;
    }

}
