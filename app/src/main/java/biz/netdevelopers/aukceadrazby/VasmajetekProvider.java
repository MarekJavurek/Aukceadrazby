package biz.netdevelopers.aukceadrazby;

import android.content.Context;
import java.util.ArrayList;

public class VasmajetekProvider {

    Context context;
    boolean isOnline;

    public VasmajetekProvider(Context context) {
        this.context = context;

        Utils utils = new Utils(this.context);
        this.isOnline = utils.isOnline();
    }

    // ziskani seznamu vsech aukci
    public ArrayList<AuctionObject> getAll() {
        ArrayList<AuctionObject> all = new ArrayList<AuctionObject>();

        if (isOnline) {
            getAuctionsAsync();
        }
        
        // TODO

        return all;
    }

    private void getAuctionsAsync() {
    }

    // ziskani objektu konkretni aukce
    public AuctionObject getOne(int id) {
        AuctionObject one = new AuctionObject();

        // TODO

        return one;
    }

}
