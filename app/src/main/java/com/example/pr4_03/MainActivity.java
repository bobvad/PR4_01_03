package com.example.pr4_03;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private String userName;
    private String userAge;
    private String userGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onStepAge(View view) {
        EditText nameEditText = findViewById(R.id.editTextText);
        String strName = nameEditText.getText().toString();
        if (strName.isEmpty()) {
            Toast.makeText(this, "Пожалуйста, введите имя", Toast.LENGTH_SHORT).show();
            return;
        }
        userName = strName;
        setContentView(R.layout.step_2);
        TextView tv = findViewById(R.id.textView);
        tv.setText("Очень приятно познакомиться, " + strName + "!\nМеня зовут Бисквит.\nСколько тебе лет?");
    }

    public void onStepSex(View view) {
        EditText ageEditText = findViewById(R.id.editTextSex);
        String strAge = ageEditText.getText().toString();
        if (strAge.isEmpty()) {
            Toast.makeText(this, "Пожалуйста, введите возраст", Toast.LENGTH_SHORT).show();
            return;
        }
        userAge = strAge;
        setContentView(R.layout.step_3);

        TextView tv = findViewById(R.id.textView);
        tv.setText("Ничего себе ты большой, целых " + strAge + " лет\n\nКакого ты пола?");
    }

    public void onMaleSelected(View view) {
        RadioButton radioMale = findViewById(R.id.radioButton);
        RadioButton radioFemale = findViewById(R.id.radioButton2);

        radioMale.setChecked(true);
        radioFemale.setChecked(false);
        userGender = "Мужского";
    }

    public void onFemaleSelected(View view) {
        RadioButton radioMale = findViewById(R.id.radioButton);
        RadioButton radioFemale = findViewById(R.id.radioButton2);

        radioMale.setChecked(false);
        radioFemale.setChecked(true);
        userGender = "Женского";
    }

    public void onStepGender(View view) {
        if (userGender == null) {
            Toast.makeText(this, "Пожалуйста, выберите пол", Toast.LENGTH_SHORT).show();
            return;
        }

        String result = "Собранные данные:\n\n" +
                "Имя: " + userName + "\n" +
                "Возраст: " + userAge + " лет\n" +
                "Пол: " + userGender;
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();

        setContentView(R.layout.step_4);
    }

    public void onStepEmail(View view) {
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextNumber = findViewById(R.id.editTextNumber);

        String email = editTextEmail.getText().toString().trim();
        String phone = editTextNumber.getText().toString().trim();
        boolean isEmailValid = email.contains("@") && email.contains(".");
        boolean isPhoneValid = !phone.isEmpty() && phone.matches(".*\\d.*");

        if (isEmailValid && isPhoneValid) {
            Toast.makeText(this, "Спасибо за ваши данные", Toast.LENGTH_SHORT).show();
        } else {
            String message = "Пожалуйста, заполните правильно: ";
            if (!isEmailValid) message += "почту ";
            if (!isPhoneValid) message += "и телефон";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}