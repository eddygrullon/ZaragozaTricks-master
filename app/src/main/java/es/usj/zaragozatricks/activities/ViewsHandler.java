package es.usj.zaragozatricks.activities;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.usj.zaragozatricks.R;
import es.usj.zaragozatricks.fragments.EmpadronarseFragment;
import es.usj.zaragozatricks.fragments.LugaresFragment;
import es.usj.zaragozatricks.fragments.NIEFragment;
import es.usj.zaragozatricks.fragments.TransporteFragment;
import es.usj.zaragozatricks.fragments.UniversidadFragment;


public class ViewsHandler extends AppCompatActivity {

    Button btnback;
    public final int fragment_container = R.id.fragment_container;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        btnback = findViewById(R.id.btn_back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Intent i = getIntent();
        int fragmentID = i.getIntExtra("fragmentID",0);
        title = findViewById(R.id.txtTitle2);
        manageFragment(fragmentID);
    }

    public void manageFragment(int fragment){

        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        switch (fragment){
            case R.layout.fragment_lugares:
                title.setText(getString(R.string.lugares));
                LugaresFragment lugaresFragment = new LugaresFragment();
                fragmentTransaction.add(fragment_container, lugaresFragment);
                break;
            case R.layout.fragment_universidad:
                title.setText(getString(R.string.universidad));
                UniversidadFragment universidadFragment = new UniversidadFragment();
                fragmentTransaction.add(fragment_container, universidadFragment);
                break;
            case R.layout.fragment_transporte:
                title.setText(getString(R.string.transporte));
                TransporteFragment transporteFragment = new TransporteFragment();
                fragmentTransaction.add(fragment_container, transporteFragment);
                break;
            case R.layout.fragment_nie:
                title.setText(getString(R.string.n_i_e));
                NIEFragment nieFragment = new NIEFragment();
                fragmentTransaction.add(fragment_container, nieFragment);
                break;
            case R.layout.fragment_empadronarse:
                title.setText(getString(R.string.empadronarse));
                EmpadronarseFragment empadronarseFragment = new EmpadronarseFragment();
                fragmentTransaction.add(fragment_container, empadronarseFragment);
                break;
        }

        fragmentTransaction.commit();

    }

}
