package com.example.examples_gradle_commoncases.Paid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.examples_gradle_commonusecases.R;
import com.example.jokesmith.*;
import com.example.jokewizard.JokeWizard;

public class JokeActivity extends AppCompatActivity {
    JokeSmith myJoke;
    JokeWizard myJoke1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        myJoke=new JokeSmith();
        TextView jokeText= findViewById(R.id.joke);
        jokeText.setText(myJoke.getJoke());

        myJoke1=new JokeWizard();
        TextView jokeText1= findViewById(R.id.joke1);
        jokeText1.setText(myJoke1.getJoke());
    }
}