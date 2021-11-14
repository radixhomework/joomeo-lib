package io.github.radixhomework.model;

import io.github.radixhomework.enums.EnumUserStatus;
import io.github.radixhomework.enums.EnumUserType;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class User {

    private Avatars avatars;
    private Covers covers;
    private OnlineStore onlineStore;

    private String spaceName;
    private String countryCode;
    private LocalDateTime dateCreated;
    private String privateURL;
    private String privateURLHtml;
    private String userid;
    private EnumUserStatus status;
    private Integer subscriptionid;
    private String offerid;
    private String email;
    private boolean organisation;
    private LocalDateTime dateLastVisit;
    private String langCode;
    private boolean newsletter;
    private EnumUserType userType;
    private String privateURLFlash;

    public String getDateCreated() {
        return this.dateCreated.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public void setDateCreated(String value) {
        this.dateCreated = LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME);
    }

    public String getDateLastVisit() {
        return this.dateLastVisit.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public void setDateLastVisit(String value) {
        this.dateLastVisit = LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME);
    }
}
