package biz.netdevelopers.aukceadrazby;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class AuctionObjectDetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int id = getArguments().getInt("id");
        Toast.makeText(((MainActivity)getActivity()),String.valueOf(id),Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.fragment_auction_object_detail, container, false);
    }

}
