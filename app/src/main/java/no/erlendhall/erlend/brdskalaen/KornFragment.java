package no.erlendhall.erlend.brdskalaen;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;


public class KornFragment extends Fragment {
    OnFragmentChange callback;
    ArrayList<EditText> measurements;

    public static KornFragment newInstance() {
        return new KornFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_helkorn, container, false);

        measurements = new ArrayList<>();
        measurements.add((EditText)view.findViewById(R.id.txt_havregryn));
        measurements.add((EditText)view.findViewById(R.id.txt_hele_korn));
        measurements.add((EditText)view.findViewById(R.id.txt_hvetekli));
        measurements.add((EditText)view.findViewById(R.id.txt_rugkli));
        measurements.add((EditText)view.findViewById(R.id.txt_havrekli));

        for (EditText edit : measurements) {

            edit.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    callback.onHelkornGrainChange(measurements);
                }
            });
        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity a;

        if(context instanceof Activity) {
            a = (Activity)context;
            callback = (OnFragmentChange)a;
        }
    }

    public interface OnFragmentChange {
        void onHelkornGrainChange(ArrayList<EditText> siktet);
    }

}
