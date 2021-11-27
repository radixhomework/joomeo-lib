package io.github.radixhomework.configuration;

import io.github.radixhomework.JoomeoApiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static io.github.radixhomework.enums.JoomeoHeader.X_API_KEY;
import static io.github.radixhomework.enums.JoomeoHeader.X_SESSION_ID;

@Slf4j
@RequiredArgsConstructor
public class JoomeoRequestInterceptor implements ClientHttpRequestInterceptor {

    private final JoomeoApiClient client;

    /**
     * Main HTTP request interceptor for adding apiKey and sessionId values on the fly.
     *
     * @param request   The request intercepted
     * @param body      The body of the request
     * @param execution HTTP request executor
     * @return The HTTP response
     * @throws IOException In case of I/O errors
     */
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        // Adding API key to each request
        request.getHeaders().add(X_API_KEY.value(), client.getKey());

        // Adding session id if not null
        if (client.getSessionId() != null && !client.getSessionId().isEmpty()) {
            request.getHeaders().add(X_SESSION_ID.value(), client.getSessionId());
        }

        traceRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        traceResponse(response);
        return response;
    }

    /**
     * Simple Request logger
     *
     * @param request The request to be logged
     * @param body    The body of the request
     */
    private void traceRequest(HttpRequest request, byte[] body) {
        if (log.isDebugEnabled()) {
            log.debug("========== REQUEST BEGIN ===========");
            log.debug("URI         : {}", request.getURI());
            log.debug("Method      : {}", request.getMethod());

            String headersString = request.getHeaders().toString();
            // Preventing apiKey from being logged
            headersString = headersString.replaceAll(client.getKey(), "***");
            log.debug("Headers     : {}", headersString);

            String bodyString = new String(body, StandardCharsets.UTF_8);
            // Preventing password from being logged
            bodyString = bodyString.replaceAll(client.getPassword(), "***");
            log.debug("Request body: {}", bodyString);

            log.debug("=========== REQUEST END ============");
        }
    }

    /**
     * Simple Response logger
     *
     * @param response The response to be logged
     * @throws IOException In case of I/O errors
     */
    private void traceResponse(ClientHttpResponse response) throws IOException {
        if (log.isDebugEnabled()) {
            StringBuilder inputStringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(),
                    StandardCharsets.UTF_8));
            String line = bufferedReader.readLine();
            while (line != null) {
                inputStringBuilder.append(line);
                line = bufferedReader.readLine();
                if (line != null) {
                    inputStringBuilder.append('\n');
                }
            }
            log.debug("========== RESPONSE BEGIN ==========");
            log.debug("Status code  : {}", response.getStatusCode());
            log.debug("Status text  : {}", response.getStatusText());
            log.debug("Headers      : {}", response.getHeaders());
            log.debug("Response body: {}", inputStringBuilder);
            log.debug("=========== RESPONSE END ===========");
        }
    }

}
