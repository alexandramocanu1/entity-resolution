package org.example;

public class Company {
    private String companyName;
    private String companyLegalNames;
    private String companyCommercialNames;
    private String mainCountryCode;
    private String mainCountry;
    private String mainRegion;
    private String mainCityDistrict;
    private String mainCity;
    private String mainPostcode;
    private String mainStreet;
    private String mainStreetNumber;
    private String mainLatitude;
    private String mainLongitude;
    private String mainAddressRawText;
    private String locations;
    private String numLocations;
    private String companyType;
    private String yearFounded;
    private String lnkYearFounded;
    private String shortDescription;
    private String longDescription;
    private String businessTags;
    private String businessModel;
    private String productType;
    private String naicsVertical;
    private String naics2022PrimaryCode;
    private String naics2022PrimaryLabel;
    private String naics2022SecondaryCodes;
    private String naics2022SecondaryLabels;
    private String mainBusinessCategory;
    private String mainIndustry;
    private String mainSector;
    private String primaryPhone;
    private String phoneNumbers;
    private String primaryEmail;
    private String emails;
    private String otherEmails;
    private String websiteUrl;
    private String websiteDomain;
    private String websiteTld;
    private String websiteLanguageCode;
    private String facebookUrl;
    private String twitterUrl;
    private String instagramUrl;
    private String linkedinUrl;
    private String iosAppUrl;
    private String androidAppUrl;
    private String youtubeUrl;
    private String tiktokUrl;
    private String alexaRank;
    private String sicsCodifiedIndustry;
    private String sicsCodifiedIndustryCode;
    private String sicsCodifiedSubsector;
    private String sicsCodifiedSubsectorCode;
    private String sicsCodifiedSector;
    private String sicsCodifiedSectorCode;
    private String sicCodes;
    private String sicLabels;
    private String isicV4Codes;
    private String isicV4Labels;
    private String naceRev2Codes;
    private String naceRev2Labels;
    private String createdAt;
    private String lastUpdatedAt;
    private String websiteNumberOfPages;
    private String generatedDescription;
    private String generatedBusinessTags;
    private String status;
    private String domains;
    private String allDomains;
    private String revenue;
    private String revenueType;
    private String employeeCount;
    private String employeeCountType;
    private String inboundLinksCount;

    public Company(String... values) {
        if (values.length != 75) {
            throw new IllegalArgumentException("Expected 75 values, got: " + values.length);
        }

        int i = 0;
        this.companyName = values[i++];
        this.companyLegalNames = values[i++];
        this.companyCommercialNames = values[i++];
        this.mainCountryCode = values[i++];
        this.mainCountry = values[i++];
        this.mainRegion = values[i++];
        this.mainCityDistrict = values[i++];
        this.mainCity = values[i++];
        this.mainPostcode = values[i++];
        this.mainStreet = values[i++];
        this.mainStreetNumber = values[i++];
        this.mainLatitude = values[i++];
        this.mainLongitude = values[i++];
        this.mainAddressRawText = values[i++];
        this.locations = values[i++];
        this.numLocations = values[i++];
        this.companyType = values[i++];
        this.yearFounded = values[i++];
        this.lnkYearFounded = values[i++];
        this.shortDescription = values[i++];
        this.longDescription = values[i++];
        this.businessTags = values[i++];
        this.businessModel = values[i++];
        this.productType = values[i++];
        this.naicsVertical = values[i++];
        this.naics2022PrimaryCode = values[i++];
        this.naics2022PrimaryLabel = values[i++];
        this.naics2022SecondaryCodes = values[i++];
        this.naics2022SecondaryLabels = values[i++];
        this.mainBusinessCategory = values[i++];
        this.mainIndustry = values[i++];
        this.mainSector = values[i++];
        this.primaryPhone = values[i++];
        this.phoneNumbers = values[i++];
        this.primaryEmail = values[i++];
        this.emails = values[i++];
        this.otherEmails = values[i++];
        this.websiteUrl = values[i++];
        this.websiteDomain = values[i++];
        this.websiteTld = values[i++];
        this.websiteLanguageCode = values[i++];
        this.facebookUrl = values[i++];
        this.twitterUrl = values[i++];
        this.instagramUrl = values[i++];
        this.linkedinUrl = values[i++];
        this.iosAppUrl = values[i++];
        this.androidAppUrl = values[i++];
        this.youtubeUrl = values[i++];
        this.tiktokUrl = values[i++];
        this.alexaRank = values[i++];
        this.sicsCodifiedIndustry = values[i++];
        this.sicsCodifiedIndustryCode = values[i++];
        this.sicsCodifiedSubsector = values[i++];
        this.sicsCodifiedSubsectorCode = values[i++];
        this.sicsCodifiedSector = values[i++];
        this.sicsCodifiedSectorCode = values[i++];
        this.sicCodes = values[i++];
        this.sicLabels = values[i++];
        this.isicV4Codes = values[i++];
        this.isicV4Labels = values[i++];
        this.naceRev2Codes = values[i++];
        this.naceRev2Labels = values[i++];
        this.createdAt = values[i++];
        this.lastUpdatedAt = values[i++];
        this.websiteNumberOfPages = values[i++];
        this.generatedDescription = values[i++];
        this.generatedBusinessTags = values[i++];
        this.status = values[i++];
        this.domains = values[i++];
        this.allDomains = values[i++];
        this.revenue = values[i++];
        this.revenueType = values[i++];
        this.employeeCount = values[i++];
        this.employeeCountType = values[i++];
        this.inboundLinksCount = values[i];
    }

    @Override
    public String toString() {
        return companyName + " - " + mainCity + ", " + mainCountry + " (" + mainIndustry + ")";
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyLegalNames() {
        return companyLegalNames;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public String getWebsiteDomain() {
        return websiteDomain;
    }

}