package com.example.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static java.lang.String.format;

public class Home extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        radioGroup = findViewById(R.id.radioGroup);

        Button bt = (Button) findViewById(R.id.go);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Home.this,Register.class);
                startActivity(intent);


                int radioID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioID);


                Toast.makeText(Home.this, "You've Selected: "+ radioButton.getText(), Toast.LENGTH_SHORT).show();





            }
        });


    }

    public void checkButton(View v)
    {

        int radioID = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioID);


        Toast.makeText(Home.this, "You've Selected: "+ radioButton.getText(), Toast.LENGTH_SHORT).show();

    }


}
