package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.infinitiStory.helper;

public interface ItemTouchHelperAdapter {
    boolean  onItemMove(int fromPosition, int toPosition);

    void  onItemDismiss(int position);
}
