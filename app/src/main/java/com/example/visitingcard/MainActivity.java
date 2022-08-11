package com.example.visitingcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        TextView c = findViewById(R.id.call);
        TextView m = findViewById(R.id.mail);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //textView.setText("1");

                String number = c.getText().toString();
                if (0 < number.trim().length()) {

                    Intent call= new Intent(Intent.ACTION_DIAL);
                    call.setData(Uri.parse("tel:"+c.getText().toString()));
                    startActivity(call);

                }




            }
        });


        m.setOnClickListener(new View.OnClickListener() {
          //  @SuppressLint("IntentReset")
            @Override
            public void onClick(View view) {

               String add = m.getText().toString();
               if (0 < add.trim().length()) {
                   Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + add));
                   emailIntent.putExtra(Intent.EXTRA_SUBJECT, "hello");
                   emailIntent.putExtra(Intent.EXTRA_TEXT, "hello body");



                   startActivity(Intent.createChooser(emailIntent, "Chooser Title"));

                }



            }
        });





    }
}