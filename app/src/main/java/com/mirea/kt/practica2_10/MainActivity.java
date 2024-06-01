package com.mirea.kt.practica2_10;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextModel, editTextSerialNumber, editTextPrice;
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextModel = findViewById(R.id.model);
        editTextSerialNumber = findViewById(R.id.serialNumber);
        editTextPrice = findViewById(R.id.price);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnNext = findViewById(R.id.btnNext);
        btnAdd.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));
        Log.d("MainActivity","Created");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd){
            if (this.dbManager != null){
                String model = editTextModel.getText().toString();
                String serialNumber = editTextSerialNumber.getText().toString();
                String price = editTextPrice.getText().toString();
                if (!model.isEmpty() && !serialNumber.isEmpty() && !price.isEmpty()){
                    boolean result = dbManager.saveTelephoneToDatabase(new Telephone(model, serialNumber, Integer.parseInt(price)));
                    if (result){
                        Toast.makeText(this, R.string.insert_success,Toast.LENGTH_LONG).show();
                        Log.d("MainActivity","Telephone added");
                    }else{
                        Toast.makeText(this, R.string.insert_error,Toast.LENGTH_LONG).show();
                        Log.d("MainActivity","Insert error");
                    }
                }else {
                    Toast.makeText(this, R.string.incorrect_value,Toast.LENGTH_LONG).show();
                    Log.d("MainActivity","Incorrect value");
                }
            }
        }else if (v.getId()==R.id.btnNext){
            startActivity(new Intent(this, TelephoneActivity.class));
        }
    }
}