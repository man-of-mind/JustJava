package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view){
        TextView quantity = findViewById(R.id.quantity_value);
        int quan = Integer.parseInt(quantity.getText().toString());
        displayPrice(quan * 5);
    }

    private void display(int number) {
        TextView textView = (TextView) findViewById(R.id.quantity_value);
        textView.setText("" + number);
    }
    private void displayPrice(int number){
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    public void increment(View view){
        TextView textView = (TextView) findViewById(R.id.quantity_value);
        int value = Integer.parseInt(textView.getText().toString()) + 1;
        display(value);
    }
    public void decrement(View view){
        TextView textView = (TextView) findViewById(R.id.quantity_value);
        int value = Integer.parseInt(textView.getText().toString()) - 1;
        display(value);
    }
}