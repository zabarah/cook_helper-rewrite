package com.example.huang.cookhelper;

import android.app.Activity;
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

//for DB
import java.util.List;
import android.app.ListActivity;

public class list extends AppCompatActivity {


    private ListView recipeList ;
    private ArrayAdapter<String> listAdapter ;
    private ArrayList<Recipe> recilist;
    private String category,require,foodtype,selectedItem;

    //for DB
    private CommentsDataSource datasource;

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
        datasource = new CommentsDataSource(this);
        datasource.open();
        final List<Comment> values = datasource.getAllComments();
        final ArrayAdapter<Comment> listAdapter = new ArrayAdapter<Comment>(this,
                                android.R.layout.simple_list_item_1, values);

        /* replaced by DB adapter
        final String[] list = new String[recilist.size()];
        for(int i=0;i<recilist.size();i++){
            list[i]=recilist.get(i).getName();
        }
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, list);
        */
        recipeList.setAdapter(listAdapter);

        recipeList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Comment item = datasource.getRecipeAtPosition(i);

                Intent intent = new Intent(list.this,Main4Activity.class);
                //based on item add info to intent
                startActivity(intent);
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

    @Override
        protected void onResume() {
                datasource.open();
                super.onResume();
        }

        @Override
        protected void onPause() {
                datasource.close();
                super.onPause();
        }

}
