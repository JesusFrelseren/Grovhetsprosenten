package no.erlendhall.erlend.brdskalaen;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;


public class SammaltFragment extends Fragment {
    OnFragmentChange callback;
    private ArrayList<EditText> sammaltEdits;
    private ArrayList<Integer> measurements;
    public static SammaltFragment newInstance() {
        return new SammaltFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_sammalt, container, false);
        sammaltEdits = new ArrayList<>();

        sammaltEdits.add((EditText)view.findViewById(R.id.txt_sammalt_hvete));
        sammaltEdits.add((EditText)view.findViewById(R.id.txt_sammalt_rug));
        sammaltEdits.add((EditText)view.findViewById(R.id.txt_sammalt_spelt));
        sammaltEdits.add((EditText)view.findViewById(R.id.txt_byggmel));
        sammaltEdits.add((EditText)view.findViewById(R.id.txt_havremel));

        for (EditText edit : sammaltEdits) {
            edit.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    callback.onSammaltGrainChange(sammaltEdits);
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
        void onSammaltGrainChange(ArrayList<EditText> sammalt);
    }



}
