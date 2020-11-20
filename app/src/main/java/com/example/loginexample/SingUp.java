package com.example.loginexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SingUp extends AppCompatActivity implements View.OnClickListener {
    private EditText login;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        login = findViewById(R.id.loginSingUp);
        password = findViewById(R.id.passwordSingUp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                Intent intent = new Intent();
                intent.putExtra("login", login.getText().toString());
                intent.putExtra("password", password.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}