package rfc.app.ie.emorfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class searchActivity extends AppCompatActivity {
    private static final String TAG = "searchActivity";

    public ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ListView list = (ListView) findViewById(R.id.searchLIst);
        EditText theFilter = (EditText) findViewById(R.id.searchEditText);
        Log.d(TAG, "onCreate: Started.");

        ArrayList<String> matches = new ArrayList<>();
        matches.add("Arles RFC, 02.30, 17/04/2018");
        matches.add("Portarlington RFC, 02.00, 21/04/2018");
        matches.add("Portlaoise RFC, 01.30, 25/04/2018");

        adapter = new ArrayAdapter(this, R.layout.list_item_layout, matches);
        list.setAdapter(adapter);

        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (searchActivity.this).adapter.getFilter().filter(charSequence);            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void onClickMapBtn(View view){

        Intent mapScreen;
        mapScreen = new Intent(this, mapsActivity.class);
        startActivity(mapScreen);
    }
}
