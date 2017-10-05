package emrealtunbilek.com.notsepeti.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import emrealtunbilek.com.notsepeti.data.NotSepetiContract.*;

/**
 * Created by Emre Altunbilek on 5.10.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="notlar.db";
    private static final int DATABASE_VERSION=2;
    private static final String SORGU_NOT_TABLOSU="CREATE TABLE IF NOT EXISTS " + NotlarEntry.TABLE_NAME +
            " (_ID INTEGER PRIMARY KEY, notlar TEXT, tarih TEXT, tamamlandi INTEGER )";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SORGU_NOT_TABLOSU);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NotlarEntry.TABLE_NAME);
        onCreate(db);
    }
}
