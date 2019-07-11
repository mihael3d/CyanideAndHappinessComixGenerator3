package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.view;

import android.content.res.Configuration;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.presenter.InfinitiStoryPresenter;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.view.Ui.adapter.RecyclerListAdapter;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.view.Ui.helper.OnStartDragListener;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.view.Ui.helper.SimpleItemTouchHelperCallback;

import java.util.List;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;


public class InfinitiStoryFragment extends MvpAppCompatFragment implements OnStartDragListener,InfinitiStoryView {

    private final int layout = R.layout.fragment_infiniti_story;

    private RecyclerView recyclerView;
    private ItemTouchHelper itemTouchHelper;
    private FloatingActionButton refreshFloatingActionButton;
    private RecyclerListAdapter adapter;

    @InjectPresenter(tag="infinitiStoryPresenter")
    InfinitiStoryPresenter infinitiStoryPresenter;

    public static InfinitiStoryFragment newInstance() {
        return new InfinitiStoryFragment();
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
        initUi(view);
        initUx();
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

    @Override
    public void setCardsListForRecycleView(List<Integer> cards) {
            if (adapter != null) adapter.replaceItems(cards);
    }

    @Override
    public void showRefreshFloatingActionButton() {
        refreshFloatingActionButton.show();
    }

    @Override
    public void hideRefreshFloatingActionButton() {
        refreshFloatingActionButton.hide();
    }

    @Override
    public void scrollRecyclerViewToPosition(int position) {
        if (recyclerView != null) {
            recyclerView.scrollToPosition(position);
//            if (infinitiStoryPresenter.isInRestoreState(this)){
//                recyclerView.scrollToPosition(position);
//            } else {
////                recyclerView.scrollToPosition(position +10);
//                RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(getActivity()){
//                    @Override protected int getVerticalSnapPreference() {
//                        return LinearSmoothScroller.SNAP_TO_START;
//                    }
//                };
//                smoothScroller.setTargetPosition(position);
//                ((LinearLayoutManager) recyclerView.getLayoutManager()).startSmoothScroll(smoothScroller );
//            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        int position = 0;
        if (recyclerView.getLayoutManager() != null) {
            position = ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        }
        infinitiStoryPresenter.onInfinitiStoryFragmentPoused(position);
    }

    private void initUi(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        refreshFloatingActionButton = view.findViewById(R.id.floatingActionButton);
    }


    private void initUx(){
        /**
         * Set orientation for RecyclerView in depends of devise orientation
         */
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

        /**
        Drag & drop and swipe behavior initialization
         */
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter, orientation);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        /**
         2 Callbacks from adapter when cards in RecyclerView are moving (Drag & drop)
         */
        adapter.setOnMoveUpOrLeftListner(i -> {
            infinitiStoryPresenter.onCardMoveUpOrLeft(i);
        });

        adapter.setOnItemMoveDownOrRightListner(i -> {
            infinitiStoryPresenter.onCardMoveDownOrRight(i);
        });

        /**
         Callback from adapter when a card in RecyclerView was swiped
         */
        adapter.setOnItemDismisstListner(position -> {
            infinitiStoryPresenter.onCardDismiss(position);
        });

        /**
         Hide/show FloatingActionButton at RecycleView skroll
         */
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /**
             Hide FloatingActionButton on recyclerView scrolling
             */
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int currentOrientation = getResources().getConfiguration().orientation;
                infinitiStoryPresenter.onRecyclerViewScroll(orientation, dx, dy);
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        refreshFloatingActionButton.setOnClickListener(v -> {


            Drawable imageLockDrawable = refreshFloatingActionButton.getDrawable();
            ((Animatable) imageLockDrawable).stop();
            ((Animatable) imageLockDrawable).start();
            infinitiStoryPresenter.onRefreshFloatingButtonPressed();
        });
    }


}
