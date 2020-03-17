package com.example.knitknackapp.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.knitknackapp.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

       public FrameLayout ll;
       public MyViewHolder(FrameLayout v){
           super(v);
           ll = v;
       }
       // public TextView textView;
        //public MyViewHolder(TextView v) {
          //  super(v);
            //textView = v;
        //}
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    //public Adapter(){}

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
       // LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
          //       .inflate(R.layout.counter_view, parent, false);
        //MyViewHolder vh = new MyViewHolder(v);
        //return vh;
        FrameLayout v = (FrameLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.counter_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
       //holder.textView.setText(mDataset[position]);


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
       // return mDataset.length;
        return 3;
    }
}