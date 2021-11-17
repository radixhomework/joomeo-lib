package io.github.radixhomework.service;

import io.github.radixhomework.JoomeoApiClient;
import io.github.radixhomework.enums.EnumDateTimeFormat;
import io.github.radixhomework.enums.EnumSessionType;
import io.github.radixhomework.model.NewSession;
import io.github.radixhomework.model.Session;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static io.github.radixhomework.enums.EnumJoomeoHeader.X_DATETIME_FORMAT;
import static io.github.radixhomework.enums.EnumJoomeoHeader.X_PAYLOAD_TYPE;

/**
 * <p>Session services.</p>
 * <p>After defining a {@link JoomeoApiClient} Spring bean, the services can be used with standard autowiring:
 * </p>
 * <pre>
 * &#64;Autowiring
 * private SessionService service;
 *
 * public void connectAndDisconnect() {
 *     service.createSession();
 *     Session session = service.getSession();
 *
 *     log.info(session);
 *
 *     service.deleteSession();
 * }
 * </pre>
 */
@Slf4j
@Service
@SuppressWarnings("java:S1170") // Spring Service => One per context
public class SessionService extends AbstractService {

    @Getter
    private final String endpoint = "/session";

    // Can't use lombok annotations when super constructor call is needed.
    public SessionService(RestTemplate restTemplate, JoomeoApiClient client) {
        super(restTemplate, client);
    }

    /**
     * Service for initializing a {@link Session}.
     * This if the first call to be done when using Joomeo's API.
     */
    public void createSession(EnumSessionType sessionType) {
        NewSession newSession = new NewSession();
        newSession.setLogin(client.getLogin());
        newSession.setPassword(client.getPassword());

        log.info("Initiating new session with: {}", newSession);

        HttpHeaders headers = new HttpHeaders();
        headers.add(X_PAYLOAD_TYPE.value(), sessionType.getValue());
        HttpEntity<NewSession> httpEntity = new HttpEntity<>(newSession, headers);

        Session session = post(httpEntity, Session.class);

        client.saveSession(session);
        log.debug("Initiated session: {}", session);
    }

    /**
     * Service for retrieving current session information.
     *
     * @return The current {@link Session}
     */
    public Session getSession() {
        if (client.getSessionId() != null && !client.getSessionId().isEmpty()) {
            log.info("Getting session {} information", client.getSessionId());

            HttpHeaders headers = new HttpHeaders();
            headers.add(X_DATETIME_FORMAT.value(), EnumDateTimeFormat.UTC.getValue());
            HttpEntity<NewSession> httpEntity = new HttpEntity<>(headers);

            Session session = get(httpEntity, Session.class);

            log.debug("Initiated session: {}", session);
            return session;
        } else {
            throw new IllegalStateException("Cannot get session information because sessionId is null. May be no " +
                    "session have been initialized ?");
        }
    }

    /**
     * Service for closing and deleting the current {@link Session}.
     * This might be the last thing to do when using Joomeo's API.
     */
    public void deleteSession() {
        if (client.getSessionId() != null && !client.getSessionId().isEmpty()) {
            log.info("Deleting session {}", client.getSessionId());

            HttpHeaders headers = new HttpHeaders();
            headers.add(X_DATETIME_FORMAT.value(), EnumDateTimeFormat.UTC.getValue());
            HttpEntity<NewSession> httpEntity = new HttpEntity<>(headers);

            delete(httpEntity);
            client.clearSession();
        } else {
            throw new IllegalStateException("Cannot delete session because sessionId is null. May be no session have " +
                    "been initialized ?");
        }
    }
}
