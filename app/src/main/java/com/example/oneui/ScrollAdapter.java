package com.example.oneui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ScrollAdapter extends RecyclerView.Adapter<ScrollAdapter.VH> {
    private final List<String> items;
    public ScrollAdapter(List<String> items){ this.items = items; }
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scroll, parent, false);
        return new VH(v);
    }
    @Override
    public void onBindViewHolder(VH holder, int position){
        holder.tv.setText(items.get(position));
    }
    @Override public int getItemCount(){ return items.size(); }
    static class VH extends RecyclerView.ViewHolder{
        TextView tv;
        VH(View v){ super(v); tv = v.findViewById(R.id.item_text); }
    }
}
