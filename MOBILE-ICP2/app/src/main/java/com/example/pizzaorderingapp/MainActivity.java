package com.example.pizzaorderingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Summary  = (Button)findViewById(R.id.summary);
        Summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewSummary(view);
            }
        });

        Button order  = (Button)findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewOrder(view);
            }
        });
    }
    /*diplay quantity */

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
//INCREMENT
    public void increment(View view) {
        if (quantity < 50) {
            quantity = quantity + 1;
            display(quantity);
        } else {
            Toast.makeText(getApplicationContext(), "error overquantity", Toast.LENGTH_SHORT).show();

            return;

        }

    }
    // DECREMENT
    public void decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
            display(quantity);
        } else {
            Toast.makeText(getApplicationContext(), "error minimum quantity", Toast.LENGTH_SHORT).show();

            return;

        }
    }

    public void ViewSummary(View view) {
        EditText name = findViewById(R.id.userid);
        String user = name.getText().toString();

        CheckBox olives = findViewById(R.id.Olivesid);
        Boolean olive = olives.isChecked();

        CheckBox tomatoes = findViewById(R.id.Olivesid);
        Boolean tomato = tomatoes.isChecked();

        CheckBox pineapples = findViewById(R.id.Pineappleid);
        Boolean pineapple = pineapples.isChecked();

        CheckBox onions = findViewById(R.id.Pineappleid);
        Boolean onion = pineapples.isChecked();

        // calculate and store the total price

        float totalPrice = calculatePrice(olive, tomato, pineapple, onion);
        // create and store the order summary
        final String orderSummaryMessage = createOrderSummary(user, olive, tomato, pineapple, onion, totalPrice);

        Intent intent = new Intent(MainActivity.this, summary.class);

        intent.putExtra("USER", user);

        intent.putExtra("SUMMARY", orderSummaryMessage);

        startActivity(intent);

    }

    public void ViewOrder(View view) {
        EditText name = findViewById(R.id.userid);
        String user = name.getText().toString();

        CheckBox olives = findViewById(R.id.Olivesid);
        Boolean olive = olives.isChecked();

        CheckBox tomatoes = findViewById(R.id.Olivesid);
        Boolean tomato = tomatoes.isChecked();

        CheckBox pineapples = findViewById(R.id.Pineappleid);
        Boolean pineapple = pineapples.isChecked();

        CheckBox onions = findViewById(R.id.Pineappleid);
        Boolean onion = pineapples.isChecked();

        // calculate and store the total price

        float totalPrice = calculatePrice(olive, tomato, pineapple, onion);
        // create and store the order summary
        final String orderMessage = createOrder(user, olive, tomato, pineapple, onion, totalPrice);

        Intent intent = new Intent(MainActivity.this, order.class);

        intent.putExtra("NAME", user);

        intent.putExtra("SUMMARY", orderMessage);

        startActivity(intent);

    }
    private String createOrderSummary(String user, Boolean olive, Boolean tomato, Boolean pineapple, Boolean onion, float totalPrice) {
        String orderSummaryMessage ="Ordered by: "+user+"\n"+"olive:"+olive.toString()+"\n"+"tomatoes:"+tomato+"\n"+"Pineapple:"+pineapple+"\n"+"onion:"+onion+"\n"+"Quantity:"+quantity+"\n"+"Total Price:"+calculatePrice(olive,tomato,pineapple,onion);

        return orderSummaryMessage;

    }

    private String createOrder(String user, Boolean olive, Boolean tomato, Boolean pineapple, Boolean onion, float totalPrice) {
        String orderMessage ="Ordered by: "+user+"\n"+"olive:"+olive.toString()+"\n"+"tomatoes:"+tomato+"\n"+"Pineapple:"+pineapple+"\n"+"onion:"+onion+"\n"+"Quantity:"+quantity+"\n"+"Total Price:"+calculatePrice(olive,tomato,pineapple,onion);

        return orderMessage;
    }
    private float calculatePrice(Boolean olive, Boolean tomato, Boolean pineapple, Boolean onion) {

        int price =10;
        if (olive){
            price = price+3;
        }
        if (tomato){
            price = price+2;
        }
        if (pineapple){
            price = price+4;
        }
        if (onion){
            price = price+1;
        }

        return price*quantity;

    }
}