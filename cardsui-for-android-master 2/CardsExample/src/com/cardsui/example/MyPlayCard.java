package com.cardsui.example;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fima.cardsui.objects.RecyclableCard;

public class MyPlayCard extends RecyclableCard {

    // Playcard has phone number.
	protected String phone;
	
	public MyPlayCard(String titlePlay, String description, String color,
			String titleColor, Boolean hasOverflow, Boolean isClickable) {
		super(titlePlay, description, color, titleColor, hasOverflow,
				isClickable);
	}

	public MyPlayCard(String titlePlay, String description, String phone, String color,
			String titleColor, Boolean hasOverflow, Boolean isClickable) {
		super(titlePlay, description, color, titleColor, hasOverflow,
				isClickable);
		this.phone = phone;
	}
	
	@Override
	protected int getCardLayoutId() {
		return R.layout.card_play;
	}

	@Override
	protected void applyTo(View convertView) {
		((TextView) convertView.findViewById(R.id.title)).setText(titlePlay);
		((TextView) convertView.findViewById(R.id.title)).setTextColor(Color
				.parseColor(titleColor));
		((TextView) convertView.findViewById(R.id.description))
				.setText(description);
		((TextView) convertView.findViewById(R.id.phone))
		.setText(phone);

		((ImageView) convertView.findViewById(R.id.stripe))
				.setBackgroundColor(Color.parseColor(color));

		if (isClickable == true)
			((LinearLayout) convertView.findViewById(R.id.contentLayout))
					.setBackgroundResource(R.drawable.selectable_background_cardbank);

		if (hasOverflow == true)
			((ImageView) convertView.findViewById(R.id.overflow))
					.setVisibility(View.VISIBLE);
		else
			((ImageView) convertView.findViewById(R.id.overflow))
					.setVisibility(View.GONE);
	}
}
