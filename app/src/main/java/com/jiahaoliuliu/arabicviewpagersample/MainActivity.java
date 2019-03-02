package com.jiahaoliuliu.arabicviewpagersample;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    private static final String[] fragmentsName = {
            "Geralt Of Rivia ", "Triss Merigold", "Cirilla Fiona Elen Riannon",
            "Yennefer de Vries"};

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the views
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        // Init the views
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this, fragmentsName);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
