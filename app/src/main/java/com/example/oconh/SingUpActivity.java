package com.example.oconh;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SingUpActivity extends Activity {

    private EditText user_name;
    private EditText user_password;
    private EditText user_age;
    private EditText user_education;
    private EditText user_phone;
    private EditText user_mail;
    private Button register;
    private ImageView imageView;

    private UserService userService = new UserService();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.singUp);

    }

    private View.OnClickListener singUpListener = new View.OnClickListener() {
        public void onClick(View v) {
            String name = user_name.getText().toString();
            String password = user_password.getText().toString();
            String age = user_age.getText().toString();
            String education = user_education.getText().toString();
            String phone = user_phone.getText().toString();
            String mail = user_mail.getText().toString();

            try{
                userService.register(name,password,age, education, phone, mail);
            }catch(Exception e){
                //e.getMessage();
            }
        }
    };
}
