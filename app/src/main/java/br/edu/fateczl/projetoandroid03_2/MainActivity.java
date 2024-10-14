package br.edu.fateczl.projetoandroid03_2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    /*
     *@author: Rodrigo Fortunato Martins Neves
     */
    private EditText etConsumoMedio;
    private EditText etQuantidadeCombustivel;
    private Button btnCalcular;
    private TextView tvResultado;

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

        etConsumoMedio = findViewById(R.id.etConsumoMedio);
        etQuantidadeCombustivel = findViewById(R.id.etQuantidadeCombustivel);
        btnCalcular=findViewById(R.id.btnCalcular);
        tvResultado=findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(view -> calcular());

    }

    private void calcular(){
        float consumoMedio = Float.parseFloat(etConsumoMedio.getText().toString());
        float quantidadeCombustivel = Float.parseFloat(etQuantidadeCombustivel.getText().toString());

        float autonomiaKm = consumoMedio * quantidadeCombustivel;
        tvResultado.setText(getString(R.string.tvResultado) + (autonomiaKm * 1000));




    }
}