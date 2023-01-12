package com.example.tema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    int Data1, Data2, calc_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Data1 = getIntent().getIntExtra("first_number", 0);
        Data2 = getIntent().getIntExtra("second_number", 0);

        TextView numbers2 = findViewById(R.id.numbers2);
        numbers2.setText("Numbers: " + Data1 + "," + Data2);
    }

    public void onClickAdd(View view) {
        calc_result = Data1 + Data2;
        Intent intent_2 = new Intent(this, MainActivity.class);

        intent_2.putExtra("calc_result", calc_result);
        setResult(RESULT_OK, intent_2);
        Toast.makeText(getApplicationContext(), "add", Toast.LENGTH_SHORT).show();

        finish();
    }

    public void onClickSub(View view) {
        calc_result = Data1 - Data2;
        Intent intent_3 = new Intent(this, MainActivity.class);

        intent_3.putExtra("calc_result", calc_result);
        Toast.makeText(getApplicationContext(), "sub", Toast.LENGTH_SHORT).show();

        setResult(RESULT_OK, intent_3);
        finish();
    }
}