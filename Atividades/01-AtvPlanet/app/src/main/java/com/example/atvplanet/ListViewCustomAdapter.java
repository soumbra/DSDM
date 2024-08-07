package com.example.atvplanet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewCustomAdapter extends BaseAdapter{
    String[] sons;
    String[] descricoes;
    int [] imagens;
    Context context;

    ListViewCustomAdapter(Context context, String[] sons, String[] descricoes, int [] imagens){
        this.context = context;
        this.sons = sons;
        this.descricoes = descricoes;
        this.imagens = imagens;
    }

    @Override
    public int getCount() {
        return sons.length;
    }

    @Override
    public Object getItem(int position) {
        return sons[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvDesc = convertView.findViewById(R.id.tvDesc);
            viewHolder.ivSom = convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(sons[position]);
        viewHolder.tvDesc.setText(descricoes[position]);
        viewHolder.ivSom.setBackgroundResource(imagens[position]);

        return convertView;
    }

    static class ViewHolder{
        TextView tvName;
        TextView tvDesc;
        ImageView ivSom;
    }

}
