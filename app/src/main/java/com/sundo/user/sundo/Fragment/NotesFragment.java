package com.sundo.user.sundo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.sundo.user.sundo.R;

/**
 * Created by Nico on 9/26/2016.
 */
public class NotesFragment extends android.support.v4.app.Fragment {

    EditText editTextNotes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_bike_delivery_notes, container, false);
        editTextNotes = (EditText) view.findViewById(R.id.edit_notes);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public TextView DeliveryNotes() {
        return editTextNotes;
    }
}
