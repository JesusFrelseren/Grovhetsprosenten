package no.erlendhall.erlend.brdskalaen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.Nullable;



public class HelkornFragmentJava extends Fragment {
    public static HelkornFragment newInstance() {
        return new HelkornFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_helkorn, container, false);
    }
}
