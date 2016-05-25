package com.androhi.firebaseextensionsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        findViewById(R.id.open_second_button).setOnClickListener(this);
        findViewById(R.id.send_log_button).setOnClickListener(this);
        findViewById(R.id.set_user_property_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open_second_button:
                openSecondActivity();
                break;
            case R.id.send_log_button:
                sendEventLog();
                break;
            case R.id.set_user_property_button:
                setUserProperty();
                break;
            default:
                break;
        }
    }

    private void openSecondActivity() {
        startActivity(new Intent(this, SecondActivity.class));
    }

    private void sendEventLog() {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "button");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    private void setUserProperty() {
        mFirebaseAnalytics.setUserProperty("favorite_food", "Sushi");
    }
}
