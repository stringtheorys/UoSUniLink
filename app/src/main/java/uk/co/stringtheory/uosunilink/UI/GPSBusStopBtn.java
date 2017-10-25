package uk.co.stringtheory.uosunilink.UI;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Button;

public class GPSBusStopBtn extends Button implements LocationListener {

    private LocationManager locationManager;

    public GPSBusStopBtn(Context context) {
        super(context);
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        context.enforcePermission(Context.LOCATION_SERVICE, 0, 0, "To get your location");
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, GPSBusStopBtn.this);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
