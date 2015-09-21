package com.example.francis.codeacces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout clavier;
    private Button BT_Zero;
    private Button BT_Effacer;
    private Button BT_Entrer;
    private EditText TB_Code;
    private EditText TB_Nom;
    private String motPasse="";
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clavier = (LinearLayout)findViewById(R.id.Clavier);
        BT_Zero = (Button)findViewById(R.id.Zero);
        BT_Effacer = (Button)findViewById(R.id.Effacer);
        BT_Entrer = (Button)findViewById(R.id.Entrer);
        TB_Nom = (EditText)findViewById(R.id.TB_Nom);
        TB_Code = (EditText)findViewById(R.id.Code);

        BT_Entrer.setEnabled(false);

        intent = new Intent(this, seconde.class);


        //set tous les boutons pour qu'ils mettent leur valeur dans le motpasse sur le click
        for (int i =0;i<3;i++) {
            for (int y=0;y<3;y++) {
                ((Button)((LinearLayout)clavier.getChildAt(i)).getChildAt(y)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(motPasse.length()<4) {
                            motPasse += ((Button) v).getText();
                            AjoutEtoile();
                        }
                        BT_Entrer.setEnabled(motPasse.length()==4);
                    }
                });
            }
        }

        //on vas chercher la valeur de zéro et on la met dans le motpasse (ne peux etre dans le for car il est entourer de Effacer et Entrer
        BT_Zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(motPasse.length()<4) {
                    motPasse += ((Button) v).getText();
                    AjoutEtoile();
                }
                BT_Entrer.setEnabled(motPasse.length()==4);
            }
        });

        //efface la valeur dans la string et tans le EditText
        BT_Effacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(motPasse.length()>0) {
                    motPasse = motPasse.substring(0, motPasse.length() - 1);
                    EnleverEtoile();
                }
                BT_Entrer.setEnabled(motPasse.length()==4);
            }
        });

        //crée la nouvelle activiter en lui passant les valeur
        BT_Entrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TB_Nom.getText().length()>0 && motPasse.length()==4) {
                    intent.putExtra("Nom", TB_Nom.getText().toString());
                    intent.putExtra("Code", motPasse);
                    startActivity(intent);
                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Vous devez mettre votre nom", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });




    }
    //Ajoute une étoile au EditText de code
    private void AjoutEtoile()
    {
        TB_Code.setText(TB_Code.getText().append('*'));

    }
    //Enlève une étoile au EditText de code
    private void EnleverEtoile()
    {
        if(TB_Code.getText().length()>0)
        TB_Code.setText(TB_Code.getText().delete(0,1));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
