package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.helper.ItemTouchHelperAdapter;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.helper.OnStartDragListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class RecyclerListAdapter extends RecyclerView.Adapter<ItemViewHolder>  implements ItemTouchHelperAdapter {

    private int itemLayout = R.layout.item_card;
    private int orientation;

    private static final String[] STRINGS = new String[]{
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"
    };

    private final List<String> mItems = new ArrayList<>();
    private  final OnStartDragListener dragListener;


    public RecyclerListAdapter(OnStartDragListener dragListener, int orientation) {
        this.dragListener = dragListener;
        this.orientation = orientation;
        mItems.addAll(Arrays.asList(STRINGS));
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, int position) {
            if (orientation == ORIENTATION_PORTRAIT){
                holder.getImageView().setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if ( event.getActionMasked() == MotionEvent.ACTION_DOWN){
                            dragListener.onStartDrag(holder);
                        }
                        return false;
                    }
                });
            }
    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mItems, i, i+1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i --) {
                Collections.swap(mItems, i, i-1);
            }
        }
        notifyItemMoved(fromPosition,toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }


}
