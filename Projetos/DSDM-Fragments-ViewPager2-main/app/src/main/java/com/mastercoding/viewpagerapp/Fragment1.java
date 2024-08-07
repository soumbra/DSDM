package com.mastercoding.viewpagerapp;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvPersonal = view.findViewById(R.id.tvDescPersonal);
        ImageView imageView = view.findViewById(R.id.iVimage);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("keyName", "notFound");
        String desc = sharedPreferences.getString("keyDescPerso", "notFound");
        int image = sharedPreferences.getInt("keyImage", 0);
        imageView.setImageResource(image);
        tvName.setText(name);
        tvPersonal.setText(desc);

        return view;
    }

    //Depois que a view é criada, garante que elas existem
    /*@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }*/
}