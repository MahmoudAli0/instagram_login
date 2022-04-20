package com.mahmoud.instagram_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {
    EditText name_phone ,pass;
    Button login ;
    TextView readData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name_phone =findViewById(R.id.name_phone);
        pass=findViewById(R.id.pass);
        login=findViewById(R.id.btn_login);
        readData=findViewById(R.id.te_restore);

    }
    public void btn_onClick(View v){
        try {

            String name=name_phone.getText().toString();
            String password=pass.getText().toString();
            FileOutputStream fos= openFileOutput("data",MODE_PRIVATE);
            PrintWriter pw =new PrintWriter(fos);
            pw.println(name +password);
            pw.close();
            fos.close();
            Toast.makeText(MainActivity.this,"Data Saved",Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void restore(View v){
        try {
            FileInputStream fis=openFileInput("data");
            InputStreamReader ins =new InputStreamReader(fis);
            BufferedReader bw=new BufferedReader(ins);

            String all_text="";
            String read_data="";
            read_data=bw.readLine();
            while (read_data !=null){
                all_text+=read_data;
            }

            bw.close();
            ins.close();
            fis.close();
            Toast.makeText(MainActivity.this,all_text,Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}