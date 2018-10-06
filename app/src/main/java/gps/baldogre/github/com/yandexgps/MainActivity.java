package gps.baldogre.github.com.yandexgps;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import gps.baldogre.github.com.yandexgps.model.GeoObj;
import gps.baldogre.github.com.yandexgps.model.GeoObject;
import gps.baldogre.github.com.yandexgps.model.ServerResponse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements SaveGPSCoordinatesView {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("points", MODE_PRIVATE);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final GPSRecyclerAdapter adapter = new GPSRecyclerAdapter(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);
        EditText editText = findViewById(R.id.gps);
        editText.addTextChangedListener(new TextWatcher() {
            OkHttpClient client = new OkHttpClient.Builder().build();

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String url = "https://geocode-maps.yandex.ru/1.x/?format=json&geocode=" + s.toString();
                Log.d("MainActivity", "URL: " + url);
                client.newCall(new Request.Builder()
                        .get()
                        .url(url)
                        .build())
                        .enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                ServerResponse resp = new Gson().fromJson(response.body().string(), ServerResponse.class);
                                adapter.setItems(resp.getResp().getCollection().getGeoObjects());
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        adapter.notifyDataSetChanged();
                                    }
                                });
                            }
                        });
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void save(GeoObject geoObject) {
        sharedPreferences.edit()
                .putString(String.valueOf(UUID.randomUUID()), geoObject.getCoordinats().toString())
                .apply();
        Toast.makeText(this, "Saved!\n" +
                geoObject.toString(), Toast.LENGTH_SHORT).show();
    }
}
