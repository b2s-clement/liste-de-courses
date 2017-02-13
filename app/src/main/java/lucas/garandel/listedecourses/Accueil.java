package lucas.garandel.listedecourses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import model.Magasin;

public class Accueil extends AppCompatActivity {

    Button bExit,bMag,bProd,bList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        //INITIALISATION DES COMPOSANTS DE l'ACTIVITE
        bExit = (Button)findViewById(R.id.exitbtn);
        bMag = (Button)findViewById(R.id.magbtn);
        bProd = (Button)findViewById(R.id.prodbtn);
        bList = (Button)findViewById(R.id.listbtn);

        bExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bMag.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Accueil.this, Magasins.class));
            }
        });

        bProd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Accueil.this, Produits.class));
            }
        });

        bList.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Accueil.this, Listes.class));
            }
        });
    }
}
