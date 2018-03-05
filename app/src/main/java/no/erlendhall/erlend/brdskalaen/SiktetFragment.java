package no.erlendhall.erlend.brdskalaen;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;


public class SiktetFragment extends Fragment {
    OnFragmentChange callback;
    ArrayList<EditText> measurements;
    public static SiktetFragment newInstance() {

        return new SiktetFragment();
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_siktet, container, false);
        measurements = new ArrayList<>();
        measurements.add((EditText)view.findViewById(R.id.text_hvetemel));
        measurements.add((EditText)view.findViewById(R.id.text_rugmel));
        measurements.add((EditText)view.findViewById(R.id.text_speltmel));


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
                    callback.onSiktetGrainChange(measurements);
                }
            });
        }

        return view;
    }

    public interface OnFragmentChange {
        void onSiktetGrainChange(ArrayList<EditText> siktet);
    }




    }

