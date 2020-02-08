package com.example.annahockeyleague.Fragments.FixturesFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.R;

public class FixturesFragment extends Fragment {

    private FragmentConfig config;

    public FixturesFragment()
    {

    }

    public FixturesFragment(FragmentConfig config)
    {
        this.config = config;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fixtures_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}
