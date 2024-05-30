package com.example.assignment1a;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
Assignment 1A
Assignment 1A.zip
Chinedu Ibeanu
Kasumi Yang




 */

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "demo";
    EditText userTemp;
    TextView finalValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            userTemp = findViewById(R.id.userTemp);
            finalValue = findViewById(R.id.finalValue);

            findViewById(R.id.resetButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userTemp.setText("");
                    finalValue.setText("");
                }
            });

            findViewById(R.id.fToCelButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fToCel();
                }
            });
            findViewById(R.id.ctoFarButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                cToFar();

                }
            });
    }
    private void cToFar(){
        String userInput = userTemp.getText().toString();
        //We then need to convert this to a double as temperature values usually involve decimals

        //We need to use exception handling to make sure that we account for the user not inputting in the text field as trying to convert an empty string into a double will throw an error

        try{
            double temp = Double.valueOf(userInput);
            Log.d(TAG, "onClick: " + temp);

            //Need to set the finalValue = (temp - 32) * 5/9

            double convertedTemp = (temp * 9/5) + 32;
            double roundedTemp = (Math.round(convertedTemp * 100.0)/ 100.0);

            finalValue.setText(String.valueOf(roundedTemp) + " F");

        }catch (NumberFormatException exception){
            Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
    }
    private void fToCel(){
        //Need to get the userTemperature and convert to a string
        String userInput = userTemp.getText().toString();
        //We then need to convert this to a double as temperature values usually involve decimals

        //We need to use exception handling to make sure that we account for the user not inputting in the text field as trying to convert an empty string into a double will throw an error

        try{
            double temp = Double.valueOf(userInput);
            Log.d(TAG, "onClick: " + temp);

            //Need to set the finalValue = (temp - 32) * 5/9

            double convertedTemp = (temp - 32) * 5/9;
            double roundedTemp = (Math.round(convertedTemp * 100.0)/ 100.0);

            finalValue.setText(String.valueOf(roundedTemp) + " C");
        }catch (NumberFormatException exception){
            Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }



    }
}