package es.usj.zaragozatricks.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import es.usj.zaragozatricks.R;
import es.usj.zaragozatricks.UtilsHelper;
import es.usj.zaragozatricks.models.Carrera;
import es.usj.zaragozatricks.models.Universidad;

public class Register extends Activity implements AdapterView.OnItemSelectedListener {

    private SharedPreferences preferences;
    private EditText mNombre;
    private Button mEnter;
    private EditText txtDate;
    private ArrayList<String> mProfile;
    private Context ctx;
    private Spinner sp_Universidad, spPais, spCarrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mNombre = findViewById(R.id.editText4);
        txtDate = findViewById(R.id.txtDate);
        mEnter = findViewById(R.id.enter);
        ctx = this;


        ArrayList<Carrera> listaCarreraUni_1 = new ArrayList<Carrera>();
        listaCarreraUni_1.add((new Carrera("Ingieneria de Software")));
        listaCarreraUni_1.add((new Carrera("Enfermeria")));

        ArrayList<Carrera> listaCarreraUni_2 = new ArrayList<Carrera>();
        listaCarreraUni_2.add((new Carrera("Ingieneria de Civil")));
        listaCarreraUni_2.add((new Carrera("Albanil")));

        Universidad universidad_1 = new Universidad("Universidad San Jorge",listaCarreraUni_1);
        Universidad universidad_2 = new Universidad("Universidad de Zaragoza", listaCarreraUni_2);

        ArrayList<Universidad> listUniversidad = new ArrayList<Universidad>();
        listUniversidad.add(universidad_1);
        listUniversidad.add(universidad_2);


        sp_Universidad = findViewById(R.id.sp_Universidad);
        ArrayAdapter<Universidad> adapter = new ArrayAdapter<Universidad>(ctx, android.R.layout.simple_spinner_dropdown_item,listUniversidad);
        sp_Universidad.setAdapter(adapter);
        sp_Universidad.setOnItemSelectedListener(this);

        spPais = findViewById(R.id.spPais);
        ArrayAdapter<CharSequence> adapterPaises = ArrayAdapter.createFromResource(this,R.array.Paises, android.R.layout.simple_spinner_item);
        adapterPaises.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPais.setAdapter(adapterPaises);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProfile = new ArrayList<String>();
                mProfile.add(mNombre.getText().toString());
                mProfile.add(txtDate.getText().toString());
                mProfile.add(sp_Universidad.getSelectedItem().toString());
                mProfile.add(spPais.getSelectedItem().toString());
                UtilsHelper.setProfileInfo("profileInfo",ctx,mProfile);
                Intent i = new Intent(ctx,MainActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
