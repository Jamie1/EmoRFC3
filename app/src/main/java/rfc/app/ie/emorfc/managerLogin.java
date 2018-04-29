package rfc.app.ie.emorfc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class managerLogin extends AppCompatActivity {

    EditText passwordTxtBox;
    EditText managerNameTxtBox;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_login);



        managerNameTxtBox = findViewById(R.id.managerNameTxt);
        passwordTxtBox = findViewById(R.id.managerPasswordTxt);
        loginBtn = findViewById(R.id.managerLogBtn);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = managerNameTxtBox.getText().toString();
                String pass = passwordTxtBox.getText().toString();

                SharedPreferences preferances = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                String userDetails = preferances.getString(userName + pass +"data", "Incorrect Details.");
                SharedPreferences.Editor editor = preferances.edit();
                editor.putString("display",userDetails);
                editor.commit();

                Intent editScreen = new Intent(managerLogin.this, managerMain.class);
                startActivity(editScreen);
            }
        });






    }

    public void onClickRegisterBtn(View view){

        Intent registerScreen;
        registerScreen = new Intent(this, regManager.class);
        startActivity(registerScreen);
    }


    }

