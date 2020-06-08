package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OPERATOR{
        PLUS,SUBTRACT,MULTIPLY,DIVIDE,EQUAL;
    }

    TextView txtCalculation;
    TextView txtResult;
    ImageButton btnOne;
    ImageButton btnTwo;
    ImageButton btnThree;
    ImageButton btnFour;
    ImageButton btnFive;
    ImageButton btnSix;
    ImageButton btnSeven;
    ImageButton btnEight;
    ImageButton btnNine;
    ImageButton btnZero;
    Button btnClear;
    ImageView btnEquals;
    ImageView btnPlus;
    ImageView btnSubtract;
    ImageView btnMultiply;
    ImageView btnDivide;

    private String currentNumber;
    private String numbetAtLeft;
    private String numberAtRight;
    private OPERATOR currentOperator;
    private int calculationResult;
    private String calclationString;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        currentNumber="";
        calclationString="";
        calculationResult=0;


        txtCalculation=findViewById(R.id.txtCalculation);
        txtResult=findViewById(R.id.txtResult);
        btnOne=findViewById(R.id.btnOne);
        btnTwo=findViewById(R.id.btnTwo);
        btnThree=findViewById(R.id.btnThree);
        btnFour=findViewById(R.id.btnFour);
        btnFive=findViewById(R.id.btnFive);
        btnSix=findViewById(R.id.btnSix);
        btnSeven=findViewById(R.id.btnSeven);
        btnEight=findViewById(R.id.btnEight);
        btnNine=findViewById(R.id.btnNine);
        btnClear=findViewById(R.id.btnClear);
        btnZero=findViewById(R.id.btnZero);
        btnEquals=findViewById(R.id.btnEquals);
        btnPlus=findViewById(R.id.btnPlus);
        btnSubtract=findViewById(R.id.btnSubtract);
        btnMultiply=findViewById(R.id.btnMultiply);
        btnDivide=findViewById(R.id.btnDivide);

        btnZero.setOnClickListener(MainActivity.this);
        btnOne.setOnClickListener(MainActivity.this);
        btnTwo.setOnClickListener(MainActivity.this);
        btnThree.setOnClickListener(MainActivity.this);
        btnFour.setOnClickListener(MainActivity.this);
        btnFive.setOnClickListener(MainActivity.this);
        btnSix.setOnClickListener(MainActivity.this);
        btnSeven.setOnClickListener(MainActivity.this);
        btnEight.setOnClickListener(MainActivity.this);
        btnNine.setOnClickListener(MainActivity.this);
        btnClear.setOnClickListener(MainActivity.this);
        btnEquals.setOnClickListener(MainActivity.this);
        btnPlus.setOnClickListener(MainActivity.this);
        btnSubtract.setOnClickListener(MainActivity.this);
        btnMultiply.setOnClickListener(MainActivity.this);
        btnDivide.setOnClickListener(MainActivity.this);





    }


    public void onClick(View v) {

       switch (v.getId()){
           case R.id.btnZero:
               buttonIsTapped(0);
               break;
           case R.id.btnOne:
               buttonIsTapped(1);
               break;
           case R.id.btnTwo:
               buttonIsTapped(2);
               break;
           case R.id.btnThree:
               buttonIsTapped(3);
               break;
           case R.id.btnFour:
               buttonIsTapped(4);
               break;
           case R.id.btnFive:
               buttonIsTapped(5);
               break;
           case R.id.btnSix:
               buttonIsTapped(6);
               break;
           case R.id.btnSeven:
               buttonIsTapped(7);
               break;
           case R.id.btnEight:
               buttonIsTapped(8);
               break;
           case R.id.btnNine:
               buttonIsTapped(9);
               break;
           case R.id.btnClear:
               ClearTapped();
               break;
           case R.id.btnEquals:
               operatorIsTapped(OPERATOR.EQUAL);
               break;
           case R.id.btnPlus:
               operatorIsTapped(OPERATOR.PLUS);
               calclationString=calclationString + " + ";
               break;
           case R.id.btnSubtract:
               operatorIsTapped(OPERATOR.SUBTRACT);
               calclationString=calclationString + " - ";
               break;
           case R.id.btnMultiply:
               operatorIsTapped(OPERATOR.MULTIPLY);
               calclationString=calclationString + " * ";
               break;
           case R.id.btnDivide:
               operatorIsTapped(OPERATOR.DIVIDE);
               calclationString=calclationString + " / ";
               break;
       }
       txtCalculation.setText(calclationString);

    }

    private void buttonIsTapped(int numberTapped){

        currentNumber+=String.valueOf(numberTapped);
        txtResult.setText(currentNumber);

        calclationString=currentNumber;
        txtCalculation.setText(calclationString);


    }

    private void operatorIsTapped(OPERATOR tappedOperator){


        if(currentOperator!=null){
            if(currentNumber!= ""){



                numberAtRight=currentNumber;
                currentNumber="";
                switch (currentOperator){
                    case PLUS:
                        calculationResult= Integer.parseInt(numbetAtLeft)+Integer.parseInt(numberAtRight);
                        break;
                    case SUBTRACT:
                        calculationResult=Integer.parseInt(numbetAtLeft)-Integer.parseInt(numberAtRight);
                        break;
                    case MULTIPLY:
                        calculationResult=Integer.parseInt(numbetAtLeft)* Integer.parseInt(numberAtRight);
                        break;
                    case DIVIDE:
                        calculationResult=Integer.parseInt(numbetAtLeft)/Integer.parseInt(numberAtRight);
                        break;
                }

                numbetAtLeft=String.valueOf(calculationResult);
                txtResult.setText(numbetAtLeft);
                calclationString=numbetAtLeft;
            }
        }
        else {
            numbetAtLeft=currentNumber;
            currentNumber="";
        }
        currentOperator=tappedOperator;
    }
    private void ClearTapped(){


        numbetAtLeft="";
        numberAtRight="";
        calculationResult=0;
        currentNumber="";
        currentOperator=null;
        txtResult.setText("0");
        calclationString="0";
    }
}
