package org.devele.alermi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class RegisterIdActivity extends AppCompatActivity {
    EditText gainid;
    TextView idlen,idconst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_id);
        Button nextbtn = findViewById(R.id.id_nextbtn);
        ImageButton backbtn = findViewById(R.id.id_back);
        idconst = findViewById(R.id.nick_const);
        idlen = findViewById(R.id.nick_len);
        gainid = findViewById(R.id.gainid);
        gainid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(gainid.getText().toString().length() != 0 ){
                    idconst.setTextColor(Color.parseColor("#F95643"));
                    if(gainid.getText().toString().length() < 16){
                        idlen.setTextColor(Color.parseColor("#F95643"));
                    } else {
                        idlen.setTextColor(Color.parseColor("#808080"));
                    }
                } else {
                    idlen.setTextColor(Color.parseColor("#808080"));
                    idconst.setTextColor(Color.parseColor("#808080"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegisterPasswordActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegisterMentActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(getApplicationContext(),RegisterMentActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
        }
        return true;
    }
}