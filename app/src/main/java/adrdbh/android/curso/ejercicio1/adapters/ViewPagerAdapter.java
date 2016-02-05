package adrdbh.android.curso.ejercicio1.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import adrdbh.android.curso.ejercicio1.fragments.CameraFragment;
import adrdbh.android.curso.ejercicio1.fragments.ThreadFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private CharSequence mTiles[] = {"Camara", "Hilos"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return CameraFragment.newInstance();
        } else {
            return ThreadFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return mTiles.length; // !!!!!
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTiles[position];
    }
}
