package org.weibeld.example.dialogfragmentexample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAndShowDialog();
            }
        });
    }

    private void createAndShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Add components to the dialog (the order in which components are added does not matter)
        builder.setTitle(R.string.dialog_title).
                setMessage(R.string.dialog_message).
                setView(R.layout.dialog_partial_content).  // For < API 21 use setView(View)
                setPositiveButton(R.string.pos_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showToast(getString(R.string.pos_button));
                    }
                }).
                setNegativeButton(R.string.neg_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showToast(getString(R.string.neg_button));
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showToast(String buttonName) {
        Toast.makeText(this, "Clicked on \"" + buttonName + "\"", Toast.LENGTH_SHORT).show();
    }
}
