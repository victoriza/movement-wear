package es.moodbox.movementwear;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.view.CardScrollView;
import android.support.wearable.view.WatchViewStub;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends Activity implements SensorEventListener {

    private TextView mTextViewVelocity;
    private TextView mTextViewDistance;
	private TextView mTextView;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private long lastUpdate = 0;
	private float last_x, last_y, last_z;
	private static final int SHAKE_THRESHOLD = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mTextViewDistance = (TextView) findViewById(R.id.txt_meters);
        mTextViewVelocity = (TextView) findViewById(R.id.txt_velocity);

        CardScrollView cardScrollView =
                (CardScrollView) findViewById(R.id.card_scroll_view);
        cardScrollView.setCardGravity(Gravity.BOTTOM);
        initSensor();
    }
	private void initSensor() {
		mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
		mSensorManager.registerListener(this, mAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
		if(mAccelerometer == null) {
			Toast.makeText(this, "Accelerometer sensor not available", Toast.LENGTH_SHORT).show();
			finish();
		}else{
			Toast.makeText(this, "We have accelerometer!!", Toast.LENGTH_SHORT).show();
		}
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		Sensor mySensor = event.sensor;

		if (mySensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {


			float x = event.values[0];
			float y = event.values[1];
			float z = event.values[2];

			mTextView.setText("ACC values x:"+x+" y:"+y+" z:"+z);
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {

	}
}
