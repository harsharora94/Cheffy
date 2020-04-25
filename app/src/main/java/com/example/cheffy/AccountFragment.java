package com.example.cheffy;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {


    Button buttonSave;
    Button buttonChangePassword;
    SharedPreferences sharedPreferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_account, container, false);

        buttonSave = (Button) view.findViewById(R.id.buttonSave);
        buttonChangePassword = (Button) view.findViewById(R.id.buttonChangePassword);




        /*//Back button
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null)
        {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);

        }*/

        //*/

       /* PrefFragment prefFragment = (PrefFragment) getActivity().getFragmentManager().findFragmentByTag("PrefFragmentTag");
        if(getActivity().getFragmentManager().findFragmentByTag("PrefFragmentTag") != null)
        {
            getActivity().getFragmentManager().beginTransaction().remove(prefFragment).commit();
        }*/





        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

                //alert.setTitle("Change Password");

                TextView title = new TextView(getActivity());
                title.setText("Change Password");
                title.setBackgroundColor(Color.DKGRAY);
                title.setPadding(10, 10, 10, 10);
                title.setGravity(Gravity.CENTER);
                title.setTextColor(Color.WHITE);
                title.setTextSize(20);

                alert.setCustomTitle(title);

                //alert.setMessage("Old Password");
                // Set an EditText view to get user input
                //final EditText input = new EditText(getActivity());
                //alert.setView(input);

                final EditText oldPassword = new EditText(getActivity());
                final EditText newPassword = new EditText(getActivity());
                final EditText confirmPassword = new EditText(getActivity());

                oldPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                newPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                confirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                oldPassword.setHint("Old Password");
                newPassword.setHint("New Password");
                confirmPassword.setHint("Confirm Password");
                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setPadding(0, 10, 0, 0);
                linearLayout.addView(oldPassword);
                linearLayout.addView(newPassword);
                linearLayout.addView(confirmPassword);
                alert.setView(linearLayout);


                alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        // Do something with value!
                        Toast.makeText(getActivity(), "Password Changed Successfully", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                    }
                });

                final AlertDialog dialog = alert.create();
                dialog.show();

                /*final Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                LinearLayout.LayoutParams positiveButtonLL = (LinearLayout.LayoutParams) positiveButton.getLayoutParams();
                positiveButtonLL.gravity = Gravity.CENTER_HORIZONTAL;
                positiveButton.setLayoutParams(positiveButtonLL);*/

            }
        });




        TextInputLayout userNameLayout = (TextInputLayout) view.findViewById(R.id.userNameLayout);
        //userNameLayout.setErrorEnabled(true);
        //userNameLayout.setError("Min 3 chars required");
        final EditText userName = (EditText) view.findViewById(R.id.userName);
        //userName.setError("Required");


        TextInputLayout userEmailLayout = (TextInputLayout) view.findViewById(R.id.userEmailLayout);
        //userEmailLayout.setErrorEnabled(true);
        //userEmailLayout.setError("Please enter a valid email address");
        final EditText userEmail = (EditText) view.findViewById(R.id.userEmail);
        /*userEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View arg0, boolean arg1) {
                userEmail.setError(null);
                if (userEmail.getText().toString().trim().equalsIgnoreCase("")) {
                    userEmail.setError("Required");
                }
            }
        });*/




        TextInputLayout userMobileLayout = (TextInputLayout) view.findViewById(R.id.userMobileLayout);
        //userMobileLayout.setErrorEnabled(true);
        //userMobileLayout.setError("Please enter a valid phone number");
        final EditText userMobile = (EditText) view.findViewById(R.id.userMobile);
        /*userMobile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View arg0, boolean arg1) {
                userMobile.setError(null);
                if (userMobile.getText().toString().trim().equalsIgnoreCase("")) {
                    userMobile.setError("Required");
                }
            }
        });*/

        TextInputLayout userAddressLayout = (TextInputLayout) view.findViewById(R.id.userAddressLayout);
        final EditText userAddress = (EditText) view.findViewById(R.id.userAddress);


        buttonSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(userEmail.getText().toString().equals("") || userMobile.getText().toString().equals(""))
                {
                    userEmail.setError("Required");
                    userMobile.setError("Required");
                }
                else
                {
//
                    //Shared Preferences to Store the data(This is just a sample for local storage and future device based cache)
                    // TODO: Mukesh need to create framework level implementation to use these storage with 128/256 bit encryption.

                    sharedPreferences = getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("userName", userName.getText().toString());
                    editor.putString("userEmail", userEmail.getText().toString());
                    editor.putString("userMobile", userMobile.getText().toString());
                    editor.putString("userAddress", userAddress.getText().toString());
                    editor.apply();

                    Toast.makeText(getActivity(), "Profile Saved Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sharedPreferences = getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        String suserName = sharedPreferences.getString("userName","");
        String suserEmail = sharedPreferences.getString("userEmail","");
        String suserMobile = sharedPreferences.getString("userMobile","");
        String suserAddress = sharedPreferences.getString("userAddress","");
        userName.setText(suserName);
        userEmail.setText(suserEmail);
        userMobile.setText(suserMobile);
        userAddress.setText(suserAddress);


        return view;
    }

}
