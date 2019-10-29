package com.giorgi.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public float first;
    public String secondStr = "";
    public float second;
    public String actionType;
    public boolean finalResult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView calculatorScreen = findViewById(R.id.calculatorScreen);
        // Buttons
        final Button n0 = findViewById(R.id.n0);
        final Button n1 = findViewById(R.id.n1);
        final Button n2 = findViewById(R.id.n2);
        final Button n3 = findViewById(R.id.n3);
        final Button n4 = findViewById(R.id.n4);
        final Button n5 = findViewById(R.id.n5);
        final Button n6 = findViewById(R.id.n6);
        final Button n7 = findViewById(R.id.n7);
        final Button n8 = findViewById(R.id.n8);
        final Button n9 = findViewById(R.id.n9);
        final Button division = findViewById(R.id.division);
        final Button multiplication = findViewById(R.id.multiplication);
        final Button substraction = findViewById(R.id.substraction);
        final Button addition = findViewById(R.id.addition);
        final Button equals = findViewById(R.id.equals);
        final Button dot = findViewById(R.id.dot);

        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int id = view.getId();
                switch (id) {
                    case R.id.n0:
//                        Toast.makeText(getApplicationContext(),"Works!",Toast.LENGTH_SHORT).show();
                        calculatorScreen.append("0");
                        doCalculation("0", calculatorScreen);
                        break;
                    case R.id.n1:
                        calculatorScreen.append("1");
                        doCalculation("1", calculatorScreen);
                        break;
                    case R.id.n2:
                        calculatorScreen.append("2");
                        doCalculation("2", calculatorScreen);
                        break;
                    case R.id.n3:
                        calculatorScreen.append("3");
                        doCalculation("3", calculatorScreen);
                        break;
                    case R.id.n4:
                        calculatorScreen.append("4");
                        doCalculation("4", calculatorScreen);
                        break;
                    case R.id.n5:
                        calculatorScreen.append("5");
                        doCalculation("5", calculatorScreen);
                        break;
                    case R.id.n6:
                        calculatorScreen.append("6");
                        doCalculation("6", calculatorScreen);
                        break;
                    case R.id.n7:
                        calculatorScreen.append("7");
                        doCalculation("7", calculatorScreen);
                        break;
                    case R.id.n8:
                        calculatorScreen.append("8");
                        doCalculation("8", calculatorScreen);
                        break;
                    case R.id.n9:
                        calculatorScreen.append("9");
                        doCalculation("9", calculatorScreen);
                        break;
                    case R.id.division:
                        first = Float.parseFloat(calculatorScreen.getText().toString());
                        calculatorScreen.append("/");
                        doCalculation("/", calculatorScreen);
                        break;
                    case R.id.multiplication:
                        first = Float.parseFloat(calculatorScreen.getText().toString());
                        calculatorScreen.append("*");
                        doCalculation("*", calculatorScreen);
                        break;
                    case R.id.substraction:
                        first = Float.parseFloat(calculatorScreen.getText().toString());
                        calculatorScreen.append("-");
                        doCalculation("-", calculatorScreen);
                        break;
                    case R.id.addition:
                        first = Float.parseFloat(calculatorScreen.getText().toString());
                        calculatorScreen.append("+");
                        doCalculation("+", calculatorScreen);
                        break;
                    case R.id.equals:
                        calculatorScreen.append("=");
                        doCalculation("=", calculatorScreen);
                        break;
                    case R.id.dot:
//                        first = Integer.parseInt(calculatorScreen.getText().toString());
                        calculatorScreen.append(".");
                        doCalculation(".", calculatorScreen);
                        break;
                }
            }
        };

        n0.setOnClickListener(calculatorListener);
        n1.setOnClickListener(calculatorListener);
        n2.setOnClickListener(calculatorListener);
        n3.setOnClickListener(calculatorListener);
        n4.setOnClickListener(calculatorListener);
        n5.setOnClickListener(calculatorListener);
        n6.setOnClickListener(calculatorListener);
        n7.setOnClickListener(calculatorListener);
        n8.setOnClickListener(calculatorListener);
        n9.setOnClickListener(calculatorListener);
        division.setOnClickListener(calculatorListener);
        multiplication.setOnClickListener(calculatorListener);
        substraction.setOnClickListener(calculatorListener);
        addition.setOnClickListener(calculatorListener);
        equals.setOnClickListener(calculatorListener);
        dot.setOnClickListener(calculatorListener);
    }

    public void doCalculation(String str, TextView screen) {
        if (finalResult) {
            screen.setText(str);
            finalResult = false;
        }


        if (actionType == null) {
            if (str == "/") {
                actionType = "/";
            } else if (str == "*") {
                actionType = "*";
            } else if (str == "-") {
                actionType = "-";
            } else if (str == "+") {
                actionType = "+";
            }
        } else {

            if (str == "=") {
                second = Float.parseFloat(secondStr);
                String result = "";
                switch (actionType) {
                    case "/":
                        result = String.valueOf(first / second);
                        break;
                    case "*":
                        result = String.valueOf(first * second);
                        break;
                    case "-":
                        result = String.valueOf(first - second);
                        break;
                    case "+":
                        result = String.valueOf(first + second);
                        break;
                }
                screen.setText(result);
                finalResult = true;
                first = 0;
                second = 0;
                secondStr = "";
                actionType = null;
            } else {
                secondStr = secondStr + str;
            }

        }
    }
}
