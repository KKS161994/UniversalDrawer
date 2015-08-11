package android.turhanoz.com.navdrawer;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * Created by Kartikey on 8/6/2015.
 */
public class FragmentItem extends Fragment implements NavDrawerCallBack {
    View rootView;
    TextView tv;
    public static String ARG_PAGE = "item_no";
    public static String PAGE_NO = "";
    public static Fragment getInstance(String args) {
        FragmentItem fragment = new FragmentItem();
        Bundle arguments = new Bundle();
        arguments.putString(ARG_PAGE, args);
        fragment.setArguments(arguments);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PAGE_NO = (String) getArguments().get(ARG_PAGE);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragmentlayout, container, false);
        tv= (TextView) rootView.findViewById(R.id.tvFragmentLayout);
        tv.setText(PAGE_NO);
        ArrayList<String> draweritems = new ArrayList<>();
        for (int i = Integer.parseInt(PAGE_NO); i < (Integer.parseInt(PAGE_NO) + 5); i++) {
            draweritems.add("hello" + i + "th");
        }
        NavigationDrawer.setDrawer(draweritems, this);
        return rootView;
    }

    @Override
    public void beforeDrawerConnected() {

    }
    @Override
    public void onDrawerConnected() {
    Toast.makeText(getActivity(),"Reached on Drawer Connected",Toast.LENGTH_SHORT).show();
    }
}
