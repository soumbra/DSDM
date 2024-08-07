package com.example.usoroomdatabase.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.usoroomdatabase.R;

import java.util.ArrayList;

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {

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

        holder.nome.setText(item.getNome());
        holder.curso.setText(item.getCurso());
        holder.idade.setText(String.valueOf(item.getIdade()));
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView nome;
        public TextView curso;
        public TextView idade;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nome = itemView.findViewById(R.id.textNome);
            curso = itemView.findViewById(R.id.textCurso);
            idade = itemView.findViewById(R.id.textIdade);
        }

        @Override
        public void onClick(View view) {
        }
    }
}
