package rfc.app.ie.emorfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
    public void onClickPlayerbtn(View view) {

        Intent playerScreen = new Intent(this, playerLogin.class);
        startActivity(playerScreen);



    }

    public void onClickManagerbtn(View view) {

        Intent managerScreen;
        managerScreen = new Intent(this, managerLogin.class);
        startActivity(managerScreen);

    }

    public void onClickSearchBtn(View view){

        Intent searchScreen;
        searchScreen = new Intent(this, searchActivity.class);
        startActivity(searchScreen);
    }



}
