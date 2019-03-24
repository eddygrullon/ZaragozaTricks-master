package es.usj.zaragozatricks.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import es.usj.zaragozatricks.R;
import es.usj.zaragozatricks.UtilsHelper;

public class MainActivity extends AppCompatActivity  {

    private CardView cv_empadronarse, cv_nie,cv_transporte, cv_deInteres,cv_universidad,cv_lugares;
    private int fragment_id;
    private TextView mNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNombre = findViewById(R.id.txtSecondTitle);
        cv_empadronarse = findViewById(R.id.cv_empadronarse);
        cv_nie =  findViewById(R.id.cv_nie);
        cv_transporte =  findViewById(R.id.cv_transporte);
        cv_deInteres = findViewById(R.id.cv_deInteres);
        cv_universidad =  findViewById(R.id.cv_universidad);
        cv_lugares = findViewById(R.id.cv_lugares);

       // setProfileData();

        cv_nie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callHandler(R.layout.fragment_nie);
            }
        });

        cv_empadronarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callHandler(R.layout.fragment_empadronarse);

            }
        });
        cv_transporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callHandler(R.layout.fragment_transporte);

            }
        });
        cv_deInteres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //callHandler(R.layout.);

            }
        });
        cv_universidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callHandler(R.layout.fragment_universidad);
            }
        });
        cv_lugares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callHandler(R.layout.fragment_lugares);
            }
        });
    }

    private void callHandler(int fragment){

        Intent intent = new Intent(this, ViewsHandler.class);
        intent.putExtra("fragmentID", fragment);

        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

//    public void setProfileData(){
//        ArrayList<String> profileInfo = UtilsHelper.getProfileInfo(this,"profileInfo");
//        if (profileInfo.get(0) != null)
//            mNombre.setText("Bienvenido "+ profileInfo.get(0) + profileInfo.get(1) + profileInfo.get(2) + profileInfo.get(3));
//        else
//            mNombre.setText("--");
//    }

}
