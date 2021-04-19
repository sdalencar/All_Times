package com.sdainfo.alltimes.ui.act;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.sdainfo.alltimes.R;
import com.sdainfo.alltimes.ui.cliente.ClienteFragment;
import com.sdainfo.alltimes.ui.principal.PrincipalFragment;
import com.sdainfo.alltimes.ui.servico.ServicoFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Carrega tela principal
        PrincipalFragment principalFragment = new PrincipalFragment();
        FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
        fragment.replace(R.id.frame_conteiner, principalFragment );
        fragment.commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_principal) {

            PrincipalFragment principalFragment = new PrincipalFragment();
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.replace(R.id.frame_conteiner, principalFragment );
            fragment.commit();

        } else if (id == R.id.nav_servico) {

            ServicoFragment servicosFragment = new ServicoFragment();
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.replace(R.id.frame_conteiner, servicosFragment );
            fragment.commit();

        } else if (id == R.id.nav_cliente) {

            ClienteFragment clientesFragment = new ClienteFragment();
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.replace(R.id.frame_conteiner, clientesFragment );
            fragment.commit();

        } else if (id == R.id.nav_contato) {
            enviarEmail();
        } else if (id == R.id.nav_sobre) {

            startActivity( new Intent(this, SobreActivity.class ) );

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void enviarEmail(){

        Intent email = new Intent( Intent.ACTION_SEND );
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"atmconsultoria@gmail.com" } );
        email.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App" );
        email.putExtra(Intent.EXTRA_TEXT, "Mensagem automática" );

        //configurar apps para e-mail
        email.setType("message/rfc822");
        //email.setType("application/pdf");
        //email.setType("image/png");

        startActivity( Intent.createChooser(email, "Escolha o App de e-mail:" ) );


    }

}
