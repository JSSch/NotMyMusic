package com.smartblue.notmymusic;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;


public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        ActionBar actionbar = getActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionbar.newTab().setText("Details");
        tab1.setTabListener(new MyTabListener());
        actionbar.addTab(tab1);

        ActionBar.Tab tab2 = actionbar.newTab().setText("More Music");
        tab2.setTabListener(new MyTabListener());
        actionbar.addTab(tab2);

        ActionBar.Tab tab3 = actionbar.newTab().setText("Events");
        tab3.setTabListener(new MyTabListener());
        actionbar.addTab(tab3);

        getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings: settings(); return true;
            case R.id.action_search: search(); return true;
            case R.id.action_add: add(); return true;
            case R.id.home:NavUtils.navigateUpFromSameTask(this); return true;

        }

        /*
        if (id == R.id.action_settings) {
            return true;
        }
        */
        return super.onOptionsItemSelected(item);

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
            return rootView;
        }
    }

    private void add() {
        Toast toast = Toast.makeText(this, "Adding", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void search() {
        Toast toast = Toast.makeText(this, "Search", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void settings() {
        Toast toast = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
        toast.show();
    }
}
