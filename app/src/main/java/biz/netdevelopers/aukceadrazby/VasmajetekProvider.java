package biz.netdevelopers.aukceadrazby;

import android.content.Context;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class VasmajetekProvider {

    Context context;
    boolean isOnline;

    DownloadFilesTask dft;
    DownloadFilesTaskObject dfto;

    public VasmajetekProvider(Context context) {
        this.context = context;

        Utils utils = new Utils(this.context);
        this.isOnline = utils.isOnline();
    }

    // ziskani seznamu vsech aukci
    public ArrayList<AuctionObject> getAll() throws MalformedURLException {
        ArrayList<AuctionObject> all = new ArrayList<AuctionObject>();

        if (isOnline) {
            dfto = new DownloadFilesTaskObject();
            dfto.setUrl(new URL("http://netdevelopers.biz/_da/download.php"));
            dfto.setDestination("/sdcard/all.json");

            dft = new DownloadFilesTask(this.context);
            //dft.execute()
        }
        
        // TODO

        return all;
    }


    // ziskani objektu konkretni aukce
    public AuctionObject getOne(int id) {
        AuctionObject one = new AuctionObject();

        // TODO

        return one;
    }

}
