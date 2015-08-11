package android.turhanoz.com.navdrawer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Kartikey on 8/5/2015.
 */
public class NavigationDrawer extends Fragment {
    public static ArrayList<String> adapterArraylist = new ArrayList<>();
    static RecyclerView recyclerView;
    static FragmentManager fm;
    public static NavDrawerCallBack navDrawerCallBack;
    public static NavigationAdapter navigationAdapter;
    public static DrawerLayout drawerLayout;

    public static Fragment getInstance() {
        NavigationDrawer fragment = new NavigationDrawer();
        return fragment;
    }

    public static void setDrawer(DrawerLayout drawerLayout) {
        NavigationDrawer.drawerLayout = drawerLayout;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.naviagtiondrawer, container, false);
        fm = getFragmentManager();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.drawer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        /*for (int i = 0; i < 9; i++) {
            adapterArraylist.add("hello" + i + "th");
        }*/
        navigationAdapter = new NavigationAdapter(adapterArraylist);
        recyclerView.setAdapter(navigationAdapter);
        return rootView;
    }

    public static void setDrawer(ArrayList<String> list, NavDrawerCallBack navDrawerCallBack) {
        drawerLayout.closeDrawers();
        /*adapterArraylist = list;
        navigationAdapter.notifyDataSetChanged();
        */navigationAdapter = new NavigationAdapter(list);
        recyclerView.setAdapter(navigationAdapter);
        navDrawerCallBack.onDrawerConnected();
    }

    public static FragmentManager getContext() {
        return fm;
    }
}
