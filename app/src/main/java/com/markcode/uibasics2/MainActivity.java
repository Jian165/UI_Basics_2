package com.markcode.uibasics2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtHello;
    private EditText editTextName;

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        String viewName = getResources().getResourceEntryName(viewId);

        switch (viewName) {
            case "btnHello":
                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
                txtHello.setText("Hello " + editTextName.getText().toString());
                break;
            case "edTxtName":
                Toast.makeText(this, "Attempting to type a message", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);
        btnHello.setOnClickListener(this);

        btnHello.setOnLongClickListener( new View.OnLongClickListener(){
           public boolean onLongClick(View v){
               Toast.makeText(MainActivity.this, "Stupid "+editTextName.getText().toString(), Toast.LENGTH_LONG).show();
                return false;
            }
        });

        editTextName=findViewById(R.id.edTxtName);
        editTextName.setOnClickListener(this);

        txtHello=findViewById(R.id.textHello);

    }
}