package android.turhanoz.com.navdrawer;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Kartikey on 8/5/2015.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView tv;
    public CustomViewHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.drawerItem);
        tv.setOnClickListener(this);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("cvh", "clicked" + getAdapterPosition());
        NavigationDrawer.getContext().beginTransaction().replace(R.id.content_frame, FragmentItem.getInstance(String.valueOf(getAdapterPosition())), "faq").addToBackStack(null).commit();
    }
}
