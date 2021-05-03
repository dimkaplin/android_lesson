package com.example.lesson2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SActivity";
    private TextView tv;
    private SaveBox saveBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button back = findViewById(R.id.button_back);
        tv = findViewById(R.id.text_click);
        saveBox = new SaveBox();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(SecondActivity.this,MainActivity.class));
                startActivity(intent);
            }
        });

        findViewById(R.id.text_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String  tv = findViewById(R.id.text_click).get;
                tv.setText(tv.getText() + " Ура!");

                saveBox.setCurrentClick((String) tv.getText());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
        /*if (saveBox.getCurrentClick() != "") {
            tv.setText(saveBox.getCurrentClick());
        }
        else {
            saveBox.setCurrentClick((String) tv.getText());
        }*/
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestoreInstanceState");
        saveBox = (SaveBox) savedInstanceState.getSerializable("SAVEBOX");
        tv.setText(saveBox.getCurrentClick());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onSaveInstanceState");
        outState.putSerializable("SAVEBOX", saveBox);
        //tv.setText(saveBox.getCurrentClick());
    }
}