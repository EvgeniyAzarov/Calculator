package com.evgeniy.calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    TextView tvNum;

    Button btnDel;
    Button btnMul;
    Button btnDiv;
    Button btnSub;
    Button btnAdd;

    Button btnPoint;
    Button btnEqual;

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNum = (TextView) findViewById(R.id.tvNum);

        btnDel = (Button) findViewById(R.id.btnDel); btnDel.setOnClickListener(this);
        btnMul = (Button) findViewById(R.id.btnMul); btnMul.setOnClickListener(this);
        btnDiv = (Button) findViewById(R.id.btnDiv); btnDiv.setOnClickListener(this);
        btnSub = (Button) findViewById(R.id.btnSub); btnSub.setOnClickListener(this);
        btnAdd = (Button) findViewById(R.id.btnAdd); btnAdd.setOnClickListener(this);

        btnPoint = (Button) findViewById(R.id.btnPoint); btnPoint.setOnClickListener(this);
        btnEqual = (Button) findViewById(R.id.btnEqual); btnEqual.setOnClickListener(this);

        btn0 = (Button) findViewById(R.id.btn0); btn0.setOnClickListener(this);
        btn1 = (Button) findViewById(R.id.btn1); btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2); btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btn3); btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btn4); btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.btn5); btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.btn6); btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.btn7); btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.btn8); btn8.setOnClickListener(this);
        btn9 = (Button) findViewById(R.id.btn9); btn9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                if (!tvNum.getText().toString().equals("0")) {
                    tvNum.setText(tvNum.getText().toString() + "0");
                } break;

            case R.id.btn1:
                if (!tvNum.getText().toString().equals("0")) {
                    tvNum.setText(tvNum.getText().toString() + "1");
                } else {
                    tvNum.setText("1");
                } break;

            case R.id.btn2:
                if (!tvNum.getText().toString().equals("0")) {
                    tvNum.setText(tvNum.getText().toString() + "2");
                } else {
                    tvNum.setText("2");
                } break;

            case R.id.btn3:
                if (!tvNum.getText().toString().equals("0")) {
                    tvNum.setText(tvNum.getText().toString() + "3");
                } else {
                    tvNum.setText("3");
                } break;

            case R.id.btn4:
                if (!tvNum.getText().toString().equals("0")) {
                    tvNum.setText(tvNum.getText().toString() + "4");
                } else {
                    tvNum.setText("4");
                } break;

            case R.id.btn5:
                if (!tvNum.getText().toString().equals("0")) {
                    tvNum.setText(tvNum.getText().toString() + "5");
                } else {
                    tvNum.setText("5");
                } break;

            case R.id.btn6:
                if (!tvNum.getText().toString().equals("0")) {
                    tvNum.setText(tvNum.getText().toString() + "6");
                } else {
                    tvNum.setText("6");
                } break;

            case R.id.btn7:
                if (!tvNum.getText().toString().equals("0")) {
                    tvNum.setText(tvNum.getText().toString() + "7");
                } else {
                    tvNum.setText("7");
                } break;

            case R.id.btn8:
                if (!tvNum.getText().toString().equals("0")) {
                    tvNum.setText(tvNum.getText().toString() + "8");
                } else {
                    tvNum.setText("8");
                } break;

            case R.id.btn9:
                if (!tvNum.getText().toString().equals("0")) {
                    tvNum.setText(tvNum.getText().toString() + "9");
                } else {
                    tvNum.setText("9");
                } break;

            case R.id.btnPoint:
                if (!tvNum.getText().toString().contains(String.valueOf('.'))) {
                    tvNum.setText(tvNum.getText().toString() + ".");
                } break;

            case R.id.btnDel:
                if (tvNum.length() != 1) {
                    tvNum.setText(tvNum.getText().toString().substring(0, tvNum.length()-1));
                } else {
                    tvNum.setText("0");
                } break;
        }
    }

    private boolean tvNumIsFull() {
        if (tvNum.length() == 15) {
            Toast.makeText(this, "Превышено максимальное число цифр(15)", Toast.LENGTH_SHORT).show();
            return true;
        } else return false;
    }
}

