package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.view.Ui.helper;

public interface ItemTouchHelperAdapter {
    boolean  onItemMove(int fromPosition, int toPosition);

    void  onItemDismiss(int position);
}
