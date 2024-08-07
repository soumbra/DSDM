package com.mastercoding.viewpagerapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Fragment2 extends Fragment {

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        TextView tvProfissional = view.findViewById(R.id.tvDesc);
        ImageView imageView = view.findViewById(R.id.iVimage);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String desc = sharedPreferences.getString("keyDescProf", "notFound");
        int image = sharedPreferences.getInt("keyImage", 0);
        imageView.setImageResource(image);
        tvProfissional.setText(desc);

        return view;
    }
}