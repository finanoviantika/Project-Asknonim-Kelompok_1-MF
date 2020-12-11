package com.example.asknonim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * kelas MenuActivity digunakan untuk menampilkan akun
 * yang telah mendaftar dan login ditampilan layar
 * @author khairul anwar, nashrullah, fahmi ardiansyah, fina noviantika, nona zarima, mauliza yunita
 */
public class MenuActivity extends AppCompatActivity {

    //firebase auth
    FirebaseAuth firebaseAuth;

    //views
    TextView mProfileTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Actionbar and its title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menu");

        //init
        firebaseAuth = FirebaseAuth.getInstance();

        //init views
        mProfileTv = findViewById(R.id.profileTv);

    }

    /**
     * method checkUserStatus digunakan untuk mengecek akun user yang telah melakukan login dan register
     */
    private void checkUserStatus(){
        //get current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null){
            //user is signed in stay there
            //set email of logged in user
            mProfileTv.setText(user.getEmail());
        }
        else {
            //user not signed in,go to main activity
            startActivity(new Intent(MenuActivity.this,MainActivity.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onStart() {
        //check on start of app
        checkUserStatus();
        super.onStart();
    }

    /*inflate options menu*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflating menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*handle menu item clicks*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //get item id
        int id = item.getItemId();
        if (id == R.id.action_logout){
            firebaseAuth.signOut();
            checkUserStatus();
        }

        return super.onOptionsItemSelected(item);
    }
}