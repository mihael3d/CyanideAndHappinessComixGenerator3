package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.helper;

public interface ItemTouchHelperAdapter {
    boolean  onItemMove(int fromPosition, int toPosition);

    void  onItemDismiss(int position);
}
