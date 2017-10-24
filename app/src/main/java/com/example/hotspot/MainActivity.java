package com.example.hotspot;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        TextView textView = (TextView) findViewById(R.id.text1);
        String name = sharedPref.getString("saved_name", "hotspot name");
        textView.setText(name);

        LinearLayout layout_set = (LinearLayout)findViewById(R.id.layout_set);
        layout_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.hotspot.Set_Hotspot");
                startActivityForResult(intent,1);
            }
        });
    }

    /*由于是使用startActivityForResult()方法来启动 SetHotSpot 的，
     *在 SetHotSpot 被销毁之后会调用上一个活动(MainActivity)的onActivityResult()方法
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        TextView textView = (TextView) findViewById(R.id.text1);
        
        SharedPreferences sharedPrefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String name = intent.getStringExtra("name");
                    textView.setText(name);
                    editor.putString("saved_name", name);
                    editor.commit();
                }
                break;
            default:
                break;
        }
    };
}
