package biz.netdevelopers.aukceadrazby;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class Filtry extends Activity {

    MultiSelectionSpinner f_kraje;
    MultiSelectionSpinner f_typ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtry);



        String[] kunda = { "Hl. m. Praha", "Středočeský", "Jihočeský", "Plzeňský", "Ústecký", "Královéhradecký", "Vysočina", "Olomoucký", "Moravskoslezský" };
        f_kraje = (MultiSelectionSpinner) findViewById(R.id.f_kraje);
        f_kraje.setItems(kunda);

        String[] array = { "Aukce", "Dražba", "Prodej" };
        f_typ = (MultiSelectionSpinner) findViewById(R.id.f_typ);
        f_typ.setItems(array);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_filtry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v){
        String s = "Vybrané typy: " + f_typ.getSelectedItemsAsString() + ", Vybrané kraje: " + f_kraje.getSelectedItemsAsString();
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }


}
