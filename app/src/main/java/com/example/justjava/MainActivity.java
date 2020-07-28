package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        orderSummary(value);

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
    private void orderSummary(int val){
        TextView t = findViewById(R.id.quantity_value);
        String order = t.getText().toString();
        String message = "Name: " + nameOfUser();
        message += "\nAdd whipped cream? " + boxState();
        message += "\nAdd chocolate? " + chocolateState();
        message += "\nQuantity: " + order;
        message += "\n" +  "Total price: $" + val + "\nThank you!";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, "ORDER SUMMARY");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
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
    public void increment(View view){
        TextView textView = (TextView) findViewById(R.id.quantity_value);
        int value = Integer.parseInt(textView.getText().toString());
        if (value == 100){
            Toast toast = Toast.makeText(this,"You can not order more than 100 cup of coffee",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            value += 1;
        }
        display(value);
    }
    public void decrement(View view){
        TextView textView = (TextView) findViewById(R.id.quantity_value);
        int value = Integer.parseInt(textView.getText().toString());
        if (value == 1){
            Toast toast = Toast.makeText(this,"You can not order less than 1 cup of coffee",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            value -= 1;
        }
        display(value);
    }
}