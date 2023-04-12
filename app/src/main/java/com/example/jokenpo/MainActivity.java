package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }
    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }
    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoUsuario) {

        ImageView imageExibicao = findViewById(R.id.imageExibicao);
        TextView textExibicao = findViewById(R.id.textExibicao);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "Pedra" :
                imageExibicao.setImageResource(R.drawable.pedra);
                break;
            case "Papel" :
                imageExibicao.setImageResource(R.drawable.papel);
                break;
            case "Tesoura" :
                imageExibicao.setImageResource(R.drawable.tesoura);
                break;
        }

        if( //App vence ->
                opcaoApp == "Pedra" && opcaoUsuario == "Tesoura" ||
                opcaoApp == "Papel" && opcaoUsuario == "Pedra" ||
                opcaoApp == "Tesoura" && opcaoUsuario == "Papel"
        ) {
            textExibicao.setText("Você perdeu :(");
        } else if ( //Usuario vence ->
                opcaoUsuario == "Pedra" && opcaoApp == "Tesoura" ||
                opcaoUsuario == "Papel" && opcaoApp == "Pedra" ||
                opcaoUsuario == "Tesoura" && opcaoApp == "Papel"
        ) {
            textExibicao.setText("Você ganhou :)");
        } else {
            textExibicao.setText("Empatamos ;)");
        }

    }

}