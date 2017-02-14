package lucas.garandel.listedecourses;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import model.Magasin;

public class AjoutMagasin extends AppCompatActivity {

    EditText name,ville,pays;
    Button valid,cancel;

    int numMag,action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_magasin);
        try{
            getSupportActionBar().setTitle("Ajout de magasin");
        }catch(Exception e){

        }
/*

        name = (EditText)findViewById(R.id.addMagField);
        ville = (EditText)findViewById(R.id.addMagVille);
        pays = (EditText)findViewById(R.id.addMagPays);


        valid = (Button)findViewById(R.id.addMagValid);
        cancel = (Button)findViewById(R.id.addMagCancel);


        Intent intent = getIntent();
        //Stockage des données passées
        action = intent.getIntExtra("requestCode", 0);
        numMag = intent.getIntExtra("OLD_NUM_MAGASIN",0);

        if (action==Magasins.REQUEST_CODE_EDIT) {
            int transmittedValue = numMag;
            if(transmittedValue != -1){
                Magasin m = Magasin.getMagasin(transmittedValue);
                name.setText(m.getNom());
                ville.setText(m.getVille());
                pays.setText(m.getPays());
            }
        }



        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputTxt1 = name.getText().toString();
                String inputTxt2 = ville.getText().toString();
                String inputTxt3 = pays.getText().toString();
                if(!inputTxt1.isEmpty() && !inputTxt2.isEmpty() && !inputTxt3.isEmpty()){
                    //CAS CREATION DE MAGASIN
                    if(action==Magasins.REQUEST_CODE_ADD){
                        Magasin nouveau = new Magasin(inputTxt1,inputTxt3,inputTxt2,"none");
                        numMag = nouveau.getNum();
                    }

                    //CAS MODIFICATION DE MAGASIN
                    else if(action==Magasins.REQUEST_CODE_EDIT){
                        Magasin m = Magasin.getMagasin(numMag);
                        m.setNom(inputTxt1);
                        m.setVille(inputTxt2);
                        m.setPays(inputTxt3);
                    }


                    Intent retour = new Intent();
                    retour.putExtra("numMag",numMag);
                    setResult(Activity.RESULT_OK, retour);
                    finish();
                }else{
                    Snackbar.make(findViewById(R.id.activity_ajout_magasin), "Vous devez renseigner tous les champs", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent retour = new Intent();
                setResult(Activity.RESULT_CANCELED, retour);
                finish();
            }
        });
*/
    }
}
