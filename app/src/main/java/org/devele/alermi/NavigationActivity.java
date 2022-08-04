package org.devele.alermi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NavigationActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    private Fragment home,cmnt,prof,sear,stat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        bnv = findViewById(R.id.bnv);
        home = new home();
        cmnt = new community();
        prof = new profile();
        sear = new search();
        stat = new statement();
        getSupportFragmentManager().beginTransaction().add(R.id.navigation_frame,new search()).commit();
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.navigation_frame,new home()).commit();
                        break;
                    case R.id.bottom_community:
                        getSupportFragmentManager().beginTransaction().replace(R.id.navigation_frame,new community()).commit();
                        break;
                    case R.id.bottom_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.navigation_frame,new search()).commit();
                        break;
                    case R.id.bottom_statement:
                        getSupportFragmentManager().beginTransaction().replace(R.id.navigation_frame,new statement()).commit();
                        break;
                    case R.id.bottom_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.navigation_frame,new profile()).commit();
                        break;
                }
                return true;
            }
        });
    }
}