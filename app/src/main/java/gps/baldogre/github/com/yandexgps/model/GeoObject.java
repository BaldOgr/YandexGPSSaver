package gps.baldogre.github.com.yandexgps.model;

import com.google.gson.annotations.SerializedName;

public class GeoObject {
    @SerializedName("description")
    private String description;
    @SerializedName("name")
    private String name;
    @SerializedName("Point")
    private Point coordinats;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getCoordinats() {
        return coordinats;
    }

    public void setCoordinats(Point coordinats) {
        this.coordinats = coordinats;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Description: " + description + "\n" +
                "Position: " + coordinats.getLat() + " " + coordinats.getLon();
    }

    public static GeoObject from(String next) {
        GeoObject geoObject = new GeoObject();
        geoObject.setName(next.substring(
                next.indexOf("Name: ") + 6,
                next.indexOf("Description")
        ));
        geoObject.setDescription(next.substring(
                next.indexOf("Description: ") + 13,
                next.indexOf("Position: ")
        ));

        geoObject.setCoordinats(new Point(next.substring(
                next.indexOf("Position: " + 10)
        )));
        return geoObject;
    }
}
