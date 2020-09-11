package com.example.intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Intent intent = getIntent();
        double data = intent.getDoubleExtra("extra_data",1);
        final double resultData = data * data;
        Toast.makeText(this,"传入的数据为 " + data,Toast.LENGTH_SHORT).show();
        Log.d("SecondActivity",""+ data);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent send_intent = new Intent();
                send_intent.putExtra("data_return","收到了计算结果：" + resultData);
                setResult(RESULT_OK,send_intent);
                finish();
            }
        });
    }
}