package com.example.lesson2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MActivity";
    private TextView tv;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button button_0;
    private Button button_c;
    private Button button_plus;
    private Button button_minus;
    private Button button_multy;
    private Button button_equal;
    private SaveBox saveBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String localState;
        if (savedInstanceState == null) {
            localState = "start";
        }
        else {
            localState = "continie";
        }
        saveBox = new SaveBox();
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        button_0 = findViewById(R.id.button_0);
        button_c = findViewById(R.id.button_C);
        button_plus = findViewById(R.id.button_plus);
        button_minus = findViewById(R.id.button_minus);
        button_multy = findViewById(R.id.button_multy);
        button_equal = findViewById(R.id.button_equal);
        tv = findViewById(R.id.textView);

        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("0");
                saveBox.setCurrentNumber(1);
                saveBox.setFirstNumber("");
                saveBox.setSecondNumber("");
            }
        });

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() != "0") {
                    tv.setText(tv.getText() + "+");
                    saveBox.setOperation("+");
                    saveBox.setCurrentNumber(2);
                }
            }
        });

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() != "0") {
                    tv.setText(tv.getText() + "=" + saveBox.getOperationResult());

                }
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() != "0") {
                    tv.setText(tv.getText() + "-");
                    saveBox.setOperation("-");
                    saveBox.setCurrentNumber(2);
                }
            }
        });

        button_multy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() != "0") {
                    tv.setText(tv.getText() + "X");
                    saveBox.setOperation("X");
                    saveBox.setCurrentNumber(2);
                }
            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() == "0") {
                    tv.setText("1");
                }
                else {
                    tv.setText(tv.getText() + "1");
                }
                saveBox.setNumber("1");
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() == "0") {
                    tv.setText("2");
                }
                else {
                    tv.setText(tv.getText() + "2");
                }
                saveBox.setNumber("2");
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() == "0") {
                    tv.setText("3");
                }
                else {
                    tv.setText(tv.getText() + "3");
                }
                saveBox.setNumber("3");
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() == "0") {
                    tv.setText("4");
                }
                else {
                    tv.setText(tv.getText() + "4");
                }
                saveBox.setNumber("4");
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() == "0") {
                    tv.setText("5");
                }
                else {
                    tv.setText(tv.getText() + "5");
                }
                saveBox.setNumber("5");
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() == "0") {
                    tv.setText("6");
                }
                else {
                    tv.setText(tv.getText() + "6");
                }
                saveBox.setNumber("6");
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() == "0") {
                    tv.setText("7");
                }
                else {
                    tv.setText(tv.getText() + "7");
                }
                saveBox.setNumber("7");
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() == "0") {
                    tv.setText("8");
                }
                else {
                    tv.setText(tv.getText() + "8");
                }
                saveBox.setNumber("8");
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() == "0") {
                    tv.setText("9");
                }
                else {
                    tv.setText(tv.getText() + "9");
                }
                saveBox.setNumber("9");
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv.getText() == "0") {
                    tv.setText("0");
                }
                else {
                    tv.setText(tv.getText() + "0");
                }
                saveBox.setNumber("0");
            }
        });

        Toast.makeText(getApplicationContext(), localState, Toast.LENGTH_SHORT).show();
        Log.d(TAG, localState);
        findViewById(R.id.button_option).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(MainActivity.this,SecondActivity.class));
                startActivity(intent);
            }
        });
    }

    public MainActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
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
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onSaveInstanceState");
    }
}