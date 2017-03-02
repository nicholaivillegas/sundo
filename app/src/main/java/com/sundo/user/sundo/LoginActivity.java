package com.sundo.user.sundo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Nico on 3/1/2017.
 */

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.image_tag)
    ImageView imageTag;
    @Bind(R.id.editText_name)
    EditText editTextName;
    @Bind(R.id.textInputLayout_name)
    TextInputLayout textInputLayoutName;
    @Bind(R.id.editText_password)
    EditText editTextPassword;
    @Bind(R.id.button_login)
    Button buttonLogin;
    @Bind(R.id.activity_login)
    LinearLayout activityLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_login)
    public void onClick() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
