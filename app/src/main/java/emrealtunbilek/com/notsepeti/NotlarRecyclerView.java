package emrealtunbilek.com.notsepeti;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Emre Altunbilek on 9.10.2017.
 */

public class NotlarRecyclerView extends RecyclerView {

    private List<View> mBosOlmayanViewler= Collections.emptyList();
    private List<View> mBosViewler=Collections.emptyList();


    private AdapterDataObserver mObserver=new AdapterDataObserver() {
        @Override
        public void onChanged() {
            toggleViews();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            toggleViews();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            toggleViews();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            toggleViews();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            toggleViews();
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            toggleViews();
        }
    };


    public NotlarRecyclerView(Context context) {
        super(context);
    }

    public NotlarRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NotlarRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        if(adapter !=null){

            adapter.registerAdapterDataObserver(mObserver);

        }
        mObserver.onChanged();
    }

    public void bossaToolbariSakla(View... views) {

        mBosOlmayanViewler= Arrays.asList(views);

    }

    public void gosterEgerBossa(View... mBosListe) {
        mBosViewler=Arrays.asList(mBosListe);
    }

    private void toggleViews(){
        if(getAdapter() != null && !mBosOlmayanViewler.isEmpty() && !mBosViewler.isEmpty()){
            if(getAdapter().getItemCount()==0){


                //bos olan tüm viewları göster
                for(View view : mBosViewler){
                    view.setVisibility(View.VISIBLE);
                }

                //recyclerviewı saklar
                setVisibility(View.GONE);

                //saklanması gereken herseyi saklar
                for(View view:mBosOlmayanViewler){
                    view.setVisibility(View.GONE);
                }

            }else {

                //bos olan tüm viewları sakla
                for(View view : mBosViewler){
                    view.setVisibility(View.GONE);
                }

                //recyclerviewı saklar
                setVisibility(View.VISIBLE);

                //saklanması gereken herseyi saklar
                for(View view:mBosOlmayanViewler){
                    view.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
