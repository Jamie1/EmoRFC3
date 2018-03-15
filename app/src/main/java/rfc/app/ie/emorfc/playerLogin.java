package rfc.app.ie.emorfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class playerLogin extends AppCompatActivity {


        EditText passwordTxtBox;
        EditText managerNameTxtBox;
        Button loginBtn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_player_login);



            managerNameTxtBox = findViewById(R.id.playerNameTxt);
            passwordTxtBox = findViewById(R.id.playerPasswordTxt);
           // loginBtn = findViewById(R.id.playerLogiBtn);

           // loginBtn.setOnClickListener(new View.OnClickListener() {
              //  @Override
               // public void onClick(View view) {

                 //   onClickLoginBtn();

              //  }
            //});


        }
        public void onClickLoginBtn() {

            String userName = managerNameTxtBox.getText().toString();
            String pass = passwordTxtBox.getText().toString();
            if(userName.equals("Jim") && (pass.equals("1234")) ){
                Toast.makeText(playerLogin.this, "Login Successful", Toast.LENGTH_LONG).show();

                //Intent logged = new Intent(this, managerMain.class);
                //startActivity(logged);

                Intent managerMain = new Intent(playerLogin.this, managerMain.class);
                startActivity(managerMain);

            }
            else {

                Toast.makeText(playerLogin.this, "Incorrect Login Details Try again", Toast.LENGTH_LONG).show();
            }



            //Intent managerMain = new Intent(managerLogin.this, managerLogin.class);
            //startActivity(managerMain);

        }
}
