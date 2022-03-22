package com.example.aula2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteCurso;
    Spinner spinnerCurso;
    Chip chip2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteCurso = (AutoCompleteTextView) findViewById(R.id.editTextCurso);
        spinnerCurso = (Spinner)findViewById(R.id.spinnerCurso);
        chip2 = (Chip)findViewById(R.id.chip2); 
        
        chip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicou!!!", Toast.LENGTH_SHORT).show();
            }
        });
        chip2.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicou no fechar", Toast.LENGTH_SHORT).show();
            }
        });
        
        autoCompleteCurso.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean retorno = false;
                if(actionId == EditorInfo.IME_ACTION_SEND){
                    buttonSalvarClick(null);
                    retorno = true;
                }
                return retorno;
            }
        });
        String[] cursos = getResources().getStringArray(R.array.cursos_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,cursos);
        autoCompleteCurso.setAdapter(adapter);
        spinnerCurso.setAdapter(adapter);
    }
    public void buttonSalvarClick(View view){
        Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
    }

    public void checkBoxRepresentanteClick(View view){
        CheckBox check = (CheckBox) view;
        if(check.isChecked())
            Toast.makeText(this, "É Representante", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Não é Representante", Toast.LENGTH_SHORT).show();
    }

    public void radioSexoClick(View view){
        RadioButton radio = (RadioButton) view;
        switch (radio.getId()){
            case R.id.radioButtonMasculino:
                if(radio.isChecked())
                    Toast.makeText(this,"Masculino marcado",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButtonFeminino:
                if(radio.isChecked())
                    Toast.makeText(this,"Feminino marcado",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}