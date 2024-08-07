package com.mastercoding.viewpagerapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewpager;
    MyViewPagerAdapter myAdapter;
    TabLayout tabLayout;

    String[] menu = {"Pessoal", "Profissional", "Extra"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);

        myAdapter = new MyViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        // Adding Fragments to the list in the Adapter Class
        myAdapter.addFragment(new Fragment1());
        myAdapter.addFragment(new Fragment2());
        myAdapter.addFragment(new Fragment3());

        // Set the orientation in ViewPager2
        viewpager = findViewById(R.id.viewPager2);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        // Connecting the Adapter with ViewPager2
        viewpager.setAdapter(myAdapter);

        // Connecting TabLayout with ViewPager
        new TabLayoutMediator(
                tabLayout,
                viewpager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(menu[position]);
                    }
                }
        ).attach();

        Gentleman myInfo = new Gentleman(R.drawable.eu,"Franciel",
                "Atualmente é aluno do curso de Sistemas de Informação no campus da UFC-Quixadá, gosta de jogar nas horas vagas",
                "Desenvolvedor backend em C++, Java, C#. Skills: Proativo e Organizado",
                "Gosta de futebol e é entusiasta do time que foi fundado em 1910"
        );

        //salvando um dado
        SharedPreferences sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("keyImage", myInfo.getImage());
        editor.putString("keyName", myInfo.getName());
        editor.putString("keyDescPerso", myInfo.getDescPersonal());
        editor.putString("keyDescProf", myInfo.getDescProfissional());
        editor.putString("keyDescExtra", myInfo.getDescExtra());
        editor.apply();
    }
}