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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.util.Calendar;

public class Register extends AppCompatActivity {

    TextView text;
    String tx;

    EditText fullname,Date,Mobile,village,city,District,State;

    TextView txtClck;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        text = findViewById(R.id.already);

        tx = "Already Reagisterd Please Sign In";




        SpannableString ss = new SpannableString(tx);

        ClickableSpan clickspan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {

                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);


            }
        };


        ss.setSpan(clickspan1,26,33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        text.setText(ss);
        text.setMovementMethod(LinkMovementMethod.getInstance());


        //Validation Started

        fullname = findViewById(R.id.fullName);//validations started from here
        txtClck = findViewById(R.id.Register);
        Date = findViewById(R.id.Date);
        Mobile = findViewById(R.id.Mobile);
        village = findViewById(R.id.village);
        city = findViewById(R.id.city);
        District = findViewById(R.id.District);
        State = findViewById(R.id.State);


        final AwesomeValidation awesomeValidation;

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //validation for FullName
        awesomeValidation.addValidation(this,R.id.fullName,RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        //validation for Date
        awesomeValidation.addValidation(this,R.id.Date,"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$",R.string.invalid_date);


        //validation for Mobile
        awesomeValidation.addValidation(this,R.id.Mobile,"^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$",R.string.invalid_mobile);

        //validation for Village
        awesomeValidation.addValidation(this,R.id.village,RegexTemplate.NOT_EMPTY,R.string.invalid_village);


        //validation for city
        awesomeValidation.addValidation(this,R.id.city,RegexTemplate.NOT_EMPTY,R.string.invald_city);

        //validation for District
        awesomeValidation.addValidation(this,R.id.District,RegexTemplate.NOT_EMPTY,R.string.invalid_district);

        //validation for State
        awesomeValidation.addValidation(this,R.id.State,RegexTemplate.NOT_EMPTY,R.string.invalid_state);

        txtClck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()){


                    Toast.makeText(getApplicationContext(),"Validation succeded",Toast.LENGTH_SHORT).show();


                }

                else
                {

                    Toast.makeText(getApplicationContext(),"Validation Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });















    }





}
