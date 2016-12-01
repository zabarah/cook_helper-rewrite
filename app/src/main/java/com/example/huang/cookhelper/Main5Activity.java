//this is the delete recipe activity

package com.example.huang.cookhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class Main5Activity extends AppCompatActivity {
    private Recipe incomingrec;

    //for DB
    private RecipesDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void deleteClick(View view){
        dataSource = new RecipesDataSource(this);
        dataSource.open();
        dataSource.deleteRecipe(incomingrec);

    }
}
