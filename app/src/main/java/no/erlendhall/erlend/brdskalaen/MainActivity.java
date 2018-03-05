package no.erlendhall.erlend.brdskalaen;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
    implements SammaltFragment.OnFragmentChange,
        SiktetFragment.OnFragmentChange,
        KornFragment.OnFragmentChange {

    private BottomNavigationView navigator;
    private FragmentTransaction transaction;
    private Integer sammalt, siktet, helkorn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigator = findViewById(R.id.navigation);

        final SiktetFragment siktetFragment = SiktetFragment.newInstance();
        final SammaltFragment sammaltFragment = SammaltFragment.newInstance();
        final KornFragment helkornFragment = KornFragment.newInstance();

        loadSiktetFragment(siktetFragment);


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

    private void loadHelkornFragment(KornFragment helkornFragment) {
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, helkornFragment);
        transaction.commit();
    }

    @Override
    public void onSammaltGrainChange(ArrayList<EditText> sammalt) {
        this.sammalt = 0;

        for (EditText val : sammalt) {
            String aux = String.valueOf(val.getText());
            if (!aux.equals("")) {
                this.sammalt += Integer.valueOf(aux);
            }

        }

        Toast.makeText(getBaseContext(), String.valueOf(this.sammalt), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSiktetGrainChange(ArrayList<EditText> siktet) {
        this.siktet = 0;

        for (EditText val : siktet) {
            String aux = String.valueOf(val.getText());
            if (!aux.equals("")) {
                this.siktet += Integer.valueOf(aux);
            }

        }
    }

    @Override
    public void onHelkornGrainChange(ArrayList<EditText> helkorn) {
        this.helkorn = 0;

        for (EditText val : helkorn) {
            String aux = String.valueOf(val.getText());
            if(!aux.equals("")) {
                this.helkorn += Integer.valueOf(aux);
            }
        }
    }


}
