package es.moodbox.movementwear;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.CardScrollView;
import android.support.wearable.view.WatchViewStub;
import android.view.Gravity;
import android.widget.TextView;

public class MyActivity extends Activity {

    private TextView mTextViewVelocity;
    private TextView mTextViewDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        /*final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });*/

        mTextViewDistance = (TextView) findViewById(R.id.txt_meters);
        mTextViewVelocity = (TextView) findViewById(R.id.txt_velocity);

        CardScrollView cardScrollView =
                (CardScrollView) findViewById(R.id.card_scroll_view);
        cardScrollView.setCardGravity(Gravity.BOTTOM);
    }
}
