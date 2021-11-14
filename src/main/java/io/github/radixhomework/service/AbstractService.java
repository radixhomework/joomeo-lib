package io.github.radixhomework.service;

import io.github.radixhomework.JoomeoApiClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractService implements IService {

    protected final RestTemplate restTemplate;
    protected final JoomeoApiClient client;

    /**
     * Main method for making a call to Joomeo's API.
     *
     * @param endpoint Endpoint to be called (the url prefix is added from configuration automatically)
     * @param verb     HTTP verb to perform
     * @param entity   Entity containing headers and body fo the call
     * @param clazz    Class to bind response
     * @return An object corresponding to the response of the call
     */
    @SuppressWarnings("java:S2259") // NPE found can't happen
    private <T, V> T call(String endpoint, HttpMethod verb, HttpEntity<V> entity, Class<T> clazz) {
        try {
            log.debug(entity.getHeaders().toString());
            if (entity.getBody() != null) {
                log.debug(entity.getBody().toString());
            }
            String url = client.getBaseUrl() + endpoint;
            ResponseEntity<T> response = restTemplate.exchange(url, verb, entity, clazz);
            log.info("{} - {} {}", response.getStatusCode(), verb, url);
            return response.getBody();
        } catch (RestClientException rce) {
            log.error("Error while calling endpoint", rce);
        }

        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error("Unable to instantiate an empty {}", clazz.getName());
        }
        return null;
    }

    /**
     * Main method for making a GET call to Joomeo's API.
     *
     * @param entity Entity containing headers and body fo the call
     * @param clazz  Class to bind response
     * @return An object corresponding to the response of the call
     */
    protected <T, V> T get(HttpEntity<V> entity, Class<T> clazz) {
        log.debug("Calling GET {}", getEndpoint());
        return call(getEndpoint(), HttpMethod.GET, entity, clazz);
    }

    /**
     * Main method for making a POST call to Joomeo's API.
     *
     * @param entity Entity containing headers and body fo the call
     * @param clazz  Class to bind response
     * @return An object corresponding to the response of the call
     */
    protected <T, V> T post(HttpEntity<V> entity, Class<T> clazz) {
        log.debug("Calling POST {}", getEndpoint());
        return call(getEndpoint(), HttpMethod.POST, entity, clazz);
    }

    /**
     * Main method for making a PUT call to Joomeo's API.
     *
     * @param entity Entity containing headers and body fo the call
     * @param clazz  Class to bind response
     * @return An object corresponding to the response of the call
     */
    protected <T, V> T put(HttpEntity<V> entity, Class<T> clazz) {
        log.debug("Calling PUT {}", getEndpoint());
        return call(getEndpoint(), HttpMethod.PUT, entity, clazz);
    }

    /**
     * Main method for making a DELETE call to Joomeo's API.
     *
     * @param entity Entity containing headers and body fo the call
     */
    protected <V> void delete(HttpEntity<V> entity) {
        log.debug("Calling DELETE {}", getEndpoint());
        call(getEndpoint(), HttpMethod.DELETE, entity, String.class);
    }

}
