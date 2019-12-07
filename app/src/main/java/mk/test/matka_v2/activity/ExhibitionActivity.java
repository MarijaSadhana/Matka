package mk.test.matka_v2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import mk.test.matka_v2.R;
import mk.test.matka_v2.fragment.ContactFragment;
import mk.test.matka_v2.fragment.HistoryFragment;
import mk.test.matka_v2.fragment.HomeFragment;
import mk.test.matka_v2.fragment.VideosFragment;

public class ExhibitionActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibition);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        bottomNavigation.setSelectedItemId(R.id.home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentTransaction ft;
        Fragment fragment;

        switch (menuItem.getItemId()){
            case R.id.home:
                fragment = HomeFragment.newInstance();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, fragment, HomeFragment.TAG);
                ft.commit();
                return true;
            case R.id.video:
                fragment = VideosFragment.newInstance();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, fragment, VideosFragment.TAG);
                ft.commit();
                return true;
            case R.id.history:
                fragment = HistoryFragment.newInstance();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, fragment, HistoryFragment.TAG);
                ft.commit();
                return true;
            case R.id.contact:
                fragment = ContactFragment.newInstance();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, fragment, ContactFragment.TAG);
                ft.commit();
                return true;
        }
        return false;
    }
}
