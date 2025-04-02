package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView resultText;
    Button calculateButton;
    RadioButton maleButton;
    RadioButton femaleButton;
    RadioGroup genderGroup;
    EditText ageEditText;
    EditText feetEditText;
    EditText inchesEditText;
    EditText weightEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setButtonClickListener();
//        String alertText = "My name is Huong Dep Trai";
//        Toast.makeText(this, alertText, Toast.LENGTH_LONG).show();
        //Toast.makeText(context, text, duration).show();
    }

    private void setButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bmiResult = calculateBmi();
                String ageText = ageEditText.getText().toString();
                int age = Integer.parseInt(ageText);
                if(age >= 18){
                    displayResult(bmiResult);
                }else {
                    displayGuidance(bmiResult);
                }

            }
        });
    }

    private void displayGuidance(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if(maleButton.isChecked()){

            fullResultString = bmi +"Are you under 18?, please consult with your doctor";
        }else if(femaleButton.isChecked()){
            fullResultString = bmi +"Are you under 18?, please consult with your doctor";
        }else{
            fullResultString = bmi +"Are you under 18?, please consult with your doctor";
        }
        resultText.setText(fullResultString);
    }

    private double calculateBmi() {

        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        //resultText.setText("Age: " + ageText + ", Feet: " + feetText + ", Inches: " + inchesText + ", Weight: " + weightText);

        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;

        double heightInMeters =totalInches * 0.0254;

        return weight / (heightInMeters * heightInMeters);
    }
    private void displayResult(double bmi){
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if(bmi < 18.5){
            fullResultString = bmiTextResult + "You are underweight";
        }else if(bmi > 25){
            fullResultString = bmiTextResult + "You are overweight";
        }else{
            fullResultString = bmiTextResult + "You are healthy weight";
        }
        resultText.setText(fullResultString);
    }
    private void findViews(){
        resultText =  findViewById(R.id.text_view_result);
        //resultText.setText("Toi ten la Huong Dep Trai");
        maleButton= findViewById(R.id.radio_button_male);
        femaleButton= findViewById(R.id.radio_button_female);

        ageEditText = findViewById(R.id.edit_text_age);
        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        weightEditText = findViewById(R.id.edit_text_weight);
        calculateButton = findViewById(R.id.button_calculate);
    }
}