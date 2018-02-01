package no.erlendhall.erlend.brdskalaen;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.Nullable;


public class SammaltFragment extends Fragment {
    public static SammaltFragment newInstance() {
        return new SammaltFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstance) {
        return inflater.inflate(R.layout.fragment_sammalt, container, false);
    }

}
