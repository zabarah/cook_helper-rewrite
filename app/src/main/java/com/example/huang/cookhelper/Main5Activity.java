package com.example.huang.cookhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class Main5Activity extends AppCompatActivity {
    private Recipe incomingrec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void deleteClick(View view){
        Intent search=new Intent(this,MainActivity.class);
        startActivity(search);

    }
}
