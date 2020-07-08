package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.userid);
        password = findViewById(R.id.pwdid);
        login = findViewById(R.id.btnid);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userinput = username.getText().toString();
                String pwdinput = password.getText().toString();

                if (userinput.isEmpty() || pwdinput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "details not given", Toast.LENGTH_SHORT).show();
                } else {
                    if (userinput.equals("sabrina") && pwdinput.equals("123")) {
                        Toast.makeText(MainActivity.this, "login successfully", Toast.LENGTH_SHORT).show();
                        //go to user page
                        Intent intent = new Intent(MainActivity.this, HomePage.class );
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "login not successfull", Toast.LENGTH_SHORT).show();
                    }

                }
            }
            });
    }
    }