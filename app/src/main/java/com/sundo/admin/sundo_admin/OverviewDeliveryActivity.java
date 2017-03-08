package com.sundo.admin.sundo_admin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.sundo.admin.sundo_admin.Dialog.SignatureDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Nico on 3/6/2017.
 */

public class OverviewDeliveryActivity extends AppCompatActivity {
    @Bind(R.id.text_price_overview)
    TextView textPriceOverview;
    @Bind(R.id.divider_from)
    ImageView dividerFrom;
    @Bind(R.id.text_name_overview_from)
    TextView textNameOverviewFrom;
    @Bind(R.id.text_address_overview_from)
    TextView textAddressOverviewFrom;
    @Bind(R.id.text_number_overview_from)
    TextView textNumberOverviewFrom;
    @Bind(R.id.divider1)
    ImageView divider1;
    @Bind(R.id.divider_to)
    ImageView dividerTo;
    @Bind(R.id.text_name_overview_to)
    TextView textNameOverviewTo;
    @Bind(R.id.text_address_overview_to)
    TextView textAddressOverviewTo;
    @Bind(R.id.text_number_overview_to)
    TextView textNumberOverviewTo;
    @Bind(R.id.divider)
    ImageView divider;
    @Bind(R.id.divider_notes)
    ImageView dividerNotes;
    @Bind(R.id.divider3)
    ImageView divider3;
    @Bind(R.id.divider2)
    ImageView divider2;
    @Bind(R.id.image_signature)
    ImageView imageSignature;
    @Bind(R.id.button_reject)
    Button buttonReject;
    @Bind(R.id.button_accept)
    Button buttonAccept;
    @Bind(R.id.scrollView)
    ScrollView scrollView;
    @Bind(R.id.image_preview)
    ImageView imagePreview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_reject, R.id.button_accept, R.id.image_signature})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_reject:
                break;
            case R.id.button_accept:
                break;
            case R.id.image_signature:
                SignatureDialog signatureDialog = new SignatureDialog();
                signatureDialog.show(getFragmentManager(), "Signature Dialog");
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
