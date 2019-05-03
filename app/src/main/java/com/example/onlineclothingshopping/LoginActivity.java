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

public class LoginActivity extends Fragment implements View.OnClickListener {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editorForSharedPreference;

    Button btn_login;
    EditText txt_email, txt_password;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_login, container, false);

        txt_email=view.findViewById(R.id.txt_lgn_email);
        txt_password=view.findViewById(R.id.txt_lgn_passowrd);

        btn_login=view.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        sharedPreferences=getActivity().getSharedPreferences("SHOPPING_APP_USER_DETAILS",  Context.MODE_PRIVATE);
        editorForSharedPreference= sharedPreferences.edit();



        return  view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.btn_login){
            String email= txt_email.getText().toString();
            String password= txt_password.getText().toString();

            String registered_user_email= sharedPreferences.getString("USER_EMAIL","No user");
            String registered_user_password= sharedPreferences.getString("USER_PASSWORD","No password");

            if(email.equals("")){
                txt_email.setError("please enter your email");
            }

            else if(password.equals("")){
                txt_password.setError("please enter your password");
            }

            else if(email.equals(registered_user_email) && password.equals(registered_user_password)){
                Toast.makeText(getActivity(), "Welcome "+sharedPreferences.getString("USER_FULLNAME","no value"), Toast.LENGTH_SHORT).show();
            }


            else{
                txt_email.setError("Email and password didnot match, please try again");
                txt_email.requestFocus();
            }

        }
    }
}
