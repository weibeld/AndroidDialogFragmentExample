package org.weibeld.example.dialogfragmentexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by dw on 06/11/16.
 */

public class MyDialogFragment extends DialogFragment {

    private final String LOG_TAG = MyDialogFragment.class.getSimpleName();

    // Called after onCreate and before onCreateView.
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.v(LOG_TAG, "onCreateDialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
        return dialog;
    }

    private void showToast(String buttonName) {
        Toast.makeText(getActivity(), "Clicked on \"" + buttonName + "\"", Toast.LENGTH_SHORT).show();
    }
}
