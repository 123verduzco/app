package adrdbh.android.curso.ejercicio1.actividades;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adrdbh.android.curso.ejercicio1.R;
import adrdbh.android.curso.ejercicio1.adapters.ViewPagerAdapter;
import adrdbh.android.curso.ejercicio1.utils.SlidingTabLayout;

public class SectionActivity extends AppCompatActivity {

    private ViewPagerAdapter adapter;
    private ViewPager pager;
    private SlidingTabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);

        pager.setAdapter(adapter);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorAccent);
            }

            @Override
            public int getDividerColor(int position) {
                return 0;
            }
        });

    }
}
