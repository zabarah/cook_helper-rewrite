package com.example.huang.cookhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

public class Main2Activity extends AppCompatActivity{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void addClick(View view) {
        Spinner category = (Spinner) findViewById(R.id.category);
        Spinner type = (Spinner) findViewById(R.id.type);

        EditText eTextname = (EditText) findViewById(R.id.editText5);
        EditText eTextprep = (EditText) findViewById(R.id.editText6);
        EditText eTextcook = (EditText) findViewById(R.id.cooktime);
        EditText eTextcal = (EditText) findViewById(R.id.editText8);
        EditText eTextstep = (EditText) findViewById(R.id.editText2);
        String selectedcat=category.getItemAtPosition(category.getSelectedItemPosition()).toString();
        String selectedty=type.getItemAtPosition(type.getSelectedItemPosition()).toString();




        Recipe addrecipe=new Recipe((eTextname.getText().toString()),selectedty, selectedcat, null,null, (eTextcook.getText().toString()),(eTextprep.getText().toString()),(eTextcal.getText().toString()),(eTextstep.getText().toString()));
        System.out.println(addrecipe);

    }
    //method to execute arithmetic oper
}

