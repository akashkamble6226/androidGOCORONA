package com.example.gocorona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    TextView text;
    String tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);



        text = findViewById(R.id.reverse);

        tx = "Not Registered,Register Here";

        SpannableString ss = new SpannableString(tx);
        ClickableSpan clickspan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {

                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);


            }
        };

        ss.setSpan(clickspan1,15,28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        text.setText(ss);
        text.setMovementMethod(LinkMovementMethod.getInstance());





    }

    public void LoginSuccess(View v)
    {
        Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show();

    }


}
