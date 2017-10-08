package emrealtunbilek.com.notsepeti;

import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import emrealtunbilek.com.notsepeti.adapters.AdapterNot;
import emrealtunbilek.com.notsepeti.data.DatabaseHelper;
import emrealtunbilek.com.notsepeti.data.Notlar;

public class ActivityMain extends AppCompatActivity {

    Toolbar mToolbar;
    Button mBtnEkle;

    NotlarRecyclerView mRecyclerView;
    AdapterNot adapterNot;
    ArrayList<Notlar> tumNotlar;

    View mBosListe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mBtnEkle = (Button) findViewById(R.id.btn_not_ekle);
        mRecyclerView= (NotlarRecyclerView) findViewById(R.id.rv_notlar);

    //DatabaseHelper.getInstance(this).tumNotlariSil();

        LinearLayoutManager manager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        /*<!--app:layoutManager="android.support.v7.widget.LinearLayoutManager"-->*/

        mBosListe=findViewById(R.id.bosListe);
        mRecyclerView.bossaToolbariSakla(mToolbar);
        mRecyclerView.gosterEgerBossa(mBosListe);

        guncelleData();

        mBtnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showDialogEkle();
            }
        });
        setSupportActionBar(mToolbar);
        backgroundImageAyarla();
    }

    private void showDialogEkle() {
        DialogEkle dialog=new DialogEkle();
        dialog.show(getSupportFragmentManager(),"DialogEkle");
    }

    public void guncelleData(){
        tumNotlar=DatabaseHelper.getInstance(this).tumNotlar();
        adapterNot=new AdapterNot(this, tumNotlar);
        mRecyclerView.setAdapter(adapterNot);

    }

    private void backgroundImageAyarla() {
        ImageView background = (ImageView) findViewById(R.id.iv_background);


        Glide.with(this)
                .load(R.drawable.bg)
                .apply(new RequestOptions().centerCrop())
                .into(background);


    }


}
