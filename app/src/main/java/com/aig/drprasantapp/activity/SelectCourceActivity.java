package com.aig.drprasantapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.aig.drprasantapp.R;

public class SelectCourceActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout lI_medical,lI_fmg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cource);
        lI_medical = findViewById(R.id.li_medical);
        lI_fmg = findViewById(R.id.li_fmge);
        lI_medical.setOnClickListener(this);
        lI_fmg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
          case R.id.li_medical:
              Intent intent = new Intent(SelectCourceActivity.this,MainActivity.class);
              intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
              startActivity(intent);
              return;
            case R.id.li_fmge:
                Intent intent1 = new Intent(SelectCourceActivity.this,MainActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
                return;
        }

    }
}
