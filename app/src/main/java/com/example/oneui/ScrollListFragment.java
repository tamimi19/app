package com.example.oneui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * ScrollListFragment: يعرض قائمة من 70 عنصر. استخدمنا RecyclerView لعرض عناصر نصية.
 */
public class ScrollListFragment extends Fragment {
    public ScrollListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_scroll_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<String> items = new ArrayList<>();
        for (int i = 1; i <= 70; i++) {
            items.add("Item " + i);
        }
        recyclerView.setAdapter(new ListAdapter(items));
        return view;
    }

    private static class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
        private final List<String> mData;
        static class ViewHolder extends RecyclerView.ViewHolder {
            final TextView textView;
            ViewHolder(View view) {
                super(view);
                textView = view.findViewById(android.R.id.text1);
            }
        }
        ListAdapter(List<String> data) {
            mData = data;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(mData.get(position));
        }
        @Override
        public int getItemCount() {
            return mData.size();
        }
    }
}
