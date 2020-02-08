package com.example.oconh;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private UserService user_service = new UserService();
    private EditText user_name;
    private EditText user_password;
    private Button singIn;
    private Button singup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        singIn = (Button) findViewById(R.id.singin);
        user_name = (EditText) findViewById(R.id.name);
        user_password = (EditText) findViewById(R.id.password);

        singIn.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){
                user_service.singIn(user_name.getText().toString(), user_password.getText().toString());
            }
        });


    }
}
