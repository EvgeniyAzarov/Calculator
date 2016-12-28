package com.evgeniy.calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.evgeniy.calc.MainActivity.OperationType.NULL;

public class MainActivity extends Activity implements View.OnClickListener {

    enum OperationType {ADD, SUBTRACT, MULTIPLE, DIVISION, NULL}

    private double firstNumber = 0;
    private double secondNumber = 0;

    boolean resetNumber = false;

    boolean newNumber = false;

    private OperationType operation = NULL;

    private TextView tvNum;

    private Button btnDel;
    private Button btnMul;
    private Button btnDiv;
    private Button btnSub;
    private Button btnAdd;

    private Button btnPoint;
    private Button btnEqual;

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNum = (TextView) findViewById(R.id.tvNum);

        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);

        btnMul = (Button) findViewById(R.id.btnMul);
        btnMul.setOnClickListener(this);
        btnMul.setTag(OperationType.MULTIPLE);

        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);
        btnDiv.setTag(OperationType.DIVISION);

        btnSub = (Button) findViewById(R.id.btnSub);
        btnSub.setOnClickListener(this);
        btnSub.setTag(OperationType.SUBTRACT);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnAdd.setTag(OperationType.ADD);

        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnPoint.setOnClickListener(this);

        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(this);

        btn0 = (Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btn0.setTag(0);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn1.setTag(1);

        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn2.setTag(2);

        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn3.setTag(3);

        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn4.setTag(4);

        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn5.setTag(5);

        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn6.setTag(6);

        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn7.setTag(7);

        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn8.setTag(8);

        btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btn9.setTag(9);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn0:

            case R.id.btn1:

            case R.id.btn2:

            case R.id.btn3:

            case R.id.btn4:

            case R.id.btn5:

            case R.id.btn6:

            case R.id.btn7:

            case R.id.btn8:

            case R.id.btn9:

                if (resetNumber) {
                    tvNum.setText("0");
                    resetNumber = false;
                }

                if (!tvNumIsFull()) {
                    if (!tvNum.getText().toString().equals("0")) {
                        tvNum.setText(tvNum.getText().toString() + view.getTag().toString());
                    } else {
                        tvNum.setText(view.getTag().toString());
                    }
                }
                newNumber = true;
                break;

            case R.id.btnPoint:
                if (!tvNum.getText().toString().contains(String.valueOf('.'))
                        && !tvNumIsFull()) {
                    tvNum.setText(tvNum.getText().toString() + ".");
                }
                break;

            case R.id.btnDel:
                if (tvNum.length() != 1 && !tvNum.getText().toString().equals("NaN")) {
                    tvNum.setText(tvNum.getText().toString().substring(0, tvNum.length() - 1));
                } else {
                    tvNum.setText("0");
                }
                break;

            case R.id.btnAdd:

            case R.id.btnSub:

            case R.id.btnMul:

            case R.id.btnDiv:

                if (newNumber) {
                    if (operation != NULL) {
                        secondNumber = Double.valueOf(tvNum.getText().toString());
                        tvNum.setText(doCalc(firstNumber, secondNumber, operation));
                        newNumber = false;
                    }

                    operation = (OperationType) view.getTag();

                    firstNumber = Double.valueOf(tvNum.getText().toString());

                    resetNumber = true;
                } else {
                    operation = (OperationType) view.getTag();
                }

                break;

            case R.id.btnEqual:

                if (operation != NULL) {
                    secondNumber = Double.valueOf(tvNum.getText().toString());
                    tvNum.setText(doCalc(firstNumber, secondNumber, operation));
                }
                operation = NULL;
                break;
        }
    }

    private String doCalc(double a, double b, OperationType oper) {
        switch (oper) {
            case ADD:
                return Double.toString(a + b);

            case SUBTRACT:
                return Double.toString(a - b);

            case MULTIPLE:
                return Double.toString(a * b);

            case DIVISION:
                return (b != 0 ? Double.toString(a / b) : ("NaN"));
        }

        return "Ilia lox";
    }

    private boolean tvNumIsFull() {
        if (tvNum.length() == 14) {
            Toast.makeText(this, "Превышено максимальное число цифр(14)", Toast.LENGTH_SHORT).show();
            return true;
        } else return false;
    }
}

