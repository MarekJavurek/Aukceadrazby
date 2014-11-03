package biz.netdevelopers.aukceadrazby;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class JindraUkol4 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jindra_ukol4);


        //naplneni spineru
        List<String> dataSpinneru = new ArrayList<String>();
        for (int i = 1; i < 31; i++) {
            dataSpinneru.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataSpinneru);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.JindraActivitySpinerPocetdni);
        sItems.setAdapter(adapter);
    }

    // odeslani formulare
    public void ClickJindraUkol4odeslat(View view) {
        validujFormular();
    }

    // validace formulare
    private boolean validujFormular() {
        EditText jmeno = (EditText) findViewById(R.id.EditText_jindraUkol4_jmenoPrijmeni);
        EditText email = (EditText) findViewById(R.id.EditText_jindraUkol4_Email);
        EditText telefon = (EditText) findViewById(R.id.EditText_jindraUkol4_Telefon);

        if (!isValidName(jmeno.getText())) {
            jmeno.setError("Jméno je povinné");
            jmeno.requestFocus();
            return false;
        } else if (!isValidPhone(telefon.getText())) {
            telefon.setError("Telefon je vy špatném formátu");
            telefon.requestFocus();
            return false;
        } else if (!isValidEmail(email.getText())) {
            email.setError("Email je vy špatném formátu");
            email.requestFocus();
            return false;
        } else {
            email.setError(null);
            telefon.setError(null);
            jmeno.setError(null);
            Toast.makeText(this, "Validace OK", Toast.LENGTH_LONG).show();
            return true;
        }
    }

    // fce na validaci emailu
    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    // fce na validaci telefonu
    public final static boolean isValidPhone(CharSequence target) {
        return !TextUtils.isEmpty(target) && Patterns.PHONE.matcher(target).matches();
    }

    // fce na validaci jmena
    public final static boolean isValidName(CharSequence target) {
        return !TextUtils.isEmpty(target);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.jindra_ukol4, menu);
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

}
