package emrealtunbilek.com.notsepeti;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by Emre Altunbilek on 9.10.2017.
 */

public class NotlarRecyclerView extends RecyclerView {

    private AdapterDataObserver mObserver=new AdapterDataObserver() {
        @Override
        public void onChanged() {

        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {

        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {

        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {

        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {

        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {

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
}
