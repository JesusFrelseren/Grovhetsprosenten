package no.erlendhall.erlend.brdskalaen;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView navigator;
    private FragmentTransaction transaction;
    private ArrayList<EditText> edits;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_siktet);
        navigator = findViewById(R.id.navigation);
        edits = new ArrayList<>();

        final SiktetFragment siktetFragment = SiktetFragment.newInstance();
        final SammaltFragment sammaltFragment = SammaltFragment.newInstance();
        final HelkornFragment helkornFragment = HelkornFragment.newInstance();
        loadSiktetFragment(siktetFragment);
        edits.add((EditText) findViewById(R.id.text_hvetemel));
        edits.add((EditText) findViewById(R.id.text_rugmel));

        for (EditText edit : edits) {
            edit.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    updateTotal();
                }
            });
        }


        navigator.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.navigation_siktet:
                        loadSiktetFragment(siktetFragment);
                        return true;
                    case R.id.navigation_sammalt:
                        loadSammaltFragment(sammaltFragment);
                        return true;
                    case R.id.navigation_helkorn:
                        loadHelkornFragment(helkornFragment);
                        return true;
                }
                return false;
            }
        });




    }

    private boolean updateTotal() {
        for (EditText edit : edits) {
            String test = String.valueOf(edit.getText());
        }

        return true;
    }

    private void loadSiktetFragment(SiktetFragment siktetFragment) {
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, siktetFragment);
        transaction.commit();
    }

    private void loadSammaltFragment(SammaltFragment sammaltFragment) {
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, sammaltFragment);
        transaction.commit();
    }

    private void loadHelkornFragment(HelkornFragment helkornFragment) {
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, helkornFragment);
        transaction.commit();
    }

}
