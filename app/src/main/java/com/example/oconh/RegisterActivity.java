package com.example.oconh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = (Button) findViewById(R.id.registerButton);

        register.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){
                Intent intent=new Intent(getApplicationContext(),ResultsActivity.class);
                startActivity(intent);
            }
        });
    }
}
