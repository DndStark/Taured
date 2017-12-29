package com.example.miguel.taured;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.Toast;

public class AgregarWeb extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_web);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        c = (Button) findViewById(R.id.btn_c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AgregarWeb.this, GestionarWebs.class));
            }
        });
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
        getMenuInflater().inflate(R.menu.principal_user, menu);
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
        Intent menu;
        String m;

        if (id == R.id.nav_camera) {
            m = AgregarWeb.this.getResources().getString(R.string.web_list);
            Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
            menu = new Intent(AgregarWeb.this, GestionarWebs.class);
            startActivity(menu);
        } else if (id == R.id.nav_gallery) {
            m = AgregarWeb.this.getResources().getString(R.string.web_secciones);
            Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
            menu = new Intent(AgregarWeb.this, GestionarSecciones.class);
            startActivity(menu);
        } else if (id == R.id.nav_slideshow) {
            m = AgregarWeb.this.getResources().getString(R.string.web_productos);
            Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
            menu = new Intent(AgregarWeb.this, GestionarProductos.class);
            startActivity(menu);
        } else if (id == R.id.nav_manage) {
            m = AgregarWeb.this.getResources().getString(R.string.web_servicios);
            Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
            menu = new Intent(AgregarWeb.this, GestionarServicios.class);
            startActivity(menu);
        } else if (id == R.id.nav_send) {
            m = AgregarWeb.this.getResources().getString(R.string.admin_sesion);
            Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
            menu = new Intent(AgregarWeb.this, Login.class);
            startActivity(menu);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
