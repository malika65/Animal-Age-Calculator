package com.example.animalagecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    Button btn;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.animalNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView resultView = findViewById(R.id.resultView);
                String text = spinner.getSelectedItem().toString();
                EditText txtname = findViewById(R.id.age);
                int age = Integer.parseInt(txtname.getText().toString());
                if (text.equals("Cat")){
                    String result = String.valueOf(24 + (age - 2 ) * 4);
                    resultView.setText(result);

                }else if (text.equals("Dog")){
                    if (age == 1){
                        String result = String.valueOf(18 + (age - 1 ) * 6);
                        resultView.setText(result);
                    }else {
                    String result = String.valueOf(21 + (age - 1 ) * 6);
                    resultView.setText(result);
                }}
                else if (text.equals("Horse")){
                    String result = String.valueOf(3 * age);
                    resultView.setText(result);
                }
                else if (text.equals("Cow")){
                    String result = String.valueOf(14 + (age - 1 ) * 4);
                    resultView.setText(result);
                }
                else if (text.equals("Snake")){
                    String result = String.valueOf(18 + (age - 1 ) * 6);
                    resultView.setText(result);
                }


            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}