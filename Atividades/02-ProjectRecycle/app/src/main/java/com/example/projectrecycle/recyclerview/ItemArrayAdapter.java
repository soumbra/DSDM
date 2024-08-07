package com.example.projectrecycle.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projectrecycle.R;
import java.util.ArrayList;

public class ItemArrayAdapter  extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {
    private int listItemLayout;
    private ArrayList<Item> itemList;

    public ItemArrayAdapter(int layoutId, ArrayList<Item> itemList) {
        listItemLayout = layoutId;
        this.itemList = itemList;
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        Item item = itemList.get(listPosition);
        holder.item.setText(item.getName());
        holder.image.setImageResource(item.getImage());
        holder.descricao.setText(item.getDescricao());
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView item;
        public TextView descricao;
        public ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            item = itemView.findViewById(R.id.item);
            image = itemView.findViewById(R.id.image);
            descricao = itemView.findViewById(R.id.descricao);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Indo para a área de " + item.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
