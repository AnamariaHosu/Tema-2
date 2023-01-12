package com.example.tema2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                TextView textRez = findViewById(R.id.textRez);

                if(result.getResultCode()==RESULT_OK){
                    Intent data = result.getData();
                    if(data!=null){
                        int calc_result =data.getIntExtra("calc_result",0);
                        textRez.setText("Result "+calc_result);
                    }
                }
                if(result.getResultCode()==RESULT_CANCELED){
                    textRez.setText("Nothing ");
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onClickBtn1(View view)
    {   

        EditText frstNum= findViewById(R.id.frstNum);
        EditText scndNum= findViewById(R.id.scndNum);

        if((frstNum.getText().toString().equals(""))||(scndNum.getText().toString().equals("")))
        {
            Toast.makeText(getApplicationContext(), "complete with numbers",Toast.LENGTH_LONG).show();

        }
        
        else {
            int nr1 = Integer.parseInt(frstNum.getText().toString());
            int nr2 = Integer.parseInt(scndNum.getText().toString());
            Toast.makeText(getApplicationContext(), "going to second activity",Toast.LENGTH_LONG).show();


            Intent intent_1 = new Intent(this, MainActivity3.class);
            intent_1.putExtra("first_number", nr1);
            intent_1.putExtra("second_number", nr2);

            activityLauncher.launch(intent_1);
        }
    }
}