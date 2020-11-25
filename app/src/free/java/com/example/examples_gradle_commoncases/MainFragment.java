package com.example.examples_gradle_commoncases;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.examples_gradle_commonusecases.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//Free
public class MainFragment extends Fragment implements View.OnClickListener{
    View rootview;
    AdView mAdView;
   // private MainViewModel mViewModel;
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        rootview= inflater.inflate(R.layout.main_fragment, container, false);
        TextView buildFlavour =  rootview.findViewById(R.id.buildFlavour);
        buildFlavour.setText(R.string.buildFlavor);

        MobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });


        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button button= rootview.findViewById(R.id.message);
        button.setOnClickListener(this);

        mAdView = (AdView) rootview.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("ca-app-pub-3940256099942544/6300978111").build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdView.destroy();
    }


    public void tellJoke() {

        Context context = getContext();
        CharSequence text = this.getString(R.string.toast_text);
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.message) {
            tellJoke();
        }
    }
}