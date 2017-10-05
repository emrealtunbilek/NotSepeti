package emrealtunbilek.com.notsepeti;

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


public class DialogEkle extends DialogFragment {

    private ImageButton mBtnKapat;
    private EditText mInputWhat;
    private DatePicker mInputWhen;
    private Button mBtnEkle;

    public DialogEkle() {
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
                
            }
        });


    }
}
