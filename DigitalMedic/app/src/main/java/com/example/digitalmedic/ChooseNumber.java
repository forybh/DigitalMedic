package com.example.digitalmedic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class ChooseNumber extends AppCompatActivity {
    private Button btn_back;
    private int selectedNumber = 1;
    private boolean newBoardCreating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_choose);

        btn_back = (Button) findViewById(R.id.btn_back_sud_choose);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        initializeSpinner();
        newBoardCreating = getIntent().getBooleanExtra("newBoard", false);
    }

    private void initializeSpinner() {
        final Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numbers);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedNumber = numbers[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void chooseNumberButtonClicked(View view) {
        Intent intent = new Intent();
        intent.putExtra("chosenNumber", selectedNumber);
        setResult(RESULT_OK, intent);
        finish();
    }


}

