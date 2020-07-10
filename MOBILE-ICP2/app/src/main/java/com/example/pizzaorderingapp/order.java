package com.example.pizzaorderingapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        TextView sum = (TextView)findViewById(R.id.sum);
        final String summary = getIntent().getStringExtra("SUMMARY");
        final String Name = getIntent().getStringExtra("USER");
        sum.setText(getIntent().getStringExtra("SUMMARY"));
        Button or_btn = (Button)findViewById(R.id.ordernow);
        or_btn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                String subject  = "order details for the customer: " + Name;
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"pizzahut.gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,summary);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose Email Client please"));
            }
        });
    }
}