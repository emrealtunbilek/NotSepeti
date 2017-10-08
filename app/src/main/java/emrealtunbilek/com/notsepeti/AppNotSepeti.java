package emrealtunbilek.com.notsepeti;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import emrealtunbilek.com.notsepeti.data.DatabaseHelper;

/**
 * Created by Emre Altunbilek on 8.10.2017.
 */

public class AppNotSepeti extends Application {

    SQLiteDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = DatabaseHelper.getInstance(this).getWritableDatabase();
    }


}
