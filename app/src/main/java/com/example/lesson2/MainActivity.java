package com.example.lesson2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
    public static final String SEND_STRING = "FROM_MA";
    public static final int SEND_CODE = 33;
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
    private Button button_del;
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
        button_del = findViewById(R.id.button_del);
        button_equal = findViewById(R.id.button_equal);
        tv = findViewById(R.id.textView);

        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("0");
                saveBox.setCurrentNumber(1);
                saveBox.setFirstNumber("");
                saveBox.setSecondNumber("");
                saveBox.setEqual(false);
            }
        });

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(getResources().getString(R.string.plus));
            }
        });

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tv.getText().equals("0") && !saveBox.isEqual()) {
                    tv.setText(tv.getText() + getResources().getString(R.string.equal) + saveBox.getOperationResult());
                    saveBox.setEqual(true);
                    saveBox.setFirstNumber(saveBox.getOperationResult());
                }
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(getResources().getString(R.string.minus));
            }
        });

        button_multy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(getResources().getString(R.string.multy));
            }
        });

        button_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(getResources().getString(R.string.del));
            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(getResources().getString(R.string._1));
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(getResources().getString(R.string._2));
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(getResources().getString(R.string._3));
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(getResources().getString(R.string._4));
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(getResources().getString(R.string._5));
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(getResources().getString(R.string._6));
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(getResources().getString(R.string._7));
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(getResources().getString(R.string._8));
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(getResources().getString(R.string._9));
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumber(getResources().getString(R.string._0));
            }
        });

        Toast.makeText(getApplicationContext(), localState, Toast.LENGTH_SHORT).show();
        Log.d(TAG, localState);
        findViewById(R.id.button_option).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(MainActivity.this,SecondActivity.class));
                intent.putExtra(SEND_STRING, tv.getText().toString());
                //startActivity(intent);
                startActivityForResult(intent, SEND_CODE);
            }
        });
    }

    public MainActivity() {
        super();
    }

    private void setNumber(String number) {
        Toast.makeText(getApplicationContext(), "tv_text: " + tv.getText(), Toast.LENGTH_SHORT).show();
        if (tv.getText().equals("0") || tv.getText() == null) {
            tv.setText(number);
        }
        else {
            tv.setText(tv.getText() + number);
        }
        saveBox.setNumber(number);
    }

    private void setOperation(String operation) {
        if (!saveBox.getFirstNumber().equals("") && saveBox.getOperation().equals("")) {
            tv.setText(tv.getText() + operation);
            saveBox.setOperation(operation);
            saveBox.setCurrentNumber(2);
        }

        if (!saveBox.getFirstNumber().equals("") && (!saveBox.getOperation().equals("") || saveBox.isEqual())) {
            tv.setText(saveBox.getFirstNumber() + operation);
            saveBox.setOperation(operation);
            saveBox.setCurrentNumber(2);
            saveBox.setEqual(false);
        }

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != SEND_CODE) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        if (resultCode == Activity.RESULT_OK) {
            //Toast.makeText(getApplicationContext(), "result" + data.getParcelableExtra(SEND_STRING).toString(), Toast.LENGTH_SHORT).show();
          tv.setText(data.getStringExtra(SEND_STRING));
        }

    }
}