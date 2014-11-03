package biz.netdevelopers.aukceadrazby;

// import různých tříd

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MarekUkol4 extends Activity {

    // tahle fce se zvola vzdy kdyz se tato aktivita vytvoří
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marek_ukol4);

        // naplneni spinneru 1-30 dni
        List<String> spinnerArray = new ArrayList<String>();
        for (int i = 1; i <= 30; i++) {
            spinnerArray.add(Integer.toString(i));
        }

        // nastaveni zdroje dat spinneru
        /*
        * 1) vytvořím adaptér a připojím k němu data
        * 2) nastavím mod zobrazovani dat (layout) v adapteru
        * 3) přiřadím adaptér k spinneru
        * */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.pocetdni);
        sItems.setAdapter(adapter);

    }

    // vymazani formulare
    public void OnclickZrusit(View view) {

        // projde vsechny prvky v "MJA_4_linearsprvky" (LinearLayout) a kdyz se jedna o EditText tak ho vymaze
        ViewGroup group = (ViewGroup) findViewById(R.id.MJA_4_linearsprvky);
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View v = group.getChildAt(i);
            if (v instanceof EditText) {
                ((EditText) v).setText("");
            }
        }

        // vymazani ostatnich prvku co nejsou EditText

        // datepicker
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePicker datumod = (DatePicker) findViewById(R.id.MJA_4_datumod);
        datumod.updateDate(year, month, day);

        // spinner
        Spinner pocetdni = (Spinner) findViewById(R.id.pocetdni);
        pocetdni.setSelection(0);

        // radiogroup
        RadioGroup rg = (RadioGroup) findViewById(R.id.MJA_4_radiogroup);
        rg.clearCheck();

        // checkbox
        CheckBox ch = (CheckBox) findViewById(R.id.MJA_4_snidane);
        ch.setChecked(false);

        // togglebutton
        ToggleButton tg = (ToggleButton) findViewById(R.id.MJA_4_kurak);
        tg.setChecked(false);


    }

    // odeslani formulare
    public void OnclickOdeslat(View view) {
        validujFormular();
    }

    // validace formulare
    private boolean validujFormular() {
        EditText jmeno = (EditText) findViewById(R.id.MJA_4_jmenoaprijmeni);
        EditText email = (EditText) findViewById(R.id.MJA_4_email);
        EditText telefon = (EditText) findViewById(R.id.MJA_4_telefon);

        if (!isValidEmail(email.getText())) {
            email.setError("Email je ve špatném formátu");
            email.requestFocus();
            return false;
        } else if (!isValidPhone(telefon.getText())) {
            telefon.setError("Telefon je ve špatném formátu");
            telefon.requestFocus();
            return false;
        } else if (!isValidName(jmeno.getText())) {
            jmeno.setError("Jméno je povinné");
            jmeno.requestFocus();
            return false;
        } else {
            email.setError(null);
            telefon.setError(null);
            jmeno.setError(null);
            Toast.makeText(this, "Validace proběhla v pořádku", Toast.LENGTH_LONG).show();
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
}
