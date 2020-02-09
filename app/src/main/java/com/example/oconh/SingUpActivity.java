package com.example.oconh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SingUpActivity extends Activity {

    private EditText user_name;
    private EditText user_password;
    private EditText user_education;
    private EditText user_phone;
    private EditText user_mail;
    private Button register;
    private ImageView imageView;

//    private DBAdapter mDBAdapter;

    private UserService userService = new UserService();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        user_name = findViewById(R.id.name);
        user_password = findViewById(R.id.password);
        user_education = findViewById(R.id.formationSignUp);
        user_phone = findViewById(R.id.phoneSignUp);
        user_mail = findViewById(R.id.correoSignUp);


        register = findViewById(R.id.registerButton);

        register.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){
                String name = user_name.getText().toString();
                String password = user_password.getText().toString();
                int age =  21;
                String education = user_education.getText().toString();
                int phone = 2525;
                String mail = user_mail.getText().toString();

                try{
                    User user = new User(name,password,age, education, phone, mail);
                    userService.register(name,password,age, education, phone, mail);
                    Intent intent = new Intent(getApplicationContext(), EventsActivity.class);
                    startActivity(intent);
                }catch(Exception e){
                    String message = e.getMessage();
                }
            }
        });

    }

}
