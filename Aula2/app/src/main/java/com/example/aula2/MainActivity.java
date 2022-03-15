package com.example.aula2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteCurso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteCurso =
                (AutoCompleteTextView) findViewById(R.id.editTextCurso);

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

    }
    public void buttonSalvarClick(View view){
        Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
    }
}