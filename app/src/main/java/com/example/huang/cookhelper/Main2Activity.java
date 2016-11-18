package com.example.huang.cookhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String selected;



    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String selected = parent.getItemAtPosition(pos).toString();
        }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void addClick(View view) {
        EditText eTextname = (EditText) findViewById(R.id.editText5);
        EditText eTextprep = (EditText) findViewById(R.id.editText6);
        EditText eTextcook = (EditText) findViewById(R.id.cooktime);
        EditText eTextcal = (EditText) findViewById(R.id.editText8);
        EditText eTextstep = (EditText) findViewById(R.id.editText2);


        Recipe addrecipe=new Recipe((eTextname.getText().toString()),null, null, null,null, (eTextcook.getText().toString()),(eTextprep.getText().toString()),(eTextcal.getText().toString()),(eTextstep.getText().toString()));


    }
    //method to execute arithmetic oper
}

