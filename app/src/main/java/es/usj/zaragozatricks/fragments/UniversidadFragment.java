package es.usj.zaragozatricks.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import es.usj.zaragozatricks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class UniversidadFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    public UniversidadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_universidad, container, false);

        SupportMapFragment mapFragment = SupportMapFragment.newInstance( );

        mapFragment.getMapAsync(this);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.map_university,mapFragment).commit();

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng usj = new LatLng(41.7562122, -0.8339308);
        mMap.addMarker(new MarkerOptions().position(usj).title("San Jorge"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(usj));
    }
}
