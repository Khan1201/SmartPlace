package com.example.gradportfolio.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlLiteHelper extends SQLiteOpenHelper {
    public SqlLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE if not exists ShoppingBasket("
                + "_id integer primary key autoincrement"
                + ",url blob"
                + ",brand_name text"
                + ",product_name text"
                + ",purchase"
                + ",price text);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE if exists ShoppingBasket";

        db.execSQL(sql);
        onCreate(db);
    }
}