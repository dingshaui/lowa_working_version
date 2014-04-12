package com.cardsui.example;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.cardsui.example.MyLocation.LocationResult;
import com.fima.cardsui.views.CardUI;

public class MainActivity extends Activity {

	private CardUI mCardView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mCardView = (CardUI) findViewById(R.id.cardsview);

		Intent intent = getIntent();
		String lat = intent.getStringExtra("Latitude");
		String longt = intent.getStringExtra("Longtitude");
		
		if (lat == null && longt == null) {
		    CardManager cm = new CardManager();
            cm.ShowCards(mCardView);
		} else {
		    CardManager cm = new CardManager(lat, longt);
            cm.ShowCards(mCardView);			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void finishInput(View view) {
        Log.i("Mylog", "get latitude and longtitude");

		LocationResult locationResult = new LocationResult(){
		    @Override
		    public void gotLocation(Location location){
                Log.i("Mylog", "latitude:" + location.getLatitude());
                Log.i("Mylog", "longtitude:" + location.getLongitude());
		    }
		};
		MyLocation myLocation = new MyLocation();
		myLocation.getLocation(this, locationResult);
				
    	Intent intent = new Intent(this, MainActivity.class);    	
    	intent.putExtra("Latitude", "latitude:");
        intent.putExtra("Longtitude", "longtitude");
    	startActivity(intent);
	}

}
