package io.github.radixhomework;

import io.github.radixhomework.model.Session;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>Main class of the Joomeo's API Client.</p>
 * <p>Configuration and usage:</p>
 * <pre>
 * &#64;Configuration
 * public class JoomeoConfiguration {
 *
 *     &#64;Value("${config.key.base-url}")
 *     private String baseUrl;
 *
 *     &#64;Value("${config.key.login}")
 *     private String login;
 *
 *     &#64;Value("${config.key.password}")
 *     private String password;
 *
 *     &#64;Value("${config.key.api-key}")
 *     private String apiKey;
 *
 *     &#64;Bean
 *     public JoomeoApiClient getApiClient() {
 *         return new JoomeoApiClient(baseUrl, login, password, apiKey);
 *     }
 * }
 * </pre>
 */
@Data
@Slf4j
public class JoomeoApiClient {
    private String baseUrl;
    private String login;
    private String password;
    private String key;

    /**
     * Object for sharing session information across the whole Spring context.
     */
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Session session;

    /**
     * Internal method for saving current session into Spring's context.
     *
     * @param session The session to save.
     */
    public void saveSession(Session session) {
        log.info("Saving session information in context");
        this.session = session;
    }

    /**
     * Internal method for cleaning current saved session.
     */
    public void clearSession() {
        log.info("Cleaning session information from context");
        this.session = null;
    }

    /**
     * Utility method for retrieving the current sessionId.
     *
     * @return The current sessionId.
     */
    public String getSessionId() {
        if (session != null && session.getSessionId() != null && !session.getSessionId().isEmpty()) {
            return session.getSessionId();
        } else {
            return null;
        }
    }

    public String getSpaceName() {
        if (session != null && session.getSpaceName() != null && !session.getSpaceName().isEmpty()) {
            return session.getSpaceName();
        } else {
            return null;
        }
    }
}
