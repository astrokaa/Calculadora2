package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculadora.Calculator;
import com.example.calculadora.R;

/**
 * @author Alexis
 * @version 1.0
 * @since 1.0
 */

public class MainActivity extends AppCompatActivity {

    private TextView pantalla;
    private String currentText = "";
    private Calculator calculadora;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = findViewById(R.id.display);
        calculadora = new Calculator();


        Button numero0 = findViewById(R.id.button0);
        Button numero1 = findViewById(R.id.button1);
        Button numero2 = findViewById(R.id.button2);
        Button numero3 = findViewById(R.id.button3);
        Button numero4 = findViewById(R.id.button4);
        Button numero5 = findViewById(R.id.button5);
        Button numero6 = findViewById(R.id.button6);
        Button numero7 = findViewById(R.id.button7);
        Button numero8 = findViewById(R.id.button8);
        Button numero9 = findViewById(R.id.button9);
        Button suma = findViewById(R.id.buttonPlus);
        Button resta = findViewById(R.id.buttonMinus);
        Button multiplicar = findViewById(R.id.buttonMulti);
        Button dividir = findViewById(R.id.buttonDiv);
        Button igual = findViewById(R.id.buttonEquals);
        Button borrar = findViewById(R.id.buttonClear);


        numero0.setOnClickListener(v -> appendToDisplay("0"));
        numero1.setOnClickListener(v -> appendToDisplay("1"));
        numero2.setOnClickListener(v -> appendToDisplay("2"));
        numero3.setOnClickListener(v -> appendToDisplay("3"));
        numero4.setOnClickListener(v -> appendToDisplay("4"));
        numero5.setOnClickListener(v -> appendToDisplay("5"));
        numero6.setOnClickListener(v -> appendToDisplay("6"));
        numero7.setOnClickListener(v -> appendToDisplay("7"));
        numero8.setOnClickListener(v -> appendToDisplay("8"));
        numero9.setOnClickListener(v -> appendToDisplay("9"));

        suma.setOnClickListener(v -> appendToDisplay("+"));
        resta.setOnClickListener(v -> appendToDisplay("-"));
        multiplicar.setOnClickListener(v -> appendToDisplay("*"));
        dividir.setOnClickListener(v -> appendToDisplay("/"));

        borrar.setOnClickListener(v -> {
            currentText = "";
            pantalla.setText(currentText);
        });

        igual.setOnClickListener(v -> {
            try {
                int resultado = calculadora.hacerOperacion(currentText);
                pantalla.setText(String.valueOf(resultado));
            } catch (Exception e) {
                pantalla.setText("Error");
            }
            currentText = "";
        });
    }


    private void appendToDisplay(String valor) {
        currentText += valor;
        pantalla.setText(currentText);
    }
}
