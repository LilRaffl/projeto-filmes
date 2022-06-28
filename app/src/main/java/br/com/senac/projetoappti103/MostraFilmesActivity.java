package br.com.senac.projetoappti103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MostraFilmesActivity extends AppCompatActivity {

    ImageView imgFilmes;
    TextView txtTitulo,txtAno,txtClassificacao,txtNota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostra_filmes_layout);


        imgFilmes = findViewById(R.id.imgMostrarFilmes);
        txtTitulo = findViewById(R.id.txtAnoMostrarFilmes);
        txtAno = findViewById(R.id.txtAnoMostrarFilmes);
        txtClassificacao = findViewById(R.id.txtClassificacaoMostraFilmes);
        txtNota = findViewById(R.id.txtNotaMostraFilmes);

        Intent  intent = getIntent();

        String titulo = intent.getStringExtra("titulo");
        String ano = intent.getStringExtra("ano");
        String Classificacao = intent.getStringExtra("Classificacao");
        String nota = intent.getStringExtra("nota");
        int imagem = intent.getIntExtra("imagemFilme",0);

        txtTitulo.setText(titulo);
        txtAno.setText(ano);
        txtClassificacao.setText(Classificacao);
        txtNota.setText(nota);
        imgFilmes.setImageResource(imagem);

    }
}