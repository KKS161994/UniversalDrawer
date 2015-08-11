package android.turhanoz.com.navdrawer;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class NavigationAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    ArrayList<String> adapterList = new ArrayList<>();
    int positionClicked;
    public NavigationAdapter(ArrayList<String> adapterList) {
        this.adapterList = adapterList;
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.navigationdraweradapter, viewGroup, false);
        return new CustomViewHolder(view);
    }
    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        if (i < adapterList.size()) {
            customViewHolder.tv.setText(adapterList.get(i));
            customViewHolder.tv.setTag(customViewHolder);
        }
    }
    @Override
    public int getItemCount() {
        return adapterList.size();
    }
}
