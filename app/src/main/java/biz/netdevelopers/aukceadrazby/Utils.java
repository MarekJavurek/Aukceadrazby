package biz.netdevelopers.aukceadrazby;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Utils {

    Context context;

    public Utils(Context context) {
        this.context = context;
    }

    // je zarizeni pripojene k internetu?
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void TL(String msg) {
        Toast.makeText(this.context, msg, Toast.LENGTH_LONG).show();
    }
}
