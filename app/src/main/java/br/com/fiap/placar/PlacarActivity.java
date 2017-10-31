package br.com.fiap.placar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PlacarActivity extends AppCompatActivity {

    private TextView tvTimeA;
    private TextView tvTimeB;
    private TextView tvPlacarA;
    private TextView tvPlacarB;

    private int golA, golB =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placar);

        tvTimeA = (TextView) findViewById(R.id.tvTimeA);
        tvTimeB = (TextView) findViewById(R.id.tvTimeB);
        tvPlacarA = (TextView) findViewById(R.id.tvPlacarA);
        tvPlacarB = (TextView) findViewById(R.id.tvPlacarB);

        if (getIntent()!=null) {
            tvTimeA.setText(getIntent().getStringExtra("CASA"));
            tvTimeB.setText(getIntent().getStringExtra("VISITANTE"));
        }

        if (savedInstanceState != null) {
            golA = savedInstanceState.getInt("GOL_A");
            golB = savedInstanceState.getInt("GOL_B");
        }
        this.tvPlacarA.setText(String.valueOf(golA));
        this.tvPlacarB.setText(String.valueOf(golB));
    }

    public void fazGolA(View v){
        this.golA++;
        tvPlacarA.setText(String.valueOf(this.golA));
        v.refreshDrawableState();
    }

    public void fazGolB(View v){
        this.golB++;
        tvPlacarB.setText(String.valueOf(this.golB));
        v.refreshDrawableState();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("GOL_A", this.golA);
        outState.putInt("GOL_B", this.golB);
    }
}
