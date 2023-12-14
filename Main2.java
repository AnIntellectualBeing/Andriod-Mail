package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2 ;
    Button b3;
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         b2 = findViewById(R.id.btn2);
         b1 = findViewById(R.id.btn1);
         b3 = findViewById(R.id.btn3);
         et1 = findViewById(R.id.et1);

         et2 = findViewById(R.id.et2);
         et3 = findViewById(R.id.et3);
         et4 = findViewById(R.id.et4);

         b3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String s1 = et2.getText().toString();
                 String s2 = et3.getText().toString();
                 String s3 = et4.getText().toString();

                 Intent i = new Intent(Intent.ACTION_SEND);
                 i.putExtra(Intent.EXTRA_EMAIL,new String[] {s1});
                 i.putExtra(Intent.EXTRA_SUBJECT, s2);
                 i.putExtra(Intent.EXTRA_TEXT,s3);
                 i.setType("message/rfc822");

                 startActivity(Intent.createChooser(i,"yourgmail@gmail.com"));
             }
         });

         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(MainActivity.this, Main2.class);
                 startActivity(i);
             }
         });


         b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String s = "http://www.";
                 s +=et1.getText().toString();
                 s+=".com";
                 Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
                 startActivity(i);

             }
         });

    }
}
