package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.view.Ui.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.ViewGroup;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.view.Ui.helper.ItemTouchHelperAdapter;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.view.Ui.helper.OnStartDragListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class RecyclerListAdapter extends RecyclerView.Adapter<CardViewHolder>  implements ItemTouchHelperAdapter {

   private int orientation;

    private final List<Integer> cardItems = new ArrayList<>();
    private  final OnStartDragListener dragListener;

    @Nullable
    private OnMoveUpOrLeftListner itemMoveUpOrLeftListner;
    @Nullable
    private OnItemMoveDownOrRightListner itemMoveDownOrRightListner;
    @Nullable
    private OnItemDismissListner onItemDismisstListner;


    public RecyclerListAdapter(OnStartDragListener dragListener, int orientation) {
        this.dragListener = dragListener;
        this.orientation = orientation;
       // cardItems.addAll(Arrays.asList(INTEGERS));
    }


    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return CardViewHolder.create(parent);
    }


    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
        Integer card = cardItems.get(position);
        holder.bind(card);
            if (orientation == ORIENTATION_PORTRAIT){
                holder.getImageView().setOnTouchListener((v, event) -> {
                    if ( event.getActionMasked() == MotionEvent.ACTION_DOWN){
                        dragListener.onStartDrag(holder);
                    }
                    return false;
                });
            }
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(cardItems, i, i+1);
                itemMoveUpOrLeftListner.onItemUpOrLeftMove(i);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i --) {
                Collections.swap(cardItems, i, i-1);

                itemMoveDownOrRightListner.onItemDownOrRightMove(i);
                //add callback2
            }
        }
        notifyItemMoved(fromPosition,toPosition);
        return true;
    }


    public void setOnMoveUpOrLeftListner (@NonNull OnMoveUpOrLeftListner itemMoveUpOrLeftListner) {
        this.itemMoveUpOrLeftListner = itemMoveUpOrLeftListner;
    }

    public interface OnMoveUpOrLeftListner {
        void onItemUpOrLeftMove (@NonNull int i );
    }

    public void setOnItemMoveDownOrRightListner (@NonNull OnItemMoveDownOrRightListner itemMoveDownOrRightListner) {
        this.itemMoveDownOrRightListner = itemMoveDownOrRightListner;
    }

    public interface OnItemMoveDownOrRightListner {
        void onItemDownOrRightMove (@NonNull int i );
    }

    @Override
    public void onItemDismiss(int position) {
        cardItems.remove(position);
        onItemDismisstListner.onItemDismiss(position);
        notifyItemRemoved(position);
    }

    public void setOnItemDismisstListner (@NonNull OnItemDismissListner onItemDismisstListner) {
        this.onItemDismisstListner = onItemDismisstListner;
    }

    public interface OnItemDismissListner {
        void onItemDismiss (@NonNull int position);
    }

    public void replaceItems(List<Integer> cardsItems) {
        this.cardItems.clear();
        this.cardItems.addAll(cardsItems);
        notifyDataSetChanged();
    }
}
