package com.example.loginexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

public class SingIn extends AppCompatActivity implements View.OnClickListener {
    private static final HashMap<String, String> loginToPass = new HashMap<>();


    private Button enter;
    private EditText login;
    private EditText password;
    private TextView success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        loginToPass.put("login1", "examplePass1");

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        success = findViewById(R.id.loginSuccess);

        enter = findViewById(R.id.enter);
        enter.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.enter:
                if (loginToPass.containsKey(login.getText().toString()) &&
                        loginToPass.get(login.getText().toString()).equals(password.getText().toString())) {
                    success.setText("Верно");
                    success.setTextColor(GREEN);
                } else {
                    success.setText("Вы ошиблись в логине или пароле");
                    success.setTextColor(RED);
                }
                break;
        }
    }
}