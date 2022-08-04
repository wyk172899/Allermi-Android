package org.devele.alermi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class RegisterPasswordActivity extends AppCompatActivity {
    TextView combi1,combi2,word,num,len;
    EditText gainpass;
    Boolean boolnum,boolword;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_password);
        Button next = findViewById(R.id.pass_nextbtn);
        ImageButton back = findViewById(R.id.pass_back);
        combi1 = findViewById(R.id.combi1);
        combi2 = findViewById(R.id.combi2);
        word = findViewById(R.id.pass_word);
        num = findViewById(R.id.pass_num);
        len = findViewById(R.id.pass_len);
        gainpass = findViewById(R.id.gainpass);
        gainpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(gainpass.getText().toString().length() >= 8){
                    len.setTextColor(Color.parseColor("#F95643"));
                } else {
                    len.setTextColor(Color.parseColor("#808080"));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegisterIdActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WelcomeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });
    }
}