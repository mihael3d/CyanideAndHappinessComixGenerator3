package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.infinitiStory.adapter;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.infinitiStory.helper.ItemTouchHelperViewHolder;

public class ItemViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

private CardView cardView;
private ColorStateList cardColor;
private ImageView imageView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cv1);
        imageView = itemView.findViewById(R.id.imageView1);
        cardColor = cardView.getCardBackgroundColor();
    }

    /**
     * Called when the {@link ItemTouchHelper} first registers an item as being moved or swiped.
     * Implementations should update the item view to indicate it's active state.
     */
    @Override
    public void onItemSelected() {
        cardView.setCardBackgroundColor(Color.LTGRAY);

    }

    /**
     * Called when the {@link ItemTouchHelper} has completed the move or swipe, and the active item
     * state should be cleared.
     */
    @Override
    public void onItemClear() {
        cardView.setCardBackgroundColor(cardColor);

    }

    public ImageView getImageView() {
        return imageView;
    }

    public CardView getCardView() {
        return cardView;
    }
}
