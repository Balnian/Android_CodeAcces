package com.example.francis.codeacces;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class seconde extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconde);
        Intent intent = getIntent();
        String nom = intent.getStringExtra("Nom");
        String code = intent.getStringExtra("Code");
        if(code.equals("1337"))
        {
            ((RelativeLayout)findViewById(R.id.bg)).setBackgroundColor(Color.GREEN);
            ((TextView)findViewById(R.id.texte)).setText("Bienvenue "+nom);
        }
        else{
            ((RelativeLayout)findViewById(R.id.bg)).setBackgroundColor(Color.RED);
            ((TextView)findViewById(R.id.texte)).setText("Vous n'avez pas le bon code!!!!!");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_seconde, menu);
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
