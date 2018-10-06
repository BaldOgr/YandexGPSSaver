package gps.baldogre.github.com.yandexgps;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import gps.baldogre.github.com.yandexgps.model.GeoObj;
import gps.baldogre.github.com.yandexgps.model.GeoObject;

public class GPSRecyclerAdapter extends RecyclerView.Adapter<GPSRecyclerAdapter.ViewHolder> {

    private List<GeoObj> items;
    private SaveGPSCoordinatesView saveGPSCoordinatesView;

    public GPSRecyclerAdapter(SaveGPSCoordinatesView saveGPSCoordinatesView) {
        this.saveGPSCoordinatesView = saveGPSCoordinatesView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gps_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.textView.setText(items.get(i).getGeoObject().toString());
        viewHolder.root.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                saveGPSCoordinatesView.save(items.get(viewHolder.getAdapterPosition()).getGeoObject());
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public List<GeoObj> getItems() {
        return items;
    }

    public void setItems(List<GeoObj> items) {
        this.items = items;
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        View root;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            root = itemView.findViewById(R.id.root);
        }
    }
}
