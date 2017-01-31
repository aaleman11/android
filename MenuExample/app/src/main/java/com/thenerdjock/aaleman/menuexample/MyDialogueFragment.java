package com.thenerdjock.aaleman.menuexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by aaleman on 1/29/17.
 */

public class MyDialogueFragment extends DialogFragment{


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //Pass activity from Main Activity through constructor
        AlertDialog.Builder theDialog = new AlertDialog.Builder(getActivity());

        theDialog.setTitle("Sample Dialog");
        theDialog.setMessage("Hello, I'm a dialog!");

        theDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Clicked OK", Toast.LENGTH_SHORT).show();
            }
        });

        theDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Clicked CANCEL", Toast.LENGTH_SHORT).show();
            }
        });

        return super.onCreateDialog(savedInstanceState);
    }
}
