package com.evgeniy.calc;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.evgeniy.calc.MainActivity.OperationType.NULL;

public class MainActivity extends Activity implements View.OnClickListener {

    enum OperationType {ADD, SUBTRACT, MULTIPLE, DIVISION, NULL}

    private double firstNumber = 0;

    boolean resetNumber = false;

    boolean newNumber = false;

    private OperationType operation = NULL;

    private EditText etNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum = (EditText) findViewById(R.id.etNum);
        etNum.setText("0");

        Button btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);
        btnDel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etNum.setText("0");
                operation = NULL;
                return true;
            }
        });

        Button btnMul = (Button) findViewById(R.id.btnMul);
        btnMul.setOnClickListener(this);
        btnMul.setTag(OperationType.MULTIPLE);

        Button btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);
        btnDiv.setTag(OperationType.DIVISION);

        Button btnSub = (Button) findViewById(R.id.btnSub);
        btnSub.setOnClickListener(this);
        btnSub.setTag(OperationType.SUBTRACT);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnAdd.setTag(OperationType.ADD);

        Button btnPoint = (Button) findViewById(R.id.btnPoint);
        btnPoint.setOnClickListener(this);

        Button btnEqual = (Button) findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(this);

        Button btnPlusMinus = (Button) findViewById(R.id.btnPlusMinus);
        btnPlusMinus.setOnClickListener(this);

        Button btn0 = (Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btn0.setTag(0);

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn1.setTag(1);

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn2.setTag(2);

        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn3.setTag(3);

        Button btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn4.setTag(4);

        Button btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn5.setTag(5);

        Button btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn6.setTag(6);

        Button btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn7.setTag(7);

        Button btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn8.setTag(8);

        Button btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btn9.setTag(9);

        loadText();
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
                    etNum.setText("0");
                    resetNumber = false;
                }

                if (!tvNumIsFull()) {
                    if (!etNum.getText().toString().equals("0")) {
                        etNum.setText(etNum.getText().toString() + view.getTag().toString());
                    } else {
                        etNum.setText(view.getTag().toString());
                    }
                }
                newNumber = true;
                break;

            case R.id.btnPoint:
                if (!etNum.getText().toString().contains(String.valueOf('.'))
                        && !tvNumIsFull()) {
                    etNum.setText(etNum.getText().toString() + ".");
                }
                break;

            case R.id.btnDel:
                if (etNum.length() > 1
                        && !etNum.getText().toString().equals("NaN")
                        && etNum.getText().toString().charAt(etNum.length() - 2) != '.'
                        && etNum.getText().toString().charAt(etNum.length() - 2) != '-') {
                    etNum.setText(etNum.getText().toString().substring(0, etNum.length() - 1));
                } else if (etNum.length() > 2
                        && etNum.getText().toString().charAt(etNum.length() - 2) == '.') {
                    etNum.setText(etNum.getText().toString().substring(0, etNum.length() - 2));
                } else {
                    etNum.setText("0");
                    operation = NULL;
                }
                break;

            case R.id.btnPlusMinus:
                if (!etNum.getText().toString().equals("0")) {
                    if (etNum.getText().toString().charAt(0) == '-') {
                        etNum.setText(etNum.getText().toString().substring(1, etNum.length()));
                    } else {
                        etNum.setText("-" + etNum.getText().toString());
                    }
                }
                break;

            case R.id.btnAdd:

            case R.id.btnSub:

            case R.id.btnMul:

            case R.id.btnDiv:

                double secondNumber;

                resetNumber = true;

                if (newNumber && operation != NULL) {
                    secondNumber = Double.valueOf(etNum.getText().toString());
                    etNum.setText(doCalc(firstNumber, secondNumber, operation));
                }
                firstNumber = Double.valueOf(etNum.getText().toString());

                operation = (OperationType) view.getTag();

                newNumber = false;

                break;

            case R.id.btnEqual:

                if (operation != NULL) {
                    secondNumber = Double.valueOf(etNum.getText().toString());
                    etNum.setText(doCalc(firstNumber, secondNumber, operation));
                    resetNumber = true;
                }
                operation = NULL;
                break;
        }
    }

    private String doCalc(double a, double b, OperationType operationType) {

        double result = 0;

        switch (operationType) {
            case ADD:
                result = a + b;
                break;

            case SUBTRACT:
                result = a - b;
                break;

            case MULTIPLE:
                result = a * b;
                break;

            case DIVISION:
                if (b != 0) result = a / b;
                else return "NaN";
                break;
        }

        return ((result % 1 == 0) ? (Double.toString((int) result)) : (Double.toString(result)));
    }

    private boolean tvNumIsFull() {
        if (etNum.length() == 15) {
            Toast.makeText(this, "Превышено максимальное число цифр(15)", Toast.LENGTH_SHORT).show();
            return true;
        } else return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveText();
    }

    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_text";

    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etNum.getText().toString());
        ed.apply();
    }

    void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        etNum.setText(savedText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                // TODO add open settings activity
                return true;

            case R.id.action_about:
                // TODO add open about activity
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

