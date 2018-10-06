package gps.baldogre.github.com.yandexgps.model;

import com.google.gson.annotations.SerializedName;

public class Resp {
    @SerializedName("GeoObjectCollection")
    private GeoObjectCollection collection;

    public GeoObjectCollection getCollection() {
        return collection;
    }

    public void setCollection(GeoObjectCollection collection) {
        this.collection = collection;
    }
}
