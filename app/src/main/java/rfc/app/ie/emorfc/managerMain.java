package rfc.app.ie.emorfc;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class managerMain extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_main);

        Button createPlayerButton = findViewById(R.id.createPlayerBtn);
        createPlayerButton.setOnClickListener(new OnClickListenerCreatePlayer());

        Button editPlayerBtn = findViewById(R.id.editPlayerBtn);
        editPlayerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onClickEditPlayerBtn();

            }
        });


    }



    public void onClickEditPlayerBtn(){

        Intent managerEditRecord = new Intent(managerMain.this, managerEditRecord.class);
        startActivity(managerEditRecord);
    }



    public class OnClickListenerCreatePlayer implements View.OnClickListener {
        @Override
        public void onClick(View view) {


            final Context context;
            context = view.getRootView().getContext();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View formElementsView = inflater.inflate(R.layout.player_input_form, null, false);

            final EditText editTextPlayerName = (EditText) formElementsView.findViewById(R.id.editTextPlayerName);
            final EditText editTextPlayerEmail = (EditText) formElementsView.findViewById(R.id.editTextPlayerEmail);

            new AlertDialog.Builder(context)
                    .setView(formElementsView)
                    .setTitle("Create Player")
                    .setPositiveButton("Add",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    String playerFirstname = editTextPlayerName.getText().toString();
                                    String studentEmail = editTextPlayerEmail.getText().toString();

                                    objectPlayer objectPlayer = new objectPlayer();
                                    objectPlayer.firstname= playerFirstname;
                                    objectPlayer.email= studentEmail;

                                    boolean createSuccessful = new tableControllerPlayer(context).create(objectPlayer);

                                    if(createSuccessful){
                                        Toast.makeText(context, "Player information was saved.", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(context, "Unable to save player information.", Toast.LENGTH_SHORT).show();
                                    }

                                    dialog.cancel();



                                }

                            }).show();


        }


    }








}