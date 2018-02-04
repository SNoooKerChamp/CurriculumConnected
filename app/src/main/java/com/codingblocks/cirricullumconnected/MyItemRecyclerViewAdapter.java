package com.codingblocks.cirricullumconnected;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.cirricullumconnected.Interface.OnListFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final String[] mValues;
    private  OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(String[] items) {
        mValues = items;

    }

    public void setonitemclicklistener(OnListFragmentInteractionListener listener){
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues[position];
        holder.tvSubjectname.setText(mValues[position]);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem,holder.mView);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvSubjectname;

        public String mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvSubjectname = (TextView) view.findViewById(R.id.tv_subjectname);

        }


    }
}
