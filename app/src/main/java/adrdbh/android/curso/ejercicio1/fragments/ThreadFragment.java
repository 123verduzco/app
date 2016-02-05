package adrdbh.android.curso.ejercicio1.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adrdbh.android.curso.ejercicio1.R;

/**
 * Created by adrdbh on 2/3/16.
 */
public class ThreadFragment extends Fragment {

    public static ThreadFragment newInstance() {
        ThreadFragment tf = new ThreadFragment();
        return tf;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.thread_fragment_layout, container, false);
        return v;
    }
}
