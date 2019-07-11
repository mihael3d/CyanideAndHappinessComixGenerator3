package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.view.Ui.adapter;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.GlobalApplication;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.view.Ui.helper.ItemTouchHelperViewHolder;

public class CardViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

    private static final int LAYOUT = R.layout.item_card;

    private CardView cardView;
    private ColorStateList cardColor;
    private ImageView imageView;
    private RelativeLayout relativeLayout;


    public static CardViewHolder create( @NonNull ViewGroup parent){
        final View view =  LayoutInflater.from(parent.getContext()).inflate(LAYOUT,parent,false);
        return new CardViewHolder(view);
    }

     CardViewHolder(View itemView) {
        super(itemView);
        findeViews(itemView);
    }

    void bind (@NonNull Integer cardResuse) {
        imageView.setImageResource(cardResuse);
    }

    /**
     * Called when the {@link ItemTouchHelper} first registers an item as being moved or swiped.
     * Implementations should update the item view to indicate it's active state.
     */
    @Override
    public void onItemSelected() {
       cardView.setCardBackgroundColor(GlobalApplication.getAppContext().getResources().getColor(R.color.primary_light));
        relativeLayout.setBackgroundResource( R.drawable.cardborderlock);
    }

    /**
     * Called when the {@link ItemTouchHelper} has completed the move or swipe, and the active item
     * state should be cleared.
     */
    @Override
    public void onItemClear() {
        cardView.setCardBackgroundColor(cardColor);
        relativeLayout.setBackgroundResource(0);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public CardView getCardView() {
        return cardView;
    }

    private void findeViews (@NonNull View itemView) {
        cardView = itemView.findViewById(R.id.cv1);
        imageView = itemView.findViewById(R.id.item_card_image_view);
        cardColor = cardView.getCardBackgroundColor();
        relativeLayout = itemView.findViewById(R.id.card_1_border_layout);
    }
}
