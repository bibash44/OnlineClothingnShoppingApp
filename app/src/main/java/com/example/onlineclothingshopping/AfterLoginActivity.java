package com.example.onlineclothingshopping;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfterLoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt_logged_in_user;
    Button btn_add_items, btn_view_items;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        sharedPreferences = getSharedPreferences("SHOPPING_APP_USER_DETAILS", Context.MODE_PRIVATE);
        sharedPreferenceEditor = sharedPreferences.edit();


        txt_logged_in_user=findViewById(R.id.txt_logged_in_user);
        txt_logged_in_user.setText(txt_logged_in_user.getText()+sharedPreferences.getString("USER_FULLNAME", ""));

        btn_add_items=findViewById(R.id.btn_add_items);
        btn_view_items=findViewById(R.id.btn_view_items);

        btn_view_items.setOnClickListener(this);
        btn_add_items.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_add_items){
            Intent add_item_intent= new Intent(AfterLoginActivity.this, AddItemsActivity.class);
            startActivity(add_item_intent);
        }

        else if(v.getId()==R.id.btn_view_items){

        }
    }
}
