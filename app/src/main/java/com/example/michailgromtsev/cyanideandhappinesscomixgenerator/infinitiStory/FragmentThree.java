package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.adapter.RecyclerListAdapter;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.helper.OnStartDragListener;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.helper.SimpleItemTouchHelperCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;


public class FragmentThree extends Fragment implements OnStartDragListener {

    private final int layout = R.layout.fragment_three;

    private RecyclerView recyclerView;
    private ItemTouchHelper itemTouchHelper;
    private FloatingActionButton floatingActionButton;
    private RecyclerListAdapter adapter;

    private static final Integer[] INTEGERS = new Integer[]{
            R.drawable.ic_card_1,R.drawable.ic_card_2,R.drawable.ic_card_3,R.drawable.ic_card_4,
            R.drawable.ic_card_5,R.drawable.ic_card_6,R.drawable.ic_card_1,R.drawable.ic_card_2,
    };



    private ArrayList<Integer> integers  = new ArrayList<Integer>(
            Arrays.asList(R.drawable.ic_card_1,R.drawable.ic_card_2,R.drawable.ic_card_3,R.drawable.ic_card_4,
                    R.drawable.ic_card_5,R.drawable.ic_card_6,R.drawable.ic_card_1,R.drawable.ic_card_2));


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
        recyclerView.setHasFixedSize(false);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        int orientation = getResources().getConfiguration().orientation;
        if   (orientation == ORIENTATION_PORTRAIT) {
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        }  else {
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        }
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerListAdapter(this, orientation);
        recyclerView.setAdapter(adapter);
        updateItems(integers);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter, orientation);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /**
          Hide FloatingActionButton on recyclerView scrolling
             */
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int currentOrientation = getResources().getConfiguration().orientation;
                if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                    // Landscape
                    if (dx > 0) floatingActionButton.hide();
                    else floatingActionButton.show();
                }
                else {
                    // Portrait
                     if (dy > 0) floatingActionButton.hide();
                      else floatingActionButton.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });


        adapter.setOnMoveUpOrLeftListner(i -> {
            Collections.swap(integers, i, i+1);
        });

        adapter.setOnItemMoveDownOrRightListner(i -> {
            Collections.swap(integers, i, i-1);
        });

        adapter.setOnItemDismisstListner(position -> {
            integers.remove(position);
        });
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

    private void updateItems(List<Integer> cardsItems) {

        if (adapter != null) adapter.replaceItems(cardsItems);
    }
}
