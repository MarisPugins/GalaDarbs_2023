package com.example.galadarbs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.galadarbs.SecondHomeWork.FirstHomeworkJsonFragment;
import com.example.galadarbs.FinalWork.FindJokerFragment;
import com.example.galadarbs.FirstHomeWork.FirstHomeWork;
import com.example.galadarbs.SecondHomeWork.PostDetailsFragment;
import com.example.galadarbs.ThirdHomeWork.ThirdHomeWork;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    public static String urlRecycle = "https://sinka.lv/android_end_work.html";
    public static String urlPosts = "https://jsonplaceholder.typicode.com/posts";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigation_bar);
        startHomeFragment();
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.isChecked()){
                    return false;
                }
                switch (item.getItemId()) {
                    case R.id.nav_home: {
                        startHomeFragment();
                        return true;
                    }
                    case R.id.nav_wallpaper: {
                        startFirstHomeWork();
                        return true;
                    }
                    case R.id.nav_json_homework: {
                        startSecondHomeWork();
                        return true;
                    }
                    case R.id.nav_recycle: {
                        startThirdHomeWork();
                        return true;
                    }
                    case R.id.nav_lucky_choice:
                        startLuckyChoiceFragment();
                        return true;
                }
                return false;
            }
        });

    }

    private void startHomeFragment() {
        startFragment(new HomeFragment());

    }

    private void startFirstHomeWork() {
        startFragment(new FirstHomeWork());
    }

    private void startSecondHomeWork() {startFragment(new FirstHomeworkJsonFragment()); }

    private void startThirdHomeWork() {startFragment(new ThirdHomeWork()); }

    private void startLuckyChoiceFragment() { startFragment(new FindJokerFragment()); }


    public void startFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.from_right,R.animator.exit_to_left);
        transaction.replace(R.id.fl_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}