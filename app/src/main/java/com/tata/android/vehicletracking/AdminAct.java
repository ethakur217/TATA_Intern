package com.tata.android.vehicletracking;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AdminAct extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double latitudeStr=UserInfo.latitudeStr1;
    double longitudeStr=UserInfo.longitudeStr1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng jsr = new LatLng(latitudeStr,longitudeStr);
        mMap.addMarker(new MarkerOptions().position(jsr).title("User marker").snippet("Vehicle no:")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jsr));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

    }
}
