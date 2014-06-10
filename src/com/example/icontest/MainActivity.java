package com.example.icontest;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {
    boolean flag=false; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_LEFT_ICON);
        setContentView(R.layout.activity_main);
//        setFeatureDrawableResource(Windo÷w.FEATURE_LEFT_ICON,R.drawable.ic_launcher);
        getPackageManager().setComponentEnabledSetting(
              new ComponentName("com.example.icontest", "com.example.icontest.MainActivity-Red"), 
                  PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);   
//        setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,R.drawable.app_icon);

        Button button = (Button)findViewById(R.id.test);
        
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (!flag){
                    getPackageManager().setComponentEnabledSetting(
                            new ComponentName("com.example.icontest", "com.example.icontest.MainActivity-Red"), 
                                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP); 
                    getPackageManager().setComponentEnabledSetting(
                            new ComponentName("com.example.icontest", "com.example.icontest.MainActivity-Reg"), 
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                    flag =true;
                }
                else {
                    
                    getPackageManager().setComponentEnabledSetting(
                            new ComponentName("com.example.icontest", "com.example.icontest.MainActivity-Red"), 
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                    getPackageManager().setComponentEnabledSetting(
                            new ComponentName("com.example.icontest", "com.example.icontest.MainActivity-Reg"), 
                                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP); 
                    flag=false;
                }
                Log.d("icontest",String.valueOf(flag));
            }
              

            
        });

    }
}
   