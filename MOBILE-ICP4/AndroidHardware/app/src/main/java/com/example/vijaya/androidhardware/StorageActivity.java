package com.example.vijaya.androidhardware;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class StorageActivity extends AppCompatActivity {
    EditText txt_content;
    EditText txt_content2;
    String FILENAME = "MyAppStorage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        txt_content = (EditText) findViewById(R.id.id_txt_mycontent);
        txt_content2 = (EditText) findViewById(R.id.id_txt_display);
    }

    public void saveTofile(View v) throws IOException {
        // ICP Task4: Write the code to save the text
        String text = txt_content.getText().toString();
        FileOutputStream fileout = null;
        try{
            fileout = openFileOutput(FILENAME, MODE_APPEND);
            fileout.write(text.getBytes());
            txt_content.getText().clear();
            Toast.makeText(this,"save to" + getFilesDir()+"/" + FILENAME, Toast.LENGTH_LONG).show();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fileout!=null){
                fileout.close();
            }
        }
    }

    public void retrieveFromFile(View v) throws IOException {
        // ICP Task4: Write the code to display the above saved text
        FileInputStream filein = null;
        try {
            filein = openFileInput(FILENAME);
            InputStreamReader instream = new InputStreamReader(filein);
            BufferedReader bufferreader = new BufferedReader(instream);
            StringBuilder sbuilder = new StringBuilder();
            String txt;
            while (((txt = bufferreader.readLine())!=null)){
                sbuilder.append(txt).append("\n");
            }
            txt_content2.setText(sbuilder.toString());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(filein!=null){
                try{
                    filein.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
