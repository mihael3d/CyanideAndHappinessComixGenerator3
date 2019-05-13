package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.infinitiStory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.infinitiStory.adapter.RecyclerListAdapter;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.infinitiStory.helper.OnStartDragListener;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.infinitiStory.helper.SimpleItemTouchHelperCallback;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static android.content.res.Configuration.ORIENTATION_PORTRAIT;


public class FragmentThree extends Fragment implements OnStartDragListener {

    private final int layout = R.layout.fragment_three;

    private RecyclerView recyclerView;
    private ItemTouchHelper itemTouchHelper;

    public static FragmentThree newInstance() {
        return new FragmentThree();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layout, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        int orientation = getResources().getConfiguration().orientation;
        if   (orientation == ORIENTATION_PORTRAIT) {
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        }  else {
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        }
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerListAdapter adapter = new RecyclerListAdapter(this, orientation);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter, orientation);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);


    }

    /**
     * Called when a view is requesting a start of drag.
     *
     * @param viewHolder
     */
    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }
}
