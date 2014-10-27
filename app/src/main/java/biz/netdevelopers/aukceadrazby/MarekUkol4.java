package biz.netdevelopers.aukceadrazby;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class MarekUkol4 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marek_ukol4);


        List<String> spinnerArray =  new ArrayList<String>();
        for (int i = 1; i <= 30; i++) {
            spinnerArray.add(Integer.toString(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.pocetdni);
        sItems.setAdapter(adapter);

    }

    public void OnclickZrusit(View view) {

        // projde vsechny prvky v "MJA_4_linearsprvky" (LinearLayout) a kdyz se jedna o EditText tak ho vymaze
        ViewGroup group = (ViewGroup)findViewById(R.id.MJA_4_linearsprvky);
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View v = group.getChildAt(i);
            if (v instanceof EditText) {
                ((EditText)v).setText("");
            }
        }


        EditText jmeno = (EditText) findViewById(R.id.MJA_4_jmenoaprijmeni);
        jmeno.setText("");
    }

    public void OnclickOdeslat(View view) {
    }

    // fce na validaci emailu
    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
