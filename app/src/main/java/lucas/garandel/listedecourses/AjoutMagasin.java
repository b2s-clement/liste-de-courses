package lucas.garandel.listedecourses;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AjoutMagasin extends AppCompatActivity {

    EditText name;
    Button valid,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_magasin);
        getSupportActionBar().setTitle("Ajout de magasin");

        name = (EditText)findViewById(R.id.addMagField);
        valid = (Button)findViewById(R.id.addMagValid);
        cancel = (Button)findViewById(R.id.addMagCancel);

        Intent intent = getIntent();
        String transmittedValue = intent.getStringExtra(Magasins.OLD_NOM_MAGASIN);
        if(!transmittedValue.isEmpty()){
            name.setText(transmittedValue);
        }


        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputTxt = name.getText().toString();
                if(!inputTxt.isEmpty()){
                    Intent retour = new Intent();
                    retour.putExtra(Magasins.NOM_MAGASIN,inputTxt);
                    setResult(Activity.RESULT_OK, retour);
                    finish();
                }else{
                    Snackbar.make(findViewById(R.id.activity_ajout_magasin), "Vous devez renseigner un nom", Snackbar.LENGTH_LONG)
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

    }
}
