package emrealtunbilek.com.notsepeti.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

import emrealtunbilek.com.notsepeti.data.NotSepetiContract.*;

/**
 * Created by Emre Altunbilek on 5.10.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;
    private static SQLiteDatabase db;

    private static final String DATABASE_NAME = "notlar.db";
    private static final int DATABASE_VERSION = 3;
    private static final String SORGU_NOT_TABLOSU = "CREATE TABLE IF NOT EXISTS " + NotlarEntry.TABLE_NAME +
            " (_ID INTEGER PRIMARY KEY AUTOINCREMENT, notlar TEXT, tarih TEXT, tamamlandi INTEGER )";

    public static synchronized DatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
            db = sInstance.getWritableDatabase();
        }
        return sInstance;
    }


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

    public void yeniNotEkle(Notlar yeni) {
        ContentValues yeniNot = new ContentValues();
        yeniNot.put("tarih", yeni.getNotTarih());
        yeniNot.put("notlar", yeni.getNotIcerik());
        yeniNot.put("tamamlandi", yeni.getYapildi());

        db.insert(NotSepetiContract.NotlarEntry.TABLE_NAME, null, yeniNot);
    }

    public String tumNotlarYazdir() {

        Cursor c = db.query(NotlarEntry.TABLE_NAME, null, null, null, null, null, null);
        String tumNotlar = "";

        while (c.moveToNext()) {


            tumNotlar += c.getString(0) + " " + c.getString(1) + "\n";

        }

        return tumNotlar;

    }

    public ArrayList<Notlar> tumNotlar() {

        ArrayList<Notlar> notlar = new ArrayList<>();

        Cursor c = db.query(NotlarEntry.TABLE_NAME, null, null, null, null, null, null);


        while (c.moveToNext()) {

            Notlar geciciNot = new Notlar();
            geciciNot.setNotID(c.getInt(0));
            geciciNot.setNotIcerik(c.getString(1));
            geciciNot.setNotTarih(c.getString(2));
            geciciNot.setYapildi(c.getInt(3));

            notlar.add(geciciNot);

        }

        return notlar;
    }
}
