package com.jemmy.calak.chatdate.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.jemmy.calak.chatdate.Listener.MainActivityListener;
import com.jemmy.calak.chatdate.R;
import com.jemmy.calak.chatdate.Utils.BottomNavigationHelper;
import com.jemmy.calak.chatdate.View.Beranda.BerandaFragment;
import com.jemmy.calak.chatdate.View.Home.HomeFragment;
import com.jemmy.calak.chatdate.View.Notification.NotificationFragment;
import com.jemmy.calak.chatdate.View.Profile.ProfileFragment;

public class MainActivity extends AppCompatActivity implements MainActivityListener, FragmentManager.OnBackStackChangedListener{

    private TextView mTextMessage;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private Fragment currentFragment;
    private BottomNavigationView navigation;
    private int navPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        openMainFragment(new HomeFragment());

    }

    private void openMainFragment(Fragment fragment) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(fragment, fragment.getClass().getName());
        transaction.replace(R.id.frameUtama, fragment, fragment.getClass().getName());
        transaction.addToBackStack(fragment.getClass().getName());
        transaction.commit();
        currentFragment = fragment;
        navPosition =0;
    }

    private void openFragment(Fragment fragment) {
        Log.d("statusFragment", ""+fragment.getClass().getName()+" , "+currentFragment.getClass().getName());
        if(currentFragment.getClass().getName() != fragment.getClass().getName()){
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            transaction.setCustomAnimations(R.anim.anim_slide_in_up, R.anim.anim_slide_out_down);
//            transaction.add(fragment, fragment.getClass().getName());
//            transaction.replace(R.id.frameUtama, fragment, fragment.getClass().getName());
            if (fragment.isAdded()) {
                Log.d("onShow", "<<===");
                transaction.show(fragment);
            } else {
                Log.d("onAdded", "<<===");
                transaction.add(R.id.frameUtama, fragment);
            }
            if (currentFragment.isAdded()) {
                Log.d("isAdded", "<<===");
                transaction.hide(currentFragment);
            }
            transaction.addToBackStack(fragment.getClass().getName());
            transaction.commit();
            currentFragment = fragment;
        }
    }

    @Override
    public void SwitchLayout(Fragment fragment) {
        openFragment(fragment);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(MainActivity.this, R.string.title_home, Toast.LENGTH_SHORT).show();
                    openFragment(new HomeFragment());
                    return true;
                case R.id.navigation_beranda:
                    Toast.makeText(MainActivity.this, R.string.title_beranda, Toast.LENGTH_SHORT).show();
                    openFragment(new BerandaFragment());
                    return true;
                case R.id.navigation_profile:
                    Toast.makeText(MainActivity.this, R.string.title_profile, Toast.LENGTH_SHORT).show();
                    openFragment(new ProfileFragment());
                    return true;
                case R.id.navigation_notifications:
                    Toast.makeText(MainActivity.this, R.string.title_notification, Toast.LENGTH_SHORT).show();
                    openFragment(new NotificationFragment());
                    return true;
            }
            return false;
        }
    };


    @Override
    public void onBackStackChanged() {
        if(manager.getBackStackEntryCount()==1){
            finish();
        } else {
            navigation.getMenu().getItem(0).setChecked(true);
            if (currentFragment.getClass().getName() == new HomeFragment().getClass().getName()){
                finish();
            }else{
                manager.popBackStack(new HomeFragment().getClass().getName(), 0);
            }
        }
    }

    @Override
    public void onBackPressed() {
        onBackStackChanged();
    }
}
