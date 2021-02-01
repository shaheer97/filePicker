package com.example.filepicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt_pathShow;
    Button btn_filePicker;
Intent myFileIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_pathShow=(TextView)findViewById(R.id.text_path);
        btn_filePicker=(Button)findViewById(R.id.btn_filePicker);

        btn_filePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
myFileIntent=new Intent(Intent.ACTION_GET_CONTENT);
myFileIntent.setType("*/*");
startActivityForResult(myFileIntent,10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:

                if (resultCode == RESULT_OK) {

                    String path = data.getData().getPath();
                    txt_pathShow.setText(path);

                }
                break;
        }
    }
}