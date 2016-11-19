package com.example.huang.cookhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
    public void backToSearch(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void editPage(View view){
        Intent intent=new Intent(this,Main6Activity.class);
        startActivity(intent);
    }
    public void deletePage(View view){
        Intent intent=new Intent(this,Main5Activity.class);
        startActivity(intent);
    }
}
