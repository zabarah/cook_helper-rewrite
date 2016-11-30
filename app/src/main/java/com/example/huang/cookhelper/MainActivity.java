package com.example.huang.cookhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner category, foodtype;
    private String cateString, typeString,require;
    private EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search=(EditText) findViewById(R.id.search);
        category = (Spinner) findViewById(R.id.category);
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this, R.array.category_arrays, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(categoryAdapter);

        foodtype = (Spinner) findViewById(R.id.type);
        List<String> list = new ArrayList<String>();
        list.add("Main dish");
        list.add("Starter");
        list.add("Dessert");
        list.add("Drink");
        list.add("Sauce");
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foodtype.setAdapter(typeAdapter);


    }
    public void backToMain(View view){
        Intent back=new Intent(this,Main3Activity.class);
        startActivity(back);
    }
    public void listPage(View view){
        Intent listPage=new Intent(this,list.class);
        category = (Spinner) findViewById(R.id.category);
        foodtype = (Spinner) findViewById(R.id.type);
        search=(EditText) findViewById(R.id.search);
        cateString= category.getSelectedItem().toString();
        typeString= foodtype.getSelectedItem().toString();
        require=search.getText().toString();
        listPage.putExtra("category", cateString);
        listPage.putExtra("foodtype",typeString);
        listPage.putExtra("require",require);
        startActivity(listPage);


    }

}
