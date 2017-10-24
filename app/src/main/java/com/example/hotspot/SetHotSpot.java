package com.example.hotspot;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2017/10/23 0023.
 */

public class SetHotSpot extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_menu_layout);


        Button button_ok = (Button)findViewById(R.id.button_ok);

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.hotspot_name);
                Intent intent = new Intent();
                intent.putExtra("name",name.getText().toString());
                /* 专门用于向上一个活动返回数据。
                 * 第一个参数用于向上一个活动返回结果码，一般只使用RESULT_OK或RESULT_CANCELED这两个值
                 */
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }



}
