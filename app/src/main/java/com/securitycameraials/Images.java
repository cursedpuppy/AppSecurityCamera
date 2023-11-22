package com.securitycameraials;

public class Images {
    private String imageUrl;

    // Constructor vacío requerido por Firebase
    public Images() {}

    public Images(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
