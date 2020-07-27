package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
        int value = calculatePrice(quan);
        displayMessage(orderSummary(value));

    }

    private int calculatePrice(int value){
        int val = 5;
        if (boxState() && chocolateState()){
            val += 3;
        }
        else if (boxState()){
            val += 1;
        }
        else if(chocolateState()){
            val += 2;
        }
        return value * val;
    }
    private String orderSummary(int val){
        TextView t = findViewById(R.id.quantity_value);
        String order = t.getText().toString();
        String message = "Name: " + nameOfUser();
        message += "\nAdd whipped cream? " + boxState();
        message += "\nAdd chocolate? " + chocolateState();
        message += "\nQuantity: " + order;
        message += "\n" +  "Total price: $" + val + "\nThank you!";
        return message;
    }

    private String nameOfUser() {
        EditText name = (EditText) findViewById(R.id.name);
        String user = name.getText().toString();
        return user;
    }

    private Boolean chocolateState() {
        CheckBox box = (CheckBox) findViewById(R.id.chocolate);
        return box.isChecked();
    }

    private Boolean boxState() {
        CheckBox box = (CheckBox) findViewById(R.id.checkBox);
        return box.isChecked();
    }

    private void display(int number) {
        TextView textView = (TextView) findViewById(R.id.quantity_value);
        textView.setText("" + number);
    }
    private void displayPrice(int number){
        TextView price = (TextView) findViewById(R.id.order_summary_text);
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
    private void displayMessage(String message){
        TextView priceTag = (TextView) findViewById(R.id.order_summary_text);
        priceTag.setText(message);
    }
}