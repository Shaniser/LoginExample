package com.example.loginexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

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
                    success.setText("Успешно!");
                } else {
                    Intent intent = new Intent(this, SingUp.class);
                    startActivityForResult(intent, 1);
                }
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String userLogin = data.getStringExtra("login");
        String userPassword = data.getStringExtra("password");
        loginToPass.put(userLogin, userPassword);
        login.setText(userLogin);
        password.setText(userPassword);
    }
}