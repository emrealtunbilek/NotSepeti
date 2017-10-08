package emrealtunbilek.com.notsepeti.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import emrealtunbilek.com.notsepeti.R;

/**
 * Created by Emre Altunbilek on 8.10.2017.
 */
//1 sınıfını Recyclerview.Adapterdan extend et
//2 ViewHolder sınıfından extends olan bir sınıf yarat
//3 Default constructor yarat
//4 methodları implemente et
//AdapterNot sınıfına default contructor olustur, contexte erişmek için

public class AdapterNot extends RecyclerView.Adapter<AdapterNot.NotHolder> {

    private LayoutInflater mInflater;
    private ArrayList<String> dummyArray = new ArrayList<>();

    public AdapterNot(Context context) {
        mInflater = LayoutInflater.from(context);
        dummyArray = degerUret();
    }

    public static ArrayList<String> degerUret() {
        ArrayList<String> dummyValues = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            dummyValues.add("Item : " + i);
        }

        return dummyValues;
    }

    @Override
    public NotHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.tek_satir_not, parent, false);
        NotHolder holder = new NotHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(NotHolder holder, int position) {
        holder.mTextNotIcerik.setText(dummyArray.get(position));
        holder.mTextNotZaman.setText(""+(position+1));


    }

    @Override
    public int getItemCount() {
        return dummyArray.size();
    }

    public static class NotHolder extends RecyclerView.ViewHolder {

        TextView mTextNotIcerik;
        TextView mTextNotZaman;

        public NotHolder(View itemView) {
            super(itemView);
            mTextNotIcerik = (TextView) itemView.findViewById(R.id.tv_NotIcerik);
            mTextNotZaman = (TextView) itemView.findViewById(R.id.tv_NotZaman);
        }
    }

}
