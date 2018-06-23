package com.aig.drprasantapp.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.aig.drprasantapp.R;
import com.aig.drprasantapp.activity.SelectCourceActivity;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout lI_login;
    Button btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        lI_login = findViewById(R.id.lI_login);
        btn_register = findViewById(R.id.btn_register);
        lI_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lI_login:
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return;

            case R.id.btn_register:
                Intent intent1 = new Intent(SignupActivity.this, SelectCourceActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
                return;
        }
    }
}
