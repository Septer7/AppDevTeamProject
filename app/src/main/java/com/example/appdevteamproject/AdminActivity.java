package com.example.appdevteamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminActivity extends AppCompatActivity {

    EditText name, price, category;
    Button add, delete, update, viewOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        name = findViewById(R.id.editTextTextPersonName);
        price = findViewById(R.id.editTextTextPersonName2);
        category = findViewById(R.id.editTextTextPersonName3);
        add = findViewById(R.id.button);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(AdminActivity.this);
                db.addData(name.getText().toString().trim(), Integer.valueOf(price.getText().toString().trim()), category.getText().toString().trim());
            }
        });


    }






    // View orders and CRUD operations(Create, Add items, delete items, update items)



}