package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.helper;

import android.support.v7.widget.RecyclerView;

/**
 * Listener for manual initiation of drag.
 */

public interface OnStartDragListener {

    /**
     * Called when a view is requesting a start of drag.
     * @param viewHolder
     */
    void onStartDrag(RecyclerView.ViewHolder viewHolder);

}
