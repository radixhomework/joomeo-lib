package io.github.radixhomework.service;

import io.github.radixhomework.JoomeoApiClient;
import io.github.radixhomework.enums.format.DateTimeFormat;
import io.github.radixhomework.enums.sorting.SortingDirection;
import io.github.radixhomework.enums.sorting.TagSortingField;
import io.github.radixhomework.model.NewSession;
import io.github.radixhomework.model.Tag;
import io.github.radixhomework.model.TagList;
import io.github.radixhomework.util.SortingUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.SortedMap;

import static io.github.radixhomework.enums.JoomeoHeader.X_DATETIME_FORMAT;
import static io.github.radixhomework.enums.JoomeoHeader.X_LIST_SORT;

/**
 * <p>Tags services.</p>
 * <p>After defining a {@link JoomeoApiClient} Spring bean, the services can be used with standard autowiring:
 * </p>
 * <pre>
 * &#64;Autowiring
 * private TagsService service;
 *
 * public void connectAndDisconnect() {
 *
 * }
 * </pre>
 */
@Slf4j
@Service
@SuppressWarnings("java:S1170") // Spring Service => One per context
public class TagsService extends AbstractService {

    @Getter
    private final String endpoint = "/users/" + SPACE_NAME + "/tags";

    // Can't use lombok annotations when super constructor call is needed.
    public TagsService(RestTemplate restTemplate, JoomeoApiClient client) {
        super(restTemplate, client);
    }

    /**
     * Service for getting all tags from Joomeo's space.
     *
     * @param sortingFields How fields are sorted
     * @return A list of Tags
     */
    public List<Tag> getTags(SortedMap<TagSortingField, SortingDirection> sortingFields) {
        if (client.getSessionId() != null && !client.getSessionId().isEmpty()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(X_DATETIME_FORMAT.value(), DateTimeFormat.UTC.getValue());
            if (sortingFields != null && !sortingFields.isEmpty()) {
                headers.add(X_LIST_SORT.value(), SortingUtils.toCsv(sortingFields));
            }
            HttpEntity<NewSession> httpEntity = new HttpEntity<>(headers);

            TagList tagList = get(httpEntity, TagList.class);
            log.debug("Elements returned: {}", tagList.getTags().size());
            return tagList.getTags();
        } else {
            throw new IllegalStateException("Cannot get tags information because sessionId is null. May be no " +
                    "session have been initialized?");
        }
    }
}
