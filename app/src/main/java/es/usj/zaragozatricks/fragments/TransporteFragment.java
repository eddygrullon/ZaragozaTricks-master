package es.usj.zaragozatricks.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import es.usj.zaragozatricks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TransporteFragment extends Fragment {


    public TransporteFragment() {
        // Required empty public constructor
    }

    WebView wbTransporte;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_transporte, container, false);
        wbTransporte = v.findViewById(R.id.wbTransporte);



        wbTransporte.setWebViewClient(new WebViewClient());
        wbTransporte.getSettings().setJavaScriptEnabled(true);
        wbTransporte.getSettings().setDomStorageEnabled(true);
        wbTransporte.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        wbTransporte.loadUrl("https://www.usj.es/appcrue/transporte");

        return v;
    }



}
