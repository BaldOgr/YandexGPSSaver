package gps.baldogre.github.com.yandexgps.model;

import com.google.gson.annotations.SerializedName;

public class ServerResponse {
    @SerializedName("response")
    private Resp resp;

    public Resp getResp() {
        return resp;
    }

    public void setResp(Resp resp) {
        this.resp = resp;
    }
}
