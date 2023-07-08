package com.example.test;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatDialogFragment;



public class DialogData extends AppCompatDialogFragment {
    String email,inaltime,greutate,varsta;

    public void setTransferredStringEmail(String str){
        email = str;
    }

    public void setTransferredStringGreutate(String abc)
    {
         greutate = abc;
    }
    public void setTransferredStringInaltime(String abc)
    {
        inaltime = abc;
    }
    public void setTransferredStringVarsta(String abc)
    {
        varsta = abc;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("USER DATA");
        builder.setMessage("Email: "+email+'\n'+"Greutate: "+greutate+" " +
                " KG"+'\n'+"Inaltime: "+inaltime+" CM"+'\n'+"Varsta: "+varsta+" ani");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setTextColor(Color.parseColor("#03fc28"));
                positiveButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#03fc28")));
            }
        });
        return builder.create();
    }


}