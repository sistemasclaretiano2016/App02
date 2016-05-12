package br.android.app02;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class TelaPrincipal extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    private Spinner spnDadosDinamicos;
    private List<String> listaItens;

    private void carregarDados(){
        listaItens = new ArrayList<>();
        listaItens.add("Ana Maria");
        listaItens.add("Carlos Antônio");
        listaItens.add("João da Silva");
        listaItens.add("José Ferreira");
        listaItens.add("Maria Clara");
        listaItens.add("Mario Faria");
        listaItens.add("Paulo Francisco");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        carregarDados();

        //Associar os dados dinâmicos ao Spinner
        spnDadosDinamicos = (Spinner)findViewById(
                R.id.spnDadosDinamicos);

        ArrayAdapter<String> adpt = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                listaItens
            );
        adpt.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        );

        spnDadosDinamicos.setAdapter(adpt);
        spnDadosDinamicos.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (parent.getId() == R.id.spnDadosDinamicos){

            //Posição do item selecionado no Spinner
            //começando em zero
            int posicao = position;

            //Valor do item na posição selecionada
            //do Spinner
            String valor =
                parent.getItemAtPosition(position).toString();

            //Exibir elemento na Tela
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Spinner");
            dlg.setMessage(
                    "Valor  = " + valor + "\n" +
                    "Posição= " + posicao
            );
            dlg.setPositiveButton("OK",null);
            dlg.show();

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




}
