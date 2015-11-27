package com.focustoweb.bishnu.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.focustoweb.myfirstapp.MESSAGE";


    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);

        TextView txt = (TextView) findViewById(R.id.textView);
        //String msg = editText.getText().toString();
        txt.setText("test "+ message);

    }

    public void AddCategory(View view){
        Intent categoryIntent = new Intent(this,CategoryActivity.class);
        categoryIntent.putExtra("key", "CategoryActivity"); //Optional parameters
        this.startActivity(categoryIntent);

    }

    public void AddIncome(View view){
        Intent incomeIntent = new Intent(this,IncomeActivity.class);
        incomeIntent.putExtra("key", "IncomeActivity"); //Optional parameters
        this.startActivity(incomeIntent);
    }

    public void AddExpenditure(View view){

    }

    public void ViewIncome(View view){

    }

    public void ViewExpenditure(View view){

    }

    public void About(View view){
        Intent aboutIntent = new Intent(this,AboutActivity.class);
        aboutIntent.putExtra("key", "AboutActivity"); //Optional parameters
        this.startActivity(aboutIntent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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
}
