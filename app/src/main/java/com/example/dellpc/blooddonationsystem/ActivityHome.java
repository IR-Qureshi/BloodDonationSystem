package com.example.dellpc.blooddonationsystem;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    AdapterUser mAdapterUser;
    FirebaseUser mFirebaseUser;
    TextView currentUser;
    TextView currentUserBG;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListner;
    //fragments..
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        mFirebaseAuth = mFirebaseAuth.getInstance();
//        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//
//        mAuthStateListner = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//               FirebaseUser user = firebaseAuth.getCurrentUser();
//                if(user!= null){
//                    Toast.makeText(ActivityHome.this, user.getUid(), Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        };


        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHome,new FragmentNewFeeds()).commit();

        //adding a current user
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String name = extras.getString("username");
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            View HeadView = navigationView.getHeaderView(0);
            currentUser = (TextView)HeadView.findViewById(R.id.NavUserName);
            currentUser.setText(name);
        }






        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

       // mAdapterUser = new AdapterUser(ActivityHome.this,R.layout.nav_header_activity_home,R.id.NavUserName);

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
        getMenuInflater().inflate(R.menu.activity_home, menu);
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
        if (id == R.id.signout){
            FirebaseAuth.getInstance().signOut();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHome,new FragmentNewFeeds()).commit();



        } else if (id == R.id.nav_MyRequests) {
//            mFragmentManager = getSupportFragmentManager();
//            mFragmentTransaction = mFragmentManager.beginTransaction();
//            mFragmentTransaction.replace(R.id.fragmentHome, new FragmentNewFeeds()).commit();

            //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHome,new FragmentNewFeeds()).commit();

        } else if (id == R.id.nav_notification) {

           // getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHome,new FragmentNewFeeds()).commit();
        } else if (id == R.id.nav_postReq) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHome,new FragmentPostReq()).commit();

        } else if (id == R.id.nav_setting) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHome,new FragmentNewFeeds()).commit();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
