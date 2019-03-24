package es.usj.zaragozatricks.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import es.usj.zaragozatricks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NIEFragment extends Fragment {


    public NIEFragment() {
        // Required empty public constructor
    }


    Button btn1, btn2, btn3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_nie, container, false);

        btn1 = v.findViewById(R.id.btn1);
        btn2 = v.findViewById(R.id.btn2);
        btn3 = v.findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String url = "http://extranjeros.mitramiss.gob.es/es/ModelosSolicitudes/Mod_solicitudes2/17-Formulario_TIE.pdf";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String url = "http://extranjeros.mitramiss.gob.es/es/ModelosSolicitudes/Mod_solicitudes2/15-Formulario_NIE_y_certificados.pdf";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String url = "https://www.zaragoza.es/sede/portal/tramites-servicios/cita-previa";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

      return v;



    }

}
