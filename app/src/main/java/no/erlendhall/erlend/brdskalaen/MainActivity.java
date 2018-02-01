package no.erlendhall.erlend.brdskalaen;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button btnTest;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private BottomNavigationView navigator;
    private FragmentTransaction transaction;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigator = findViewById(R.id.navigation);

        final SiktetFragment siktetFragment = SiktetFragment.newInstance();
        final SammaltFragment sammaltFragment = SammaltFragment.newInstance();
        final HelkornFragment helkornFragment = HelkornFragment.newInstance();

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

    private void loadHelkornFragment(HelkornFragment helkornFragment) {
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, helkornFragment);
        transaction.commit();
    }

}
