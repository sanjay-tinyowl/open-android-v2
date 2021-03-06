/*
   Copyright 2014 Citrus Payment Solutions Pvt. Ltd.
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
     http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package com.citrus.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.citrus.asynch.Binduser;
import com.citrus.asynch.GetWallet;
import com.citrus.asynch.Savecard;
import com.citrus.card.Card;
import com.citrus.mobile.Callback;
import com.citrus.mobile.Config;
import com.citrus.mobile.User;
import com.citruspay.sample.R;

public class MainActivity extends Activity {

	Button bind, savecard, getWallet, paybutton, logoutButton, widgetButton;

	Callback callback;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();

		callback = new Callback() {
			@Override
			public void onTaskexecuted(String success, String error) {
				showToast(success, error);
			}
		};

		bind = (Button) this.findViewById(R.id.bind);

		savecard = (Button) this.findViewById(R.id.savecard);

        getWallet = (Button) this.findViewById(R.id.getWallet);

		paybutton = (Button) this.findViewById(R.id.paybutton);
		
		logoutButton = (Button) this.findViewById(R.id.logoutbutton);
		
		widgetButton = (Button) this.findViewById(R.id.widgets);
		
		

		bind.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new Binduser(MainActivity.this, callback).execute("tester46@gmail.com", "9020184710");
			}
		});

		savecard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Card card = new Card("4242424242424242", "12", "20", "123", "Bruce Wayne", "debit");
				if(User.isUserLoggedIn(MainActivity.this))
					new Savecard(MainActivity.this, callback).execute(card);
				else
					Toast.makeText(getApplicationContext(), "Bind the user before saving card details.", Toast.LENGTH_LONG).show();

			}
		});

		getWallet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(User.isUserLoggedIn(MainActivity.this))
					new GetWallet(MainActivity.this, callback).execute();
				else
					Toast.makeText(getApplicationContext(), "Bind the user to get wallet.", Toast.LENGTH_LONG).show();
			}
		});

		paybutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, PaymentPage.class);
				startActivity(intent);
			}
		});
		
		logoutButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			User.logoutUser(MainActivity.this);
			if(User.logoutUser(MainActivity.this)) {
				Toast.makeText(getApplicationContext(), "User Logged out successfully.", Toast.LENGTH_LONG).show();
			}
			else {
				Toast.makeText(getApplicationContext(), "Failed to logout user.", Toast.LENGTH_LONG).show();
			}
			
			}
		});
		
		
        widgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Widgets.class);
                startActivity(intent);
            }
        });

	}

	private void init() {

		Config.setEnv("sandbox"); // replace it with production when you are ready

		Config.setupSignupId("test-signup");
		Config.setupSignupSecret("c78ec84e389814a05d3ae46546d16d2e");

		Config.setSigninId("test-signin");
		Config.setSigninSecret("52f7e15efd4208cf5345dd554443fd99");
	}

	private void showToast(String message, String error) {
		if (!TextUtils.isEmpty(message))
			Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

		if (!TextUtils.isEmpty(error))
			Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
	}

}