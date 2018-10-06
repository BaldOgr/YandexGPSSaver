package gps.baldogre.github.com.yandexgps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GeoObjectCollection {
    @SerializedName("featureMember")
    private List<GeoObj> geoObjects;

    public List<GeoObj> getGeoObjects() {
        return geoObjects;
    }

    public void setGeoObjects(List<GeoObj> geoObjects) {
        this.geoObjects = geoObjects;
    }
}
