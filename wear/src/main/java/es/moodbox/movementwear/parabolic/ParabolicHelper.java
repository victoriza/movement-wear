package es.moodbox.movementwear.parabolic;

import android.util.Log;

/**
 * Created by victoriza on 11/10/14.
 */
public class ParabolicHelper {

	private static String TAG = ParabolicHelper.class.getSimpleName();
	private final static double GRAVITY = 9.80665;

	public static double distance(long v0x, long v0y) {
		double v0 = velocityOfLaunch(v0x, v0y);
		double angle = angleOfLaunch(v0x, v0y);
		double time = timeOfFlight(angle, v0);

		return distance(time,angle,v0);
	}

	public static double velocityOfLaunch(long v0x, long v0y) {
		Log.d(TAG, "v0x:"+v0x+"m/s v0y:"+v0y+" m/s");
		//v0 is now the vector representing velocity in m/s
		double v0 = Math.sqrt((v0x * v0x + v0y * v0y));
		Log.d(TAG, "v0:"+v0+" m/s");
		return v0;
	}

	private static double angleOfLaunch(long v0x, long v0y) {
		double v0 = velocityOfLaunch(v0x, v0y);
		Log.d(TAG, "v0:"+v0+" m/s");
		double angle = Math.asin(v0y / v0);
		Log.d(TAG, "angle: "+angle);
		return angle;
	}

	private static double timeOfFlight(double angle, double v0) {
		return ( (2 * v0) * Math.sin(angle) / GRAVITY);
	}

	private static double distance(double time, double v0, double angle) {
		return v0 * time * Math.cos(angle);
	}
}
