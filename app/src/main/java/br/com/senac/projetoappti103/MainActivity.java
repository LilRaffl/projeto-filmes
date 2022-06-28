package br.com.senac.projetoappti103;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declara as variaveis globais  referencia os componentes
    ListView lstFilmes;

    //Criando os dados para lista
    String titulo[] = {"Badboys", "Contractor", "Fast&furios", "Ghostbusters", "IT", "jumanji",
            "madagascar", "Shrek 2", "The tomorrow"};

    String ano[] = {"2020", "2022", "2001", "2021", "2019", "2019", "2001", "2012", "2001"};

    String classificacao[] = {"18 anos ou mais", "18 anos ou mais", "13 anos ou mais ", "15 anos ou mais", "18 anos ou mais", "12 anos ou mais ", "10anos ou mais ",
            "12 anos ou mais ", "1 ano ou menos"};

    int imgFilmes[] = {R.drawable.Badboys, R.drawable.contractor, R.drawable.fast, R.drawable.ghostbusters, R.drawable.it,
            R.drawable.jumanji, R.drawable.madagascar, R.drawable.shrek2, R.drawable.tomorrow};

    String notas[] = {"102", "151", "157", "124", "135", "1010", "1284", "1051", "15425", "11.222"};

    //declarando o cardview dos filmes


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstFilmes = findViewById(R.id.listaFilmes);
        //instância o adaptador

        MyAdapter adapter = new MyAdapter();
        lstFilmes.setAdapter(adapter);

        lstFilmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MostraFilmesActivity.class);

            intent.putExtra("titulo",titulo[position]);
                intent.putExtra("ano",ano[position]);
                intent.putExtra("classificacao",classificacao[position]);
                intent.putExtra("notas",notas[position]);
                intent.putExtra("imagenFilme",imgFilmes[position]);

                startActivity(intent);




            }
        });


    }

    //criando uma classe interna inner class
    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgFilmes.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageFilmes;
            TextView txtTitulo, txtano, txtclassificacao, txtnotas;

            View view = getLayoutInflater().inflate(R.layout.modelo_filmes, null);

            txtTitulo = view.findViewById(R.id.txtmodeloTitulo);
            txtano = view.findViewById(R.id.txtModeloAno);
            txtnotas = view.findViewById(R.id.txtModeloNotas);
            txtclassificacao = view.findViewById(R.id.modeloclassificacao);
            imageFilmes = view.findViewById(R.id.imgModeloFilme);

            //passando os valores para o componente do modelo
            txtTitulo.setText(titulo[position]);
            txtano.setText(ano[position]);
            txtclassificacao.setText(classificacao[position]);
            txtnotas.setText(notas[position]);

            imageFilmes.setImageResource(imgFilmes[position]);


            return view;
        }
    }
}