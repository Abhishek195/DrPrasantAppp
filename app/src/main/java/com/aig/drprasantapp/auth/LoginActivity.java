package com.aig.drprasantapp.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aig.drprasantapp.activity.MainActivity;
import com.aig.drprasantapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tV_notauser;
    LinearLayout lI_newmember;
    Button ntn_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lI_newmember = findViewById(R.id.lI_newmember);
        ntn_Login = findViewById(R.id.btn_Login);
        lI_newmember.setOnClickListener(this);
        ntn_Login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lI_newmember:
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.btn_Login:
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
                break;

        }

    }
}
