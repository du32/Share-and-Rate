package com.devimpact.startup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Rate Button.
        public void rate(View view) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW,

                        Uri.parse("https://play.google.com/store/apps/details?id=com.devimpact.startup"
                                + "com.devimpact.startup")));


                //app link not found go to the google play
            } catch (ActivityNotFoundException e) {

                startActivity(new Intent(Intent.ACTION_VIEW,

                        Uri.parse("http://play.google.com/store/apps/details?id="
                                + "com.devimpact.startup")));
            }
        }

    //Share Button.
    public void share(View view) {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);

            shareIntent.setType("Dev impact الفريق العربي للبرمجة");

            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "اسم التطبيق");

            String shareMessage= "\n Dev impact  حمل التطبيق وتعرف على فريق البرمجة العربي\n\n";

            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=com.devimpact.startup"
                    + BuildConfig.APPLICATION_ID +"\n\n";

            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);

            startActivity(Intent.createChooser(shareIntent, "اختر تطبيق"));


        } catch(Exception e) {
            //e.toString();
        }
    }}

