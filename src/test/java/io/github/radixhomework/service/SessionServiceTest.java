package io.github.radixhomework.service;

import io.github.radixhomework.enums.type.SessionType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
@SpringBootTest
@SpringBootApplication(scanBasePackages = "io.github.radixhomework")
class SessionServiceTest {

    @Autowired
    private SessionService services;

    @Test
    void getSessionException() {
        try {
            services.getSession();
        } catch (IllegalStateException ise) {
            assertEquals("Cannot get session information because sessionId is null. May be no " +
                    "session have been initialized?", ise.getMessage());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void deleteSessionException() {
        try {
            services.deleteSession();
        } catch (IllegalStateException ise) {
            assertEquals("Cannot delete session because sessionId is null. May be no " +
                    "session have been initialized?", ise.getMessage());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void createAndDeleteSession() {
        try {
            services.createSession(SessionType.MANAGER);
            log.info(services.getSession().toString());
            services.deleteSession();
        } catch (Exception e) {
            fail();
        }
    }
}
