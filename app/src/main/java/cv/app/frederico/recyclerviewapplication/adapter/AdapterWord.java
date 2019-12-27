package cv.app.frederico.recyclerviewapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cv.app.frederico.recyclerviewapplication.R;

public class AdapterWord extends RecyclerView.Adapter<AdapterWord.WordViewHolder> {

    private Context context;
    private List<String> listName;
    String name;

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
        name = listName.get(position);

        // Add the data to the view
        holder.txtName.setText(name);

        // set position
        holder.position = position;

    }

    @Override
    public int getItemCount() {
        // Return the number of data items to display
        return this.listName.size();
    }



    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        //field to store name
        public final TextView txtName;

        //variable to store VIEW position
        public int position;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.tv_name);
            itemView.setOnCreateContextMenuListener(this);
            //simple click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Click "  + txtName.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, final View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            //menu header, optional
            menu.setHeaderTitle("Selecionar uma opção");
            //add CALL item to menu and implement click
            menu.add(0, itemView.getId(), 0, "Call").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    Toast.makeText(context, "CALL " + position, Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
            //add SMS item to menu and implement click
            menu.add(0, itemView.getId(), 0, "SMS").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    Toast.makeText(context, "SMS " + position, Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        }
    }
}
