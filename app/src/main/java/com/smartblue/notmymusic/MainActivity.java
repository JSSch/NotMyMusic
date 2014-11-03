package com.smartblue.notmymusic;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;


public class MainActivity extends Activity {

    SearchFragment searchFragment = new SearchFragment();
    PlaceholderFragment placeholderFragment = new PlaceholderFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, placeholderFragment)
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            swapView();
            return true;
        }

        if (id == R.id.action_add) {
            startNewActivity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void swapView() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction().addToBackStack(null);

        getFragmentManager().beginTransaction()
                .remove(placeholderFragment)
                .commit();

        getFragmentManager().beginTransaction()
                .remove(searchFragment)
                .commit();

        fragmentTransaction.add(R.id.container, searchFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    private void startNewActivity() {
        startActivity(new Intent (MainActivity.this, AddActivity.class));
    }

    public void startDetailActivity(View view) {
        startActivity(new Intent (MainActivity.this, DetailActivity.class));
    }
}
