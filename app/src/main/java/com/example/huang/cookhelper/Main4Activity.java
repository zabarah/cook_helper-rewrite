//this is the view recipe activity

package com.example.huang.cookhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    private String selectedItem;
    private Recipe recipe;
    private ArrayList<Ingredient> ingredients;
    private ListView ingre;
    private ArrayAdapter<String> ingreAdapter ;
    private TextView name,prepareTime,cookTime,calories,steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent=getIntent();
        selectedItem=intent.getStringExtra("selected");
        name=(TextView) findViewById(R.id.name);
        name.setText(selectedItem);
        ingre=(ListView) findViewById(R.id.ingredient);

        prepareTime=(TextView)findViewById(R.id.prepareTime);
        cookTime=(TextView)findViewById(R.id.cookTime);
        calories=(TextView)findViewById(R.id.calories);
        steps=(TextView)findViewById(R.id.steps);

        //Test
        prepareTime.setText("9");
        cookTime.setText("2");
        calories.setText("23");
        steps.setText("step1 \n step2");
        //should be as following
        //prepareTime.setText(recipe.getPrep().toString());
        //cookTime.setText(recipe.getCook()).toString();
        //calories.setText(recipe.getCal()).toString();
        //steps.setText(recipe.getSteps();

        //Need to implement real ingredient inside of this one
        ingredients= new ArrayList<>();
        for(int i=0;i<7;i++){
            Ingredient rr=new Ingredient("dd",9,"ss");
            ingredients.add(rr);
        }
        //
        //should be
        //          ingredients= recipe.getIng()
        //

        final String[] ingrelist = new String[ingredients.size()];
        for(int i=0;i<ingredients.size();i++){
            ingrelist[i]=ingredients.get(i).getname()+" "+ingredients.get(i).getQuantity()+" "+ingredients.get(i).getMestype();
        }
        ingreAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, ingrelist);
        ingre.setAdapter(ingreAdapter);





    }
    public void backToList(View view){
        Intent intent=new Intent(this,list.class);
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
