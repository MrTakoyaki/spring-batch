package com.example.demo.Vo;

public class XmlVo {
    private String version;
    private String UID;
    private String title;
    private String category;
    private String showUnit;
    private String descriptionFilterHtml;
    private String time;
    private String location;
    private String locationName;
    private String onsales;
    private String latitude;
    private String longitude;
    private String price;

    @Override
    public String toString() {
        return "XmlVo{" +
                "version='" + version + '\'' +
                ", UID='" + UID + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", showUnit='" + showUnit + '\'' +
                ", descriptionFilterHtml='" + descriptionFilterHtml + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", locationName='" + locationName + '\'' +
                ", onsales='" + onsales + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShowUnit() {
        return showUnit;
    }

    public void setShowUnit(String showUnit) {
        this.showUnit = showUnit;
    }

    public String getDescriptionFilterHtml() {
        return descriptionFilterHtml;
    }

    public void setDescriptionFilterHtml(String descriptionFilterHtml) {
        this.descriptionFilterHtml = descriptionFilterHtml;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getOnsales() {
        return onsales;
    }

    public void setOnsales(String onsales) {
        this.onsales = onsales;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
