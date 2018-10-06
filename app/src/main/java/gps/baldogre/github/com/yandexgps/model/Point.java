package gps.baldogre.github.com.yandexgps.model;

import com.google.gson.annotations.SerializedName;

public class Point {
    private double lat;
    private double lon;
    @SerializedName("pos")
    private String pos;

    public Point(String pos) {
        String[] strings = pos.split(" ");
        lat = Double.parseDouble(strings[1]);
        lon = Double.parseDouble(strings[0]);
    }

    public void setPos(String pos) {
        String[] strings = pos.split(" ");
        lat = Double.parseDouble(strings[1]);
        lon = Double.parseDouble(strings[0]);
    }

    public double getLat() {
        String[] strings = pos.split(" ");
        lat = Double.parseDouble(strings[1]);
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        String[] strings = pos.split(" ");
        lon = Double.parseDouble(strings[0]);
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "lat: " + lat + " long: " + lon;
    }
}
