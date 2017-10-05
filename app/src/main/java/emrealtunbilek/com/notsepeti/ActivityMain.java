package emrealtunbilek.com.notsepeti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ActivityMain extends AppCompatActivity {

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        backgroundImageAyarla();
    }

    private void backgroundImageAyarla(){
        ImageView background= (ImageView) findViewById(R.id.iv_background);


        Glide.with(this)
                .load(R.drawable.bg)
                .apply(new RequestOptions().centerCrop())
                .into(background);


    }
}
