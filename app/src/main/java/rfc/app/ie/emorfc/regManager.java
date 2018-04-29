package rfc.app.ie.emorfc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class regManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_manager);

        final EditText userName = (EditText) findViewById(R.id.createMngrNameTxt);
        final EditText userPassword = (EditText) findViewById(R.id.createMngrNameTxt);

        Button submitBtn = (Button) findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newPassword = userPassword.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(newUser + newPassword + "data", newUser);
                editor.commit();

                Intent managerMain = new Intent(regManager.this, managerMain.class);
                startActivity(managerMain);
            }
        });
    }
}
