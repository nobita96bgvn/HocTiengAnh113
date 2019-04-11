package com.nvh.hoannguyen.hoctienganh.cauhoi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;



public class QuestionController {
    private DBHelper dbHelper;

    public QuestionController(Context context) {
        dbHelper= new DBHelper(context);
    }
    public ArrayList<cauhoi> getcauhoi(int sode, int lop){
        ArrayList<cauhoi> lsData= new ArrayList<cauhoi>();
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM tracnghiem WHERE sode= '"+sode+"' AND lop= '"+lop+"'",null);
        cursor.moveToFirst();
        do{
            cauhoi item;
            item = new cauhoi(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getInt(8),cursor.getInt(9),"");
            lsData.add(item);
        }
        while (cursor.moveToNext());
        return lsData;
    }
}
