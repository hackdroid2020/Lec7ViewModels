package edu.tomerbu.lec7viewmodels.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.tomerbu.lec7viewmodels.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private TextView tvWord;

    //instead of constructor: use a factory method:
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel

        tvWord = getView().findViewById(R.id.message);


        //Listen to Live data changes:
        mViewModel.getWord().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvWord.setText(s);
            }
        });
    }
}
