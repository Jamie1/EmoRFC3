package rfc.app.ie.emorfc;

import android.content.Intent;
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
                if(userName.equals("Admin") && (pass.equals("1234")) ){
                    Toast.makeText(managerLogin.this, "Login Successful", Toast.LENGTH_LONG).show();



                    Intent managerMain = new Intent(managerLogin.this, managerMain.class);
                    startActivity(managerMain);

                }
                else {

                    Toast.makeText(managerLogin.this, "Incorrect Login Details Try again", Toast.LENGTH_LONG).show();
                }

            }
        });


    }


    }

