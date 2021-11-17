package io.github.radixhomework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.radixhomework.enums.EnumOrganisationType;
import io.github.radixhomework.enums.EnumSex;
import io.github.radixhomework.enums.EnumUserStatus;
import io.github.radixhomework.enums.EnumUserType;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class User {


    @JsonProperty("avatars")
    private Avatars avatars;

    @JsonProperty("covers")
    private Covers covers;

    @JsonProperty("onlineStore")
    private OnlineStore onlineStore;


    @JsonProperty("spaceName")
    private String spaceName;

    @JsonProperty("countryCode")
    private String countryCode;

    @JsonProperty("dateCreated")
    private OffsetDateTime dateCreated;

    @JsonProperty("privateURL")
    private String privateURL;

    @JsonProperty("privateURLHtml")
    @Deprecated(forRemoval = true) // September 2023
    private String privateURLHtml;

    @JsonProperty("coverMessage")
    private String coverMessage;

    @JsonProperty("userid")
    private String userId;

    @JsonProperty("status")
    private EnumUserStatus status;

    @JsonProperty("subscriptionid")
    @Deprecated
    private Integer subscriptionId;

    // FIXME: Bad format in API definition => integer<int32>
    @JsonProperty("offerid")
    private String offerId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zipCode")
    private String zipCode;

    @JsonProperty("organisation")
    private boolean organisation;

    @JsonProperty("organisationName")
    private String organisationName;

    @JsonProperty("organisationIdentificationNumber")
    private String organisationIdentificationNumber;

    @JsonProperty("organisationFirstname")
    private String organisationFirstname;

    @JsonProperty("organisationLastname")
    private String organisationLastname;

    @JsonProperty("organisationAddress")
    private String organisationAddress;

    @JsonProperty("organisationCity")
    private String organisationCity;

    @JsonProperty("organisationZipCode")
    private String organisationZipCode;

    @JsonProperty("organisationCountryCode")
    private String organisationCountryCode;

    @JsonProperty("organisationVatNumber")
    private String organisationVatNumber;

    @JsonProperty("organisationPhone")
    private String organisationPhone;

    @JsonProperty("organisationFax")
    private String organisationFax;

    @JsonProperty("organisationType")
    private EnumOrganisationType organisationType;

    @JsonProperty("shippingFirstname")
    private String shippingFirstname;

    @JsonProperty("shippingLastname")
    private String shippingLastname;

    @JsonProperty("shippingAddress")
    private String shippingAddress;

    @JsonProperty("shippingCity")
    private String shippingCity;

    @JsonProperty("shippingZipCode")
    private String shippingZipCode;

    @JsonProperty("shippingCountryCode")
    private String shippingCountryCode;

    @JsonProperty("sex")
    private EnumSex sex;

    @JsonProperty("birthdayDay")
    private Integer birthdayDay;

    @JsonProperty("birthdayMonth")
    private Integer birthdayMonth;

    @JsonProperty("birthdayYear")
    private Integer birthdayYear;

    @JsonProperty("dateLastVisit")
    private OffsetDateTime dateLastVisit;

    @JsonProperty("dateEndSubscription")
    private OffsetDateTime dateEndSubscription;

    @JsonProperty("langCode")
    private String langCode;

    @JsonProperty("newsletter")
    private boolean newsletter;

    @JsonProperty("userType")
    private EnumUserType userType;

    // FIXME: Not found in API definition...
    @JsonProperty("privateURLFlash")
    private String privateURLFlash;

}
