package com.example.spinnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner sp;
    private TextView result_txt;
    private EditText v1, v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = (Spinner) findViewById(R.id.spinner);
        result_txt = (TextView) findViewById(R.id.resultTxt);
        v1 = (EditText) findViewById(R.id.value1);
        v2 = (EditText) findViewById(R.id.value2);
        String[] opciones = {"Sum" , "Subtract" , "Multiply" , "Divide"};

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item , opciones);
        sp.setAdapter(adapter);
    }

    public void Calculate (View view){
        int valor1 = Integer.parseInt(v1.getText().toString());
        int valor2 = Integer.parseInt(v2.getText().toString());
        int resultado = 0;

        String selected = sp.getSelectedItem().toString();
        switch (selected){
            case "Sum":
                resultado = valor1 + valor2;
                break;
            case "Subtract":
                resultado = valor1 - valor2;
                break;
            case "Multiply":
                resultado = valor1 * valor2;
                break;
            case "Divide":
                if (valor2 != 0){
                    resultado = valor1 / valor2;
                }
                else{
                    Toast.makeText(this,"You can´t divide by zero :(",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Toast.makeText(this,"You have to select a operation first",Toast.LENGTH_SHORT).show();
        }


        result_txt.setText("The result is " + resultado);
    }

}
