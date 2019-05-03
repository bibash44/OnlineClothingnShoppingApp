package com.example.onlineclothingshopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class AddItemsActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txt_item_name, txt_item_price, txt_item_image_name, txt_item_description;
    Button btn_add_an_item;
    String FILE_NAME = "items.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        txt_item_name = findViewById(R.id.txt_item_name);
        txt_item_price = findViewById(R.id.txt_item_price);
        txt_item_image_name = findViewById(R.id.txt_item_image_name);
        txt_item_description = findViewById(R.id.txt_item_desciption);

        btn_add_an_item = findViewById(R.id.btn_add_an_item);
        btn_add_an_item.setOnClickListener(this);

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            }
            catch (FileNotFoundException e){
                    e.printStackTrace();
            }
        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add_an_item) {
            String item_name = txt_item_name.getText().toString();
            String item_price = txt_item_price.getText().toString();
            String item_image_name = txt_item_image_name.getText().toString();
            String item_description = txt_item_description.getText().toString();

            if (item_name.equals("")) {
                txt_item_name.setError("please enter item name");
            } else if (item_price.equals("")) {
                txt_item_name.setError("please enter item price");
            } else if (item_image_name.equals("")) {
                txt_item_name.setError("please enter item image name");
            } else if (item_description.equals("")) {
                txt_item_name.setError("please enter item description");
            } else {
                String text = item_name + "-" + item_price + "-" + item_image_name + "-" + item_description;
                String data = null;


                try {

                    FileInputStream fis = null;
                    fis = openFileInput(FILE_NAME);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();

                    while ((data = br.readLine()) != null) {
                        sb.append(data).append("\n");
                        text = data + text;
                    }


                    FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                    fos.write(text.getBytes());
                    fos.close();
                    Toast.makeText(this, "Item inserted", Toast.LENGTH_SHORT).show();

                    txt_item_name.setText(null);
                    txt_item_image_name.setText(null);
                    txt_item_price.setText(null);
                    txt_item_description.setText(null);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
