package com.sundo.user.sundo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sundo.user.sundo.R;

import butterknife.ButterKnife;

/**
 * Created by Nico on 9/26/2016.
 */
public class CurrentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_current_delivery, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
