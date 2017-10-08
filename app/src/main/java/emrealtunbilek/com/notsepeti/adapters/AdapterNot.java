package emrealtunbilek.com.notsepeti.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import emrealtunbilek.com.notsepeti.R;
import emrealtunbilek.com.notsepeti.data.Notlar;

/**
 * Created by Emre Altunbilek on 8.10.2017.
 */
//1 sınıfını Recyclerview.Adapterdan extend et
//2 ViewHolder sınıfından extends olan bir sınıf yarat
//3 Default constructor yarat
//4 methodları implemente et
//AdapterNot sınıfına default contructor olustur, contexte erişmek için

public class AdapterNot extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ITEM = 0;
    public static final int FOOTER=1;


    private LayoutInflater mInflater;
    private ArrayList<Notlar> tumNotlar = new ArrayList<>();

    public AdapterNot(Context context, ArrayList<Notlar> notlar) {
        mInflater = LayoutInflater.from(context);
        guncelle(notlar);
    }

    public void guncelle(ArrayList<Notlar> notlar){
        tumNotlar=notlar;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        if(tumNotlar.size()==0){
            return ITEM;
        }else if(position < tumNotlar.size()) {
            return ITEM;
        }else {
            return FOOTER;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == FOOTER){
            View view = mInflater.inflate(R.layout.footer, parent, false);
            return new FooterHolder(view);
        }
        else{

            View view = mInflater.inflate(R.layout.tek_satir_not, parent, false);
            return new NotHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof NotHolder){
            NotHolder notHolder= (NotHolder) holder;
            notHolder.mTextNotIcerik.setText(tumNotlar.get(position).getNotIcerik());
            notHolder.mTextNotZaman.setText(""+tumNotlar.get(position).getNotID());
        }



    }

    @Override
    public int getItemCount() {
        return tumNotlar.size()+1;
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

    public static class FooterHolder extends RecyclerView.ViewHolder {

        Button mButtonAdd;

        public FooterHolder(View itemView) {
            super(itemView);
           mButtonAdd= (Button) itemView.findViewById(R.id.btn_footer);
        }
    }

}
