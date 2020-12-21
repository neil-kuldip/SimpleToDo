package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class EditActivity extends AppCompatActivity {

    EditText etItem2;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem2 = findViewById(R.id.etItem2);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        etItem2.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        // When the user is finished editing the item, they save the changes
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent that will contain the results
                Intent intent = new Intent();

                // Pass the editing results to MainActivity
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItem2.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                // Set the results of the intent
                setResult(RESULT_OK, intent);

                // Finish the activity (close the screen and return to MainActivity)
                finish();
            }
        });
    }
}