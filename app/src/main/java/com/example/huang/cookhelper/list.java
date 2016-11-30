package com.example.huang.cookhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class list extends AppCompatActivity {


    private ListView recipeList ;
    private ArrayAdapter<String> listAdapter ;
    private ArrayList<Recipe> recilist;
    private String category,require,foodtype,selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent=getIntent();
        category = intent.getStringExtra("category");
        foodtype= intent.getStringExtra("foodtype");
        require= intent.getStringExtra("require");

        recipeList=(ListView) findViewById(R.id.listRecipe);

        //need to implement real recipe inside of this one
        recilist= new ArrayList<Recipe>();
        for(int i=0;i<7;i++){
            Ingredient ing= new Ingredient("Tomatos",15,"gm");
            ArrayList<Ingredient> inglist=new ArrayList<Ingredient>();
            inglist.add(ing);
            Recipe rr=new Recipe("pasta","Main dish","Main dish","Greek",inglist,"11","11","11","11");
            recilist.add(rr);
        }
        //
        //should be
        //use Kiven search method
        //
        final String[] list = new String[recilist.size()];
        for(int i=0;i<recilist.size();i++){
            list[i]=recilist.get(i).getName();
        }
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, list);
        recipeList.setAdapter(listAdapter);
        recipeList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(list.this, list[position], Toast.LENGTH_SHORT).show();
                selectedItem=(String) recipeList.getItemAtPosition(position);

            }
        });


    }
    public void goViewPage(View view){
        Intent viewPage=new Intent(this,Main4Activity.class);
        viewPage.putExtra("selected",selectedItem);
        startActivity(viewPage);
    }
    public void back(View view){
        Intent viewPage=new Intent(this,MainActivity.class);
        startActivity(viewPage);
    }
}
