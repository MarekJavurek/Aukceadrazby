package biz.netdevelopers.aukceadrazby;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class AuctionObjectListFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_auction_object_list, container, false);

        final View button = view.findViewById(R.id.tw_click);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       //Toast.makeText(getActivity(), "aaa", Toast.LENGTH_SHORT).show();
                        int polozka = 1;
                        ((MainActivity)getActivity()).klikfFragment(polozka);
                    }
                }
        );

        return view;




    }



}
