package com.sundo.user.sundo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.sundo.user.sundo.R;

/**
 * Created by Nico on 9/26/2016.
 */
public class FromFragment extends android.support.v4.app.Fragment {

    EditText editTextPersonNameFrom, editTextAddressFrom, editTextNumberFrom;
    TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!editTextNumberFrom.getText().toString().matches("((63)|0)\\d{10}")) {
                //editTextNumberFrom.setError(getString(R.string.invalid_number));
            } else {
                editTextNumberFrom.setError(null);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_bike_delivery_from, container, false);
        editTextPersonNameFrom = (EditText) view.findViewById(R.id.edit_person_name_from);
        editTextAddressFrom = (EditText) view.findViewById(R.id.edit_address_from);
        editTextNumberFrom = (EditText) view.findViewById(R.id.edit_contact_number_from);
        editTextNumberFrom.addTextChangedListener(textWatcher);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public TextView NameFrom() {
        return editTextPersonNameFrom;
    }

    public TextView AddressFrom() {
        return editTextAddressFrom;
    }

    public TextView NumberFrom() {
        return editTextNumberFrom;
    }
}