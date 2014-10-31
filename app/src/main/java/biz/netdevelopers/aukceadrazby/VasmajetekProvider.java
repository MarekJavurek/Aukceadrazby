package biz.netdevelopers.aukceadrazby;

import android.app.ProgressDialog;
import android.content.Context;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class VasmajetekProvider {

    Context context;
    boolean isOnline;

    DownloadFilesTask dft;
    DownloadFilesTaskObject dfto;

    ProgressDialog mProgressDialog;

    public VasmajetekProvider(Context context) {
        this.context = context;

        this.isOnline = new Utils(this.context).isOnline();
    }

    // ziskani seznamu vsech aukci
    public ArrayList<AuctionObject> getAll() throws ExecutionException, InterruptedException {
        ArrayList<AuctionObject> all = new ArrayList<AuctionObject>();

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
            dfto.setDestination(this.context.getFilesDir() + "all.json"); // this.context.getFilesDir() + //"/sdcard/all.json"

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
            // TODO
        } else {
            String lastUpdate = "?";
            new Utils(this.context).TL("Nejsi online, poslední aktualizace dat: " + lastUpdate);
            // TODO
        }
        return null;
    }


    // ziskani objektu konkretni aukce
    public AuctionObject getOne(int id) {
        AuctionObject one = new AuctionObject();

        // TODO

        return one;
    }

}
