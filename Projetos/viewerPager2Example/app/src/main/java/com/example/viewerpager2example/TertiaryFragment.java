package com.example.viewerpager2example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TertiaryFragment extends Fragment {
    public TertiaryFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_tertiary, container, false);

        Button firstBtn = view.findViewById(R.id.btn_frag3);
        //TextView text = view.findViewById(R.id.text_frag2);

        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Bem vindo ao terceiro fragment", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
