package emrealtunbilek.com.notsepeti;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import emrealtunbilek.com.notsepeti.data.DatabaseHelper;
import emrealtunbilek.com.notsepeti.data.NotSepetiContract;
import emrealtunbilek.com.notsepeti.data.Notlar;


public class DialogEkle extends DialogFragment {

    private ImageButton mBtnKapat;
    private EditText mInputWhat;
    private DatePicker mInputWhen;
    private Button mBtnEkle;


    public DialogEkle(){

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.dialog_add, container , false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInputWhat= (EditText) view.findViewById(R.id.et_not);
        mInputWhen= (DatePicker) view.findViewById(R.id.dp_tarih);
        mBtnKapat= (ImageButton) view.findViewById(R.id.btn_kapat);
        mBtnEkle= (Button) view.findViewById(R.id.btn_not_ekle_dialog);

        mBtnKapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        mBtnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notlar yeni=new Notlar();
                yeni.setNotIcerik(mInputWhat.getText().toString());
                yeni.setNotTarih("10/10/2017");
                yeni.setYapildi(1);
                DatabaseHelper.getInstance(getActivity()).yeniNotEkle(yeni);
             /*   String c=DatabaseHelper.getInstance(getActivity()).tumNotlarYazdir();
                Toast.makeText(getContext()," " +c, Toast.LENGTH_LONG).show();*/
                ((ActivityMain) getActivity()).guncelleData();
            }
        });


    }
}
