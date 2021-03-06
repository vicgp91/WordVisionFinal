package pa.resilienciacomunitaria.org.worldvision;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ContactoEmergencias> contactos;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ListView listContacto;
    private ContactoAdapter adapter;
    private TextView tvNombre, tvNumCelda;



   /* private String[] tabIcons = {
            "Teléfonos",
            "Primeros Auxilios",
            "Word Vision"
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setBackgroundColor(Color.parseColor("#FFFFFF"));

        if (isOnline(MainActivity.this)){
         startService(new Intent(getBaseContext(), GuardarParticipantesService.class));
        }


      //  setupTabIcons();
    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new participa_fragment(), "Participa");
        adapter.addFrag(new TwoFragment(), "Guías");
        adapter.addFrag(new OneFragment(), "Teléfonos");
        adapter.addFrag(new ThreeFragment(), "World Vision");
        viewPager.setAdapter(adapter);
    }

   /* private void setupTabIcons() {
        tabLayout.getTabAt(0).setText(tabIcons[0]);
        tabLayout.getTabAt(1).setText(tabIcons[1]);
        tabLayout.getTabAt(2).setText(tabIcons[2]);
    }*/

   /* private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "");
        adapter.addFragment(new TwoFragment(), "");
        adapter.addFragment(new ThreeFragment(), "");
        viewPager.setAdapter(adapter);
    }*/

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isOnline(Context context) {
        boolean isInternetAvailable = false;
        try
        {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if(networkInfo != null && (networkInfo.isConnected()))
            {
                isInternetAvailable  = true;
            }
        }
        catch(Exception exception)
        {

        }

        return isInternetAvailable;
    }

}
