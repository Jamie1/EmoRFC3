package rfc.app.ie.emorfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class playerLogin extends AppCompatActivity {


        EditText passwordTxtBox;
        EditText managerNameTxtBox;
       // Button loginBtn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_manager_edit_record);

            readRecords();

            managerNameTxtBox = findViewById(R.id.playerNameTxt);
            passwordTxtBox = findViewById(R.id.playerPasswordTxt);



        }
    public void readRecords() {

        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();

        List<objectPlayer> players = new tableControllerPlayer(this).read();

        if (players.size() > 0) {

            for (objectPlayer obj : players) {

                int id = obj.id;
                String playerFirstname = obj.firstname;
                String playerEmail = obj.email;

                String textViewContents = playerFirstname + " - " + playerEmail;

                TextView textViewPlayerItem= new TextView(this);
                textViewPlayerItem.setPadding(0, 10, 0, 10);
                textViewPlayerItem.setText(textViewContents);
                textViewPlayerItem.setTag(Integer.toString(id));

                linearLayoutRecords.addView(textViewPlayerItem);
            }

        }

        else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("No records yet.");

            linearLayoutRecords.addView(locationItem);
        }

    }
}
