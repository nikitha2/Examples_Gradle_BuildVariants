package com.example.examples_gradle_commoncases;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.examples_gradle_commoncases.Paid.JokeActivity;
import com.example.examples_gradle_commonusecases.R;
import android.widget.TextView;

//Paid
public class MainFragment extends Fragment implements View.OnClickListener{
    View rootview;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        rootview= inflater.inflate(R.layout.main_fragment, container, false);

        TextView buildFlavour =  rootview.findViewById(R.id.buildFlavour);
        buildFlavour.setText(R.string.buildFlavorPaid);

        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button button= rootview.findViewById(R.id.message);
        button.setOnClickListener(this);
    }

    public void openJokePage(){
        Intent intent=new Intent(getContext(), JokeActivity.class);
        startActivity(intent);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message:
                openJokePage();
                break;
            default:
        }
    }
}