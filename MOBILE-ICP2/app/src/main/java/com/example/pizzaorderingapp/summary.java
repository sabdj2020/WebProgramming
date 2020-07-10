package com.example.pizzaorderingapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class summary extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        TextView sum = (TextView)findViewById(R.id.sum);
        final String summary = getIntent().getStringExtra("SUMMARY");
        final String Name = getIntent().getStringExtra("USER");
        sum.setText(getIntent().getStringExtra("SUMMARY"));
        Button back = findViewById(R.id.goback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirect_tomain = new Intent(summary.this,MainActivity.class );
                startActivity(redirect_tomain);
            }
        });
    }

}