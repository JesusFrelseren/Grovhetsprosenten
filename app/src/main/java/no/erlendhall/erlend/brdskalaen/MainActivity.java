package no.erlendhall.erlend.brdskalaen;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button btnTest;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private BottomNavigationView navigator;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_siktet:
                    mTextMessage.setText(R.string.title_home);
                    fragment = new SiktetFragment();
		    replaceFragment();
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
	    }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	fragmentManager = getSupportFragmentManager();


        navigator = (BottomNavigationView) findViewById(R.id.navigation);
	navigator.inflateMenu(R.menu.bottom_menu);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        btnTest = (Button)findViewById(R.id.button);
        btnTest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                btnTest.setText("Test");
            }
        });
    }

    private boolean replaceFragment() {
    	final FragmentTransaction transaction = fragmentManager.beginTransaction();
	transaction.replace(R.id.main_container, fragment).commit();
	return true;
    
    }

}
