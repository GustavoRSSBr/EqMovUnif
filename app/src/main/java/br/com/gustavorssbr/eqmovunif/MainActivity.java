package br.com.gustavorssbr.eqmovunif;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etSInicial;
    private EditText etVelocidade;
    private EditText etTempo;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etSInicial = findViewById(R.id.etSInicial);
        etSInicial.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etVelocidade = findViewById(R.id.etVelocidade);
        etVelocidade.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etTempo = findViewById(R.id.etTempo);
        etTempo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> calc());
    }

    private void calc(){
       float sIncial = Float.parseFloat(etSInicial.getText().toString());
       float velocidade = Float.parseFloat(etVelocidade.getText().toString());
       float tempo = Float.parseFloat(etTempo.getText().toString());
       float sFinal = sIncial + velocidade * tempo;

       String res = getString(R.string.s_final) + " " + sFinal + " m";

       tvRes.setText(res);

       etSInicial.setText("");
       etVelocidade.setText("");
       etTempo.setText("");

    }
}