package org.weibeld.example.dialogfragmentexample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display the DialogFragment as a Fragment
                MyDialogFragment dialogFrag = new MyDialogFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction trans = fm.beginTransaction();
                trans.add(android.R.id.content, dialogFrag).addToBackStack(null).commit();
            }
        });
    }
}
