package org.weibeld.example.dialogfragmentexample;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by dw on 06/11/16.
 */

public class MyDialogFragment extends DialogFragment {

    private final String LOG_TAG = MyDialogFragment.class.getSimpleName();

    // onCreate --> (onCreateDialog) --> onCreateView --> onActivityCreated
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v(LOG_TAG, "onCreateView");
        View dialogView = inflater.inflate(R.layout.dialog_content, container, false);

        Button buttonPos = (Button) dialogView.findViewById(R.id.pos_button);
        buttonPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(getString(R.string.pos_button));
                // Dismiss the dialog (remove it from view)
                dismiss();
            }
        });

        Button buttonNeg = (Button) dialogView.findViewById(R.id.neg_button);
        buttonNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(getString(R.string.neg_button));
                // Cancel the dialog (cancel --> dismiss). This is the same as when the user clicks
                // anywhere outside the dialog window, or clicks the Back button.
                getDialog().cancel();
            }
        });

        return dialogView;
    }

    // If dialog is cancelled: onCancel --> onDismiss
    @Override
    public void onCancel(DialogInterface dialog) {
        Log.v(LOG_TAG, "onCancel");
    }

    // If dialog is cancelled: onCancel --> onDismiss
    // If dialog is dismissed: onDismiss
    @Override
    public void onDismiss(DialogInterface dialog) {
        Log.v(LOG_TAG,"onDismiss");
    }



    // Called after onCreate and before onCreateView.
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        Log.v(LOG_TAG, "onCreateDialog");
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        // Add components to the dialog (the order in which components are added does not matter)
//        builder.setTitle(R.string.dialog_title).
//                setMessage(R.string.dialog_message).
//                setView(R.layout.dialog_content).  // For < API 21 use setView(View)
//                setPositiveButton(R.string.pos_button, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        showToast(getString(R.string.pos_button));
//                    }
//                }).
//                setNegativeButton(R.string.neg_button, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        showToast(getString(R.string.neg_button));
//                    }
//                });
//        AlertDialog dialog = builder.create();
//        return dialog;
//    }

    private void showToast(String buttonName) {
        Toast.makeText(getActivity(), "Clicked on \"" + buttonName + "\"", Toast.LENGTH_SHORT).show();
    }
}
