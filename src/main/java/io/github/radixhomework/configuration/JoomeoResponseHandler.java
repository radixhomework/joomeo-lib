package io.github.radixhomework.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class JoomeoResponseHandler extends DefaultResponseErrorHandler {

    /**
     * Default response error handler
     *
     * @param response The response to handle
     * @return {@code true} if an error occured, {@code false} otherwise
     * @throws IOException In case of I/O errors
     */
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = response.getStatusCode();
        return statusCode.series() == HttpStatus.Series.SERVER_ERROR;
    }
}
