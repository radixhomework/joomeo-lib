package io.github.radixhomework.service;

import io.github.radixhomework.enums.EnumSessionType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
@SpringBootTest
@SpringBootApplication(scanBasePackages = "io.github.radixhomework")
class SessionServiceTest {

    @Autowired
    private SessionService services;

    @Test
    void createAndDeleteSession() {
        try {
            services.createSession(EnumSessionType.MANAGER);
            log.info(services.getSession().toString());
            services.deleteSession();
        } catch (Exception e) {
            fail();
        }
    }
}
