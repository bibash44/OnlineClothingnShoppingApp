package com.example.onlineclothingshopping;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class RegisterationActivity extends Fragment implements View.OnClickListener {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferenceEditor;

    EditText txt_fullname, txt_email, txt_phone, txt_password;
    Button btn_signup;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registeration, container, false);

        txt_fullname = view.findViewById(R.id.txt_sgn_fullname);
        txt_email = view.findViewById(R.id.txt_sgn_email);
        txt_phone = view.findViewById(R.id.txt_sgn_phone);
        txt_password = view.findViewById(R.id.txt_sgn_password);

        btn_signup = view.findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(this);


        sharedPreferences = getActivity().getSharedPreferences("SHOPPING_APP_USER_DETAILS", Context.MODE_PRIVATE);
        sharedPreferenceEditor = sharedPreferences.edit();


        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_signup) {
            String fullname = txt_fullname.getText().toString();
            String email = txt_email.getText().toString();
            String phone = txt_phone.getText().toString();
            String password = txt_password.getText().toString();


            if (fullname.equals("")) {
                txt_fullname.setError("please enter your name");
            }

            else if (email.equals("")) {
                txt_email.setError("please enter your email");
            }

            else if (phone.equals("")) {
                txt_password.setError("please enter your phone");
            }

            else if (password.equals("")) {
                txt_password.setError("please enter your password");
            }

            else{

                sharedPreferenceEditor.putString("USER_FULLNAME", fullname);
                sharedPreferenceEditor.putString("USER_EMAIL", email);
                sharedPreferenceEditor.putString("USER_PHONE", phone);
                sharedPreferenceEditor.putString("USER_PASSWORD", password);
                sharedPreferenceEditor.commit();

                Toast.makeText(getActivity(), "Hello "+sharedPreferences.getString("USER_FULLNAME","No user")+" your are registered, now you can login", Toast.LENGTH_SHORT).show();

                txt_fullname.setText("");
                txt_email.setText("");
                txt_phone.setText("");
                txt_password.setText("");
                txt_fullname.requestFocus();

            }

        }
    }
}
