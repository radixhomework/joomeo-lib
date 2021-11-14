package io.github.radixhomework;

import io.github.radixhomework.service.SessionServices;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
@SpringBootApplication
class ClientTest {

    @Autowired
    private SessionServices services;

    @Test
    void createAndDeleteSession() {
        services.createSession();
        log.info(services.getSession().toString());
        services.deleteSession();
    }
}
