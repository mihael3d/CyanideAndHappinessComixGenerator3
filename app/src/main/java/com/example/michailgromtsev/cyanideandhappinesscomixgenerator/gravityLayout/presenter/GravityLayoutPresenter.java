package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.model.GravityLayoutModel;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.view.GravityLayoutView;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

@InjectViewState
public class GravityLayoutPresenter extends MvpPresenter<GravityLayoutView> {

    private GravityLayoutModel gravityLayoutModel;
    private int orientation;
    private long onCardPressTime ;
    private int cardPresseNumber;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        gravityLayoutModel = GravityLayoutModel.getInstance();

        getViewState().setCard1Image(gravityLayoutModel.getCard1Image());
        getViewState().setCard2Image(gravityLayoutModel.getCard2Image());
        getViewState().setCard3Image(gravityLayoutModel.getCard3Image());
        getViewState().setCard4Image(gravityLayoutModel.getCard4Image());
        getViewState().setCard5Image(gravityLayoutModel.getCard5Image());


    }

    @Override
    public void attachView(GravityLayoutView view) {
        super.attachView(view);
        if (orientation == ORIENTATION_PORTRAIT){
            if (gravityLayoutModel.getCardsPortraitOrientation() != null){
                getViewState().setCardsToPositions(gravityLayoutModel.getCardsPortraitOrientation());
            }
        } else {
            if (gravityLayoutModel.getCardsLandscapeOrientation() != null){
                getViewState().setCardsToPositions(gravityLayoutModel.getCardsLandscapeOrientation());
            }
        }

        boolean[] cardsNeedToSave = gravityLayoutModel.getCardsNeedToSave();
        if (cardsNeedToSave != null) {
            getViewState().showCard1BorderLocked( cardsNeedToSave[0]);
            getViewState().showCard2BorderLocked( cardsNeedToSave[1]);
            getViewState().showCard3BorderLocked( cardsNeedToSave[2]);
            getViewState().showCard4BorderLocked( cardsNeedToSave[3]);
            getViewState().showCard5BorderLocked( cardsNeedToSave[4]);
        }

    }

    public void onRefreshFloatingButtonPressed (float card1Y,
                                                float card2Y,
                                                float card3Y,
                                                float card4Y,
                                                float card5Y,
                                                float cardLineY,
                                                float cardHeight) {

        boolean[] cardsNeedToSave = gravityLayoutModel.getCardsNeedToSave();
        if (cardsNeedToSave == null) {
            cardsNeedToSave = new boolean[5];
        }

        boolean[] cardsNeedToSaveInDependsOfPositionOnScreen = new boolean[5];
        if (orientation == ORIENTATION_LANDSCAPE){
            cardsNeedToSaveInDependsOfPositionOnScreen[0] = (card1Y) > cardLineY;
            cardsNeedToSaveInDependsOfPositionOnScreen[1] = (card2Y) > cardLineY;
            cardsNeedToSaveInDependsOfPositionOnScreen[2] = (card3Y) > cardLineY;
            cardsNeedToSaveInDependsOfPositionOnScreen[3] = (card4Y) > cardLineY;
            cardsNeedToSaveInDependsOfPositionOnScreen[4] = (card5Y) > cardLineY;
        }

        if (!cardsNeedToSave[0]&& !cardsNeedToSaveInDependsOfPositionOnScreen[0]){
            gravityLayoutModel.randomCard1Image();
            getViewState().setCard1Image(gravityLayoutModel.getCard1Image());
            getViewState().setCard1Jump( true);
        } else { getViewState().setCard1Jump( false);}

        if (!cardsNeedToSave[1] && !cardsNeedToSaveInDependsOfPositionOnScreen[1]){
            gravityLayoutModel.randomCard2Image();
            getViewState().setCard2Image(gravityLayoutModel.getCard2Image());
            getViewState().setCard2Jump( true);
        }else { getViewState().setCard2Jump( false);}

        if (!cardsNeedToSave[2] && !cardsNeedToSaveInDependsOfPositionOnScreen[2]){
            gravityLayoutModel.randomCard3Image();
            getViewState().setCard3Image(gravityLayoutModel.getCard3Image());
            getViewState().setCard3Jump( true);
        } else { getViewState().setCard3Jump( false);}

        if (!cardsNeedToSave[3] && !cardsNeedToSaveInDependsOfPositionOnScreen[3]){
            gravityLayoutModel.randomCard4Image();
            getViewState().setCard4Image(gravityLayoutModel.getCard4Image());
            getViewState().setCard4Jump( true);
        } else { getViewState().setCard4Jump( false);}

        if (!cardsNeedToSave[4] && !cardsNeedToSaveInDependsOfPositionOnScreen[4]){
            gravityLayoutModel.randomCard5Image();
            getViewState().setCard5Image(gravityLayoutModel.getCard5Image());
            getViewState().setCard5Jump( true);
        }else { getViewState().setCard5Jump( false);}
    }


    public void onCreateView(int orientation){
        this.orientation = orientation;
    }

    public void onPoused(float card1ViewX,float card1ViewY,
                         float card2ViewX,float card2ViewY,
                         float card3ViewX,float card3ViewY,
                         float card4ViewX,float card4ViewY,
                         float card5ViewX,float card5ViewY){
         float[] cardViewCoordinats = new  float[]{ card1ViewX, card1ViewY, card2ViewX, card2ViewY,
                 card3ViewX, card3ViewY,card4ViewX, card4ViewY, card5ViewX, card5ViewY,};

         if (orientation == ORIENTATION_PORTRAIT) {
             gravityLayoutModel.setCardsPortraitOrientation(cardViewCoordinats);
         } else {
             gravityLayoutModel.setCardsLandscapeOrientation(cardViewCoordinats);
         }

    }

    public void onCardPres (int cardNumber, long timeInSec)  {
         if (cardPresseNumber == cardNumber && timeInSec - onCardPressTime <= 0.5 ) {
             boolean[] cardsNeedToSave = gravityLayoutModel.getCardsNeedToSave();
             if (cardsNeedToSave == null) {
                 cardsNeedToSave = new boolean[5];
             }

             cardsNeedToSave[cardNumber-1] = !cardsNeedToSave[cardNumber-1];
             gravityLayoutModel.setCardsNeedToSave(cardsNeedToSave);

             switch (cardNumber){
                 case 1:
                     getViewState().showCard1BorderLocked( cardsNeedToSave[cardNumber-1]);
//                     getViewState().setCard1Jump( !cardsNeedToSave[cardNumber-1]);
                     break;
                 case 2:
                     getViewState().showCard2BorderLocked( cardsNeedToSave[cardNumber-1]);
//                     getViewState().setCard2Jump( !cardsNeedToSave[cardNumber-1]);
                     break;
                 case 3:
                     getViewState().showCard3BorderLocked( cardsNeedToSave[cardNumber-1]);
//                     getViewState().setCard3Jump( !cardsNeedToSave[cardNumber-1]);
                     break;
                 case 4:
                     getViewState().showCard4BorderLocked( cardsNeedToSave[cardNumber-1]);
//                     getViewState().setCard4Jump( !cardsNeedToSave[cardNumber-1]);
                     break;
                 case 5:
                     getViewState().showCard5BorderLocked( cardsNeedToSave[cardNumber-1]);
//                     getViewState().setCard5Jump( !cardsNeedToSave[cardNumber-1]);
                     break;
                     default:
                         break;
             }

             cardNumber = 0;
         }
        cardPresseNumber = cardNumber;
        onCardPressTime = timeInSec;
    }
}
