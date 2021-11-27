package io.github.radixhomework.service;

import io.github.radixhomework.enums.sorting.SortingDirection;
import io.github.radixhomework.enums.sorting.TagSortingField;
import io.github.radixhomework.enums.type.SessionType;
import io.github.radixhomework.model.Tag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class TagsServiceTest {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private TagsService tagsService;

    @Test
    void getSessionException() {
        try {
            tagsService.getTags(null);
        } catch (IllegalStateException ise) {
            assertEquals("Cannot get tags information because sessionId is null. May be no " +
                    "session have been initialized?", ise.getMessage());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void getTags() {
        try {
            sessionService.createSession(SessionType.MANAGER);
            SortedMap<TagSortingField, SortingDirection> sorting = new TreeMap<>();
            sorting.put(TagSortingField.LABEL, SortingDirection.ASCENDANT);
            List<Tag> tags = tagsService.getTags(sorting);
            assertTrue(tags.size() > 0);
            tags.forEach(tag -> log.info(tag.getLabel()));
            sessionService.deleteSession();
        } catch (Exception e) {
            fail();
            sessionService.deleteSession();
        }
    }
}
