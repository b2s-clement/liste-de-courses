package lucas.garandel.listedecourses;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.MagasinAdapter;
import adapter.MagasinLongAdapter;
import model.Magasin;

public class Magasins extends Fragment {

    ArrayList<Magasin> data = new ArrayList<Magasin>();
    MagasinAdapter adapter;
    MagasinLongAdapter longAdapter;
    ListView liste;

    public static final int REQUEST_CODE_ADD = 123;
    public static final int REQUEST_CODE_EDIT = 111;
    public static final int NUM_MAGASIN = -1;
    public static final int OLD_NUM_MAGASIN = -1;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_magasins,container,false);

        //RESET DE LA SELECTION DE MAGASIN :
        Magasin.resetSelection();

        //ON PEUPLE LA LISTE :
        data = Magasin.getData();
        liste = (ListView)view.findViewById(R.id.fList);

        adapter = new MagasinAdapter(getActivity(), data);
        longAdapter = new MagasinLongAdapter(getActivity(), data);

        liste.setAdapter(adapter);

        //AJOUT DES COMPORTEMENTS SUR LA LISTE :

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent editMag = new Intent(getActivity(), AjoutMagasin.class);
                int old = ((Magasin)liste.getItemAtPosition(position)).getNum();
                editMag.putExtra("OLD_NUM_MAGASIN",old);
                editMag.putExtra("requestCode",REQUEST_CODE_EDIT);
                startActivityForResult(editMag, REQUEST_CODE_EDIT);
            }
        });

        liste.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Magasin m = ((Magasin)liste.getItemAtPosition(position));
                m.setChecked(!m.getChecked());
                liste.setAdapter(longAdapter);
                return true;
            }
        });

        //Surchage du bouton fab de l'activité principale
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMag = new Intent(getActivity(), AjoutMagasin.class);
                addMag.putExtra("requestCode", REQUEST_CODE_ADD);
                startActivityForResult(addMag, REQUEST_CODE_ADD);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case(Magasins.REQUEST_CODE_ADD):
                switch(resultCode){
                    case (Activity.RESULT_OK):
                        int result = intent.getIntExtra("numMag",Magasins.NUM_MAGASIN);

                        //Mettre a jour la liste :
                        // Construct the data source
                        data = Magasin.getData();

                        //MAJ des adapters : utile ?
                        adapter = new MagasinAdapter(getActivity(), data);
                        longAdapter = new MagasinLongAdapter(getActivity(), data);

                        // Attach the adapter to a ListView
                        liste.setAdapter(adapter);

                        return;

                    case (Activity.RESULT_CANCELED):
                        return;
                }
            case(Magasins.REQUEST_CODE_EDIT):
                switch(resultCode){
                    case (Activity.RESULT_OK):
                        int result = intent.getIntExtra("numMag",Magasins.NUM_MAGASIN);

                        //Mettre a jour la liste :
                        // Construct the data source
                        data = Magasin.getData();

                        //MAJ des adapters : utile ?
                        adapter = new MagasinAdapter(getActivity(), data);
                        longAdapter = new MagasinLongAdapter(getActivity(), data);

                        // Attach the adapter to a ListView
                        liste.setAdapter(adapter);

                        return;

                    case (Activity.RESULT_CANCELED):
                        return;
                }
        }
    }

}
