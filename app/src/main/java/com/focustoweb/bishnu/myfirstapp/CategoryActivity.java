package com.focustoweb.bishnu.myfirstapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {

    private  IESummary db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        db = new IESummary(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void CategoryAdd(View view){
        EditText catTitle = (EditText) findViewById(R.id.category_title);
        String title = catTitle.getText().toString();

        EditText catDescription = (EditText) findViewById(R.id.category_description);
        db.CategoryAdd(catTitle.getText().toString(),catDescription.getText().toString(),1);

        TextView catTest = (TextView) findViewById(R.id.Category_Test);
        catTest.setText(title);
        catTest.append(catTitle.getText().toString() + catDescription.getText().toString());

        db.getWritableDatabase();
    }
}
