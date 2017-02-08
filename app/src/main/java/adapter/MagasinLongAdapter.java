package adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import lucas.garandel.listedecourses.R;
import model.Magasin;

/**
 * Created by jambo on 08/02/17.
 */

public class MagasinLongAdapter extends ArrayAdapter<Magasin> {

    public MagasinLongAdapter(Context context, ArrayList<Magasin> mags){
        super(context,0,mags);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Magasin mag = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view


        // A RETCHEQUER POUR LE CHANGEMENT DE COULEUR

        if (convertView == null) {
            if(!mag.getChecked()) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.magasin_select_items, parent, false);
            }else {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.magasin_select_items_checked, parent, false);
            }
        }
        // Lookup view for data population
        TextView nomMag = (TextView) convertView.findViewById(R.id.nomMag);
        TextView ville = (TextView) convertView.findViewById(R.id.ville);
        TextView pays = (TextView) convertView.findViewById(R.id.pays);
        CheckBox selected = (CheckBox) convertView.findViewById(R.id.checkBox);

        // Populate the data into the template view using the data object
        nomMag.setText(mag.getNom());
        ville.setText(mag.getVille());
        pays.setText(mag.getPays());
        selected.setChecked(mag.getChecked());

        final View finalConvertView = convertView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mag.setChecked(!mag.getChecked());
                CheckBox test = (CheckBox) finalConvertView.findViewById(R.id.checkBox);
                test.setChecked(mag.getChecked());
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }


}
