package com.jitendera.tab2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class newTabCreate extends AppCompatActivity {

    private static final String FRAGMENT_NORMAL_TAB_DEMO = "normal tab demo";
    private static final String FRAGMENT_CUSTOMIZED_TAB_DEMO = "customized tab demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tab_create);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container_1, TabLayoutDemoFragment.newInstance(false), FRAGMENT_NORMAL_TAB_DEMO)
                   // .add(R.id.fragment_container_2, TabLayoutDemoFragment.newInstance(true), FRAGMENT_CUSTOMIZED_TAB_DEMO)

                    .commit();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_reset:
                ((TabLayoutDemoFragment)getSupportFragmentManager().findFragmentByTag(FRAGMENT_NORMAL_TAB_DEMO)).resetAdapter();
                ((TabLayoutDemoFragment)getSupportFragmentManager().findFragmentByTag(FRAGMENT_CUSTOMIZED_TAB_DEMO)).resetAdapter();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}