package com.example.nico.goferapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nico.goferapp.R;

/**
 * Created by Nico on 9/26/2016.
 */

public class ToFragment extends android.support.v4.app.Fragment {

    EditText editTextAddressTo, editTextNumberTo, editTextPersonNameTo;
    TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!editTextNumberTo.getText().toString().matches("((63)|0)\\d{10}")) {
//                editTextNumberTo.setError(getString(R.string.invalid_number));
            } else {
                editTextNumberTo.setError(null);
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

        View view = inflater.inflate(R.layout.fragment_add_bike_delivery_to, container, false);
        editTextPersonNameTo = (EditText) view.findViewById(R.id.edit_person_name_to);
        editTextAddressTo = (EditText) view.findViewById(R.id.edit_address_to);
        editTextNumberTo = (EditText) view.findViewById(R.id.edit_contact_number_to);
        editTextNumberTo.addTextChangedListener(textWatcher);
        //initializeAutoCompleteFragment();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public TextView NameTo() {
        return editTextPersonNameTo;
    }

    public TextView AddressTo() {
        return editTextAddressTo;
    }

    public TextView NumberTo() {
        return editTextNumberTo;
    }
}
