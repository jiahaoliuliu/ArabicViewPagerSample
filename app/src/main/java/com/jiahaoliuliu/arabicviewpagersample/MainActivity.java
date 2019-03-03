package com.jiahaoliuliu.arabicviewpagersample;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final Locale ARABIC_LOCALE = new Locale("ar", "AR");

    private static final String[] fragmentsName = {
            "Geralt Of Rivia ", "Triss Merigold", "Cirilla Fiona Elen Riannon",
            "Yennefer de Vries"};

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private static Locale currentLocale = Locale.getDefault();
    private static Locale previousLocale = ARABIC_LOCALE;

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

        currentLocale = Locale.getDefault();
        previousLocale = ARABIC_LOCALE;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.change_language) {
            changeLanguage(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(changeLanguage(newBase));
    }

    private Context changeLanguage(Context context) {
        Locale tmpLocale = currentLocale;
        currentLocale = previousLocale;
        previousLocale = tmpLocale;

        Locale.setDefault(currentLocale);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return updateResourcesLocale(context, currentLocale);
        }

        return updateResourcesLocaleLegacy(context, currentLocale);
    }

    @TargetApi(Build.VERSION_CODES.N)
    private Context updateResourcesLocale(Context context, Locale locale) {
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }

    @SuppressWarnings("deprecation")
    private Context updateResourcesLocaleLegacy(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}
