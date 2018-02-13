package no.erlendhall.erlend.brdskalaen;

import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;


public class GrovhetKalkulator extends AppCompatActivity {
    private byte grovhetsProsent;
    private Object child;
    private ArrayList<EditText> editTexts;

    protected GrovhetKalkulator() {
        editTexts = new ArrayList<>();

        editTexts.add((EditText) findViewById(R.id.text_hvetemel));
        int i = 0;
    }

    protected float hentTeller(ViewGroup v) {
        float teller = 0;

        for (int i = 0; i < v.getChildCount(); i++) {
            child = v.getChildAt(i);
            if (child instanceof EditText) {
                teller += Float.parseFloat(((EditText) child).getText().toString());
            }
        }
        return teller;
    }





}
