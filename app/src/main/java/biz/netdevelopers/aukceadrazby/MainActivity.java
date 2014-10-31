package biz.netdevelopers.aukceadrazby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.net.MalformedURLException;


public class MainActivity extends Activity {

    VasmajetekProvider vmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vmp = new VasmajetekProvider(this);
        vmp.getAll();

    }


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

    public void ClickJindraUkol4(View view)
    {
        Intent intent = new Intent(this, JindraUkol4.class);
        startActivity(intent);
    }

    public void ClickMarekUkol4(View view) {
        Intent intent = new Intent(this, MarekUkol4.class);
        startActivity(intent);
    }
}
