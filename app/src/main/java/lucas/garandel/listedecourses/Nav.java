package lucas.garandel.listedecourses;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class Nav extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static Magasins frag1 =  new Magasins();
    private static Produits frag2 =  new Produits();
    private static Listes frag3 =  new Listes();
    private static Fragment[] listFrag ={frag1,frag2,frag3};
    private static String[] labelFrag = {"Magasins","Produits","Listes"};
    SharedPreferences pref;

    private static int selectedFragmentId;

    //Initialisation du FragmentManager
    public FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // GESTION DES PREFERENCES (pour afficher le bon fragment)
        pref = getPreferences(0);
        pref = getSharedPreferences("FRAGMENT",0);

        selectedFragmentId = pref.getInt("FRAGMENT",2);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(findViewById(R.id.content_nav), "Essai", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //A l'initialisation, on souhaite afficher le fragment stocké en préférence
        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_nav,listFrag[selectedFragmentId]);
        getSupportActionBar().setTitle(labelFrag[selectedFragmentId]);
        fragmentTransaction.commit();
        //On veut que l'item Listes soit sélectionné par défaut dans le menu
        navigationView.getMenu().getItem(selectedFragmentId).setChecked(true);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //On stocke l'id de l'item en static pour permettre de spécifier l'action du f ab
        selectedFragmentId=id;

        //On va commencer la transaction vers le fragment souhaité :
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        if (id == R.id.nav_magasins) {
            Magasins frag =  new Magasins();
            fragmentTransaction.replace(R.id.content_nav,frag);
            getSupportActionBar().setTitle("Magasins");

            pref.edit().clear().remove("FRAGMENT").putInt("FRAGMENT",0).commit();

        } else if (id == R.id.nav_produits) {
            Produits frag =  new Produits();
            fragmentTransaction.replace(R.id.content_nav,frag);

            getSupportActionBar().setTitle("Produits");
            pref.edit().clear().remove("FRAGMENT").putInt("FRAGMENT",1).commit();
        } else if (id == R.id.nav_listes) {
            Listes frag =  new Listes();
            fragmentTransaction.replace(R.id.content_nav,frag);

            getSupportActionBar().setTitle("Listes");
            pref.edit().clear().remove("FRAGMENT").putInt("FRAGMENT",2).commit();

        }

        //On commit la transaction :
        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
