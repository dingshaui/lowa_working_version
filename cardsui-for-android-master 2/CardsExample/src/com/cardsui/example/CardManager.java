package com.cardsui.example;

import com.fima.cardsui.objects.CardStack;
import com.fima.cardsui.views.CardUI;

public class CardManager {

	
	public CardManager(String lat, String longt) {
        this.lat = lat;
		this.longt = longt;
	}

	public CardManager() {
        lat = "";
        longt = "";
	}

	// Show original cards
	public void ShowCards(CardUI mCardView) {
        if (longt == "" && lat == "") {
        	ShowFakeCards(mCardView);
        } else {
        	ShowSingleCard(mCardView);
        }
	}

	public void ShowSingleCard(CardUI mCardView) {
		// init CardView
		mCardView.setSwipeable(false);
		CardStack stackPlay = new CardStack();
		stackPlay.setTitle("Location");
		mCardView.addStack(stackPlay);

		mCardView
				.addCardToLastStack(new MyPlayCard(
						"Location",
						this.lat,
						this.longt,
						"#e00707", "#e00707", true, true));

		mCardView.refresh();	
		
	}
	public void ShowFakeCards(CardUI mCardView) {
		// init CardView
		mCardView.setSwipeable(true);

		CardStack stackPlay = new CardStack();
		stackPlay.setTitle("");
		mCardView.addStack(stackPlay);

		mCardView.addCard(new MyPlayCard("Cafe",
				"Address", "112-96-3322", "#33b6ea", "#33b6ea", true, false));

		mCardView
				.addCardToLastStack(new MyPlayCard(
						"StarBucks",
						"1055 Escalone Ave, Sunnyvale, CA",
						"112-96-3322",
						"#e00707", "#e00707", true, true));

		// add one card
		mCardView
				.addCard(new MyPlayCard(
						"Hotel",
						"430 Giannini Dr, Santa Clara",
						"112-96-3322",
						"#f2a400", "#9d36d0", true, true));

		mCardView
				.addCardToLastStack(new MyPlayCard(
						"Home",
						"938 78th Street NY",
						"112-96-3322",
						"#4ac925", "#222222", true, true));
		// draw cards
		mCardView.refresh();	
	}
	
	public String lat;
	public String longt;
}
