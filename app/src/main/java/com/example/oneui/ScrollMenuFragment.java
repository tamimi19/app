package com.example.oneui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ScrollMenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_scroll_menu, container, false);
        RecyclerView rv = root.findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        List<String> items = new ArrayList<>();
        for (int i=1;i<=50;i++) items.add("Item " + i);
        ScrollAdapter adapter = new ScrollAdapter(items);
        rv.setAdapter(adapter);
        return root;
    }
}
