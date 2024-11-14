package com.example.app01;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText n1, n2, n3, n4, rec;
    private TextView result;

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

        n1 = findViewById(R.id.nota1);
        n2 = findViewById(R.id.nota2);
        n3 = findViewById(R.id.nota3);
        n4 = findViewById(R.id.nota4);
        result = findViewById(R.id.resultado);
        rec = findViewById(R.id.rec);
    }

    public void calcularMedia(View v) {
        if (result.getText().equals("Resultado")) {
            String nota1 = n1.getText().toString();
            String nota2 = n2.getText().toString();
            String nota3 = n3.getText().toString();
            String nota4 = n4.getText().toString();
            if (!nota1.isEmpty() && !nota2.isEmpty() && !nota3.isEmpty() && !nota4.isEmpty()) {
                double nn1 = Double.parseDouble(nota1);
                double nn2 = Double.parseDouble(nota2);
                double nn3 = Double.parseDouble(nota3);
                double nn4 = Double.parseDouble(nota4);
                double media = (nn1 + nn2 + nn3 + nn4) / 4;
                result.setText("A Média das notas é: " + media);
                if (media >= 7) {
                    result.setText("Aluno aprovado com média: " + media);
                } else if (media <= 5) {
                    result.setText("Aluno em recuperação com média: " + media);
                    rec.setVisibility(View.VISIBLE);
                } else {
                    result.setText("Aluno reprovado com média: " + media);
                }
            } else {
                result.setText("Preencha todos os campos");
                n1.setHintTextColor(Color.RED);
                n2.setHintTextColor(Color.RED);
                n3.setHintTextColor(Color.RED);
                n4.setHintTextColor(Color.RED);
            }
        } else {
            String notaRec = rec.getText().toString();
            if (!notaRec.isEmpty()) {
                double nnRec = Double.parseDouble(notaRec);
                if (nnRec >= 5) {
                    result.setText("Aluno Aprovado em Recuperação");
                } else {
                    result.setText("Aluno reprovado na recuperação");
                }
            }
        }
    }

public void limpar(View v) {
    n1.setText("");
    n2.setText("");
    n3.setText("");
    n4.setText("");
    result.setText("Resultado");
    rec.setText("");
    rec.setVisibility(View.INVISIBLE);

}
}