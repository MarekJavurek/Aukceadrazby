package biz.netdevelopers.aukceadrazby;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;


public class MainActivity extends Activity {

    VasmajetekProvider vmp;

    Boolean tablet;
    FragmentManager FM;
    Utils u;

    boolean isTablet = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        isTablet = getResources().getBoolean(R.bool.isTablet);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        u = new Utils(this);
        FM = getFragmentManager();
        tablet = false;

        FragmentTransaction FT = FM.beginTransaction();

        if (savedInstanceState == null ) {

            vmp = new VasmajetekProvider(this);
            try {
                vmp.getAll();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            AuctionObjectListFragment list = new AuctionObjectListFragment();
            FT.replace(R.id.seznam_aukci, list);






        }

        if(findViewById(R.id.detail_aukce) != null) {
            tablet = true;

            AuctionObjectDetailFragment detail = new AuctionObjectDetailFragment();

            Bundle bundle = new Bundle();
            bundle.putInt("id" , 0);
            detail.setArguments(bundle);

            FT.replace(R.id.detail_aukce, detail);
        } else {
            //
        }
        FT.commit();

        //Toast.makeText(this, tablet.toString(), Toast.LENGTH_SHORT).show();

        // nova instance tridy ktera bude poskytovat veskera data z API atd...

    }
    // http://stackoverflow.com/questions/15739635/how-to-return-value-from-async-task-in-android
    // http://codereview.stackexchange.com/questions/39123/efficient-way-of-having-synchronous-and-asynchronous-behavior-in-an-application

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {

            Intent intent = new Intent(this, Ukoly.class);
            startActivity(intent);

            return true;
        }
        else if (id == R.id.action_filters) {

            Intent intent = new Intent(this, Filtry.class);
            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void klikfFragment(int pocet) {

        FragmentTransaction FT = FM.beginTransaction();
        AuctionObjectDetailFragment detail = new AuctionObjectDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("id" , pocet);
        detail.setArguments(bundle);

        if ((getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) && (this.tablet == true)) {
            FT.replace(R.id.detail_aukce, detail);
        } else {
            FT.replace(R.id.seznam_aukci, detail).addToBackStack( "tag" );
        }

        FT.commit();

    }

}
