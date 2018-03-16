package rfc.app.ie.emorfc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 14/03/2018.
 */

public class tableControllerPlayer extends DatabaseHandler {

    public boolean create(objectPlayer objectStudent) {

        ContentValues values = new ContentValues();

        values.put("firstname", objectStudent.firstname);
        values.put("email", objectStudent.email);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("players", null, values) > 0;
        db.close();

        return createSuccessful;
    }

    public List<objectPlayer> read() {

        List<objectPlayer> recordsList = new ArrayList<objectPlayer>();

        String sql = "SELECT * FROM players ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String studentFirstname = cursor.getString(cursor.getColumnIndex("firstname"));
                String studentEmail = cursor.getString(cursor.getColumnIndex("email"));

                objectPlayer objectStudent = new objectPlayer();
                objectStudent.id = id;
                objectStudent.firstname = studentFirstname;
                objectStudent.email = studentEmail;

                recordsList.add(objectStudent);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }

    public tableControllerPlayer(Context context) {
        super(context);
    }


    public boolean delete(int id) {
        boolean deleteSuccessful = false;

        SQLiteDatabase db = this.getWritableDatabase();
        deleteSuccessful = db.delete("players", "id ='" + id + "'", null) > 0;
        db.close();

        return deleteSuccessful;

    }



}