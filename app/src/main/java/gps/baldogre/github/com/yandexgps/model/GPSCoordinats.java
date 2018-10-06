package gps.baldogre.github.com.yandexgps.model;

import com.google.gson.annotations.SerializedName;

public class GPSCoordinats {
    @SerializedName("Point")
    private Point point;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
