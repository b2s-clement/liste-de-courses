package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lucas.garandel.listedecourses.R;
import model.Magasin;

/**
 * Created by jambo on 08/02/17.
 */

public class MagasinAdapter extends ArrayAdapter<Magasin>{

    public MagasinAdapter(Context context, ArrayList<Magasin> mags){
        super(context,0,mags);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Magasin mag = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.magasin, parent, false);
        }
        // Lookup view for data population
        TextView nomMag = (TextView) convertView.findViewById(R.id.nomMag);
        TextView ville = (TextView) convertView.findViewById(R.id.ville);
        TextView pays = (TextView) convertView.findViewById(R.id.pays);
        // Populate the data into the template view using the data object
        nomMag.setText(mag.getNom());
        ville.setText(mag.getVille());
        pays.setText(mag.getPays());
        // Return the completed view to render on screen
        return convertView;
    }


}
