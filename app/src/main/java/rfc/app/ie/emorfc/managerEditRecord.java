package rfc.app.ie.emorfc;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class managerEditRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_edit_record);

        readRecords();


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

                textViewPlayerItem.setOnLongClickListener(new OnLongClickListenerPlayerRecord());

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

    public class OnLongClickListenerPlayerRecord implements View.OnLongClickListener {



        @Override
        public boolean onLongClick(View view) {

            final Context context;
            final String id;

            context = view.getContext();
            id = view.getTag().toString();

            final CharSequence[] items = {  "Delete" };

            new AlertDialog.Builder(context).setTitle("Player Record")
                    .setItems(items, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int item) {

                                if (item == 0) {

                                boolean deleteSuccessful = new tableControllerPlayer(context).delete(Integer.parseInt(id));

                                if (deleteSuccessful){
                                    Toast.makeText(context, "Student record was deleted.", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context, "Unable to delete student record.", Toast.LENGTH_SHORT).show();
                                }




                            }

                            dialog.dismiss();

                        }
                    }).show();
            return false;
        }

    }







}
