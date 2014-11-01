package biz.netdevelopers.aukceadrazby;

import android.app.ProgressDialog;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class VasmajetekProvider {

    Context context;
    boolean isOnline;

    DownloadFilesTask dft;
    DownloadFilesTaskObject dfto;
    String finalAllDest;

    ProgressDialog mProgressDialog;

    public VasmajetekProvider(Context context) {
        this.context = context;

        this.isOnline = new Utils(this.context).isOnline();
    }

    // ziskani seznamu vsech aukci
    public ArrayList<AuctionObject> getAll() throws ExecutionException, InterruptedException {
        // ArrayList<AuctionObject> all = new ArrayList<AuctionObject>();

        if (isOnline) {

            mProgressDialog = new ProgressDialog(this.context);
            mProgressDialog.setMessage("Aktualizace dat...");
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setCancelable(true);

            dfto = new DownloadFilesTaskObject();
            try {
                dfto.setUrl(new URL("http://netdevelopers.biz/_da/download.php")); // http://netdevelopers.biz/_da/download.php // http://ipv6.download.thinkbroadband.com/5MB.zip
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            finalAllDest = this.context.getFilesDir() + "all.json";
            dfto.setDestination(finalAllDest); // this.context.getFilesDir() + //"/sdcard/all.json"

            dft = new DownloadFilesTask(this.context) {
                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    mProgressDialog.show();
                }

                @Override
                protected void onProgressUpdate(Integer... progress) {
                    super.onProgressUpdate(progress);
                    mProgressDialog.setIndeterminate(false);
                    mProgressDialog.setMax(100);
                    mProgressDialog.setProgress(progress[0]);
                }

                @Override
                protected void onPostExecute(String result) {
                    super.onPostExecute(result);
                    mProgressDialog.dismiss();
                }
            };
            dft.execute(dfto);
            String aResultM = dft.get();

            if (aResultM == null)
                try {
                    return getArrayFromJSONAll(finalAllDest); // TODO
                } catch (Exception e) {
                    e.printStackTrace();
                }
            else
                return null;

        } else {
            String lastUpdate = "?";
            new Utils(this.context).TL("Nejsi online, poslední aktualizace dat: " + lastUpdate);
            // TODO pokud nejsi online nacti data od posledne
        }
        return null;
    }

    // http://www.androidhive.info/2012/01/android-json-parsing-tutorial/
    // http://www.androidhive.info/2012/01/android-json-parsing-tutorial/
    private ArrayList<AuctionObject> getArrayFromJSONAll(String dest) throws Exception {

        ArrayList<AuctionObject> all = new ArrayList<AuctionObject>();

        String json = Utils.getStringFromFile(dest);

        JSONArray data = new JSONArray(json);

        // looping through All nodes
        for (int i = 0; i < data.length(); i++) {
            JSONObject c = data.getJSONObject(i);
            AuctionObject a = new AuctionObject();
            a.setAdvert_name(c.getString("2"));
            //TODO add other elements
            //use >  int id = c.getInt("duration"); if you want get an int
            all.add(a);
        }

        return all;
    }


    // ziskani objektu konkretni aukce
    public AuctionObject getOne(int id) {
        AuctionObject one = new AuctionObject();

        // TODO

        return one;
    }

}
