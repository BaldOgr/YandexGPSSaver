package gps.baldogre.github.com.yandexgps.model;

import com.google.gson.annotations.SerializedName;

public class GeoObj {
    @SerializedName("GeoObject")
    private GeoObject geoObject;

    public GeoObject getGeoObject() {
        return geoObject;
    }

    public void setGeoObject(GeoObject geoObject) {
        this.geoObject = geoObject;
    }
}
