package cv.app.frederico.recyclerviewapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cv.app.frederico.recyclerviewapplication.R;

public class AdapterWord extends RecyclerView.Adapter<AdapterWord.WordViewHolder> {

    private Context context;
    private List<String> listName;

    public AdapterWord(Context context, List<String> listName) {
        this.context = context;
        this.listName = listName;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create view from layout
        View item = LayoutInflater
                .from(context)
                .inflate(R.layout.item_list_recycler, parent, false);

        return new WordViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        // Retrieve the data for that position
        String name = listName.get(position);

        // Add the data to the view
        holder.txtName.setText(name);
    }

    @Override
    public int getItemCount() {
        // Return the number of data items to display
        return this.listName.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder{
        public final TextView txtName;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.tv_name);
        }
    }
}
