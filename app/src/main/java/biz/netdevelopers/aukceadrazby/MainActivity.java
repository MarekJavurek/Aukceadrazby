package biz.netdevelopers.aukceadrazby;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablet = false;
        if(findViewById(R.id.detail_aukce) != null) {
            tablet = true;
            FragmentManager FM = getFragmentManager();
            FragmentTransaction FT = FM.beginTransaction();
        }
        //Toast.makeText(this, tablet.toString(), Toast.LENGTH_SHORT).show();

        // nova instance tridy ktera bude poskytovat veskera data z API atd...
        /*
        vmp = new VasmajetekProvider(this);
        try {
            vmp.getAll();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ClickJindraUkol4(View view) {
        Intent intent = new Intent(this, JindraUkol4.class);
        startActivity(intent);
    }

    public void ClickMarekUkol4(View view) {
        Intent intent = new Intent(this, MarekUkol4.class);
        startActivity(intent);
    }
}
