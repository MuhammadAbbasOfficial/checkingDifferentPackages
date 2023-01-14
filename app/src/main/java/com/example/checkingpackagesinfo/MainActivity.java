package com.example.checkingpackagesinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager pm = getPackageManager();
                boolean personalWhatsapp = isPackageInstalled("com.whatsapp", pm);
                boolean businessWhatsApp = isPackageInstalled("com.whatsapp.w4b", pm);
                if (businessWhatsApp)
                {
                    launchWhatsAppBusinessApp();

                }
                else if (personalWhatsapp)
                {
                    openWhatsApp();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "please install the package...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * it will check the packege is install in your phone or not
     */
    public boolean isPackageInstalled(String packageName, PackageManager packageManager)
    {
        try {
            packageManager.getPackageInfo(packageName, 0);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * it will lauch bussiness whatsapp
     */
    public void launchWhatsAppBusinessApp()
    {
        PackageManager pm = getPackageManager();
        try
        {
            Intent intent = pm.getLaunchIntentForPackage("com.whatsapp.w4b");
            startActivity(intent);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Please install WA Business App", Toast.LENGTH_SHORT).show();
        }
        // catch(NullPointerException exception){}
    }


    /**
     * it will lauch personal whatsapp
     */
    public void openWhatsApp()
    {
        PackageManager pm = getPackageManager();
        try
        {
            Intent intent = pm.getLaunchIntentForPackage("com.whatsapp");
            startActivity(intent);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Please install WhatsApp App", Toast.LENGTH_SHORT).show();
        }
        //catch(NullPointerException exception){}
    }



}