package com.delarue.mediaescolarmvc.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.delarue.mediaescolarmvc.R;
import com.delarue.mediaescolarmvc.model.MediaEscolar;

import java.util.ArrayList;


/**
 * Created by Delarue on 20/09/2019.
 */

public class ResultadoFinalListAdapter
        extends ArrayAdapter<MediaEscolar>
        implements View.OnClickListener {

    // Herdar ArrayAdapter - MediaEscolar
    // Implementar OnClickListener
    // Contexto
    // Classe ViewHolder para os componentes ImageView e TextView
    // Atributo para conhecer a posição no Array - animação
    // Construtor que receba o dataSet
    // onClick do elemento na Lista
    // Devolver via getView linha por linha para o ListView

    Context context;

    private int ultimaPosicao = -1;


    AlertDialog.Builder builder;
    AlertDialog alert;



    private static class ViewHolder {

        TextView txtBimestre;
        TextView txtSituacao;
        TextView txtMateria;
        ImageView imgLogo;

        ImageView imgConsultar;
        ImageView imgEditar;
        ImageView imgDeletar;
        ImageView imgSalvar;

    }

    public ResultadoFinalListAdapter(ArrayList<MediaEscolar> dataSet, Context context) {
        super(context, R.layout.lisview_resultado_final, dataSet);

        ArrayList<MediaEscolar> dados = dataSet;

        this.context = context;
    }

    @Override
    public void onClick(View view) {

        int posicao = (Integer) view.getTag();

        Object object = getItem(posicao);

        MediaEscolar mediaEscolar = (MediaEscolar) object;

        switch (view.getId()) {

            case R.id.imgLogo:

                // Aprensentar os dados detalhados

                Snackbar.make(view, "Nota da Prova " + mediaEscolar.getNotaProva(),
                        Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();

                break;

            case R.id.imgDeletar:

                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Atenção!!!");
                builder.setMessage("Deseja Excluir Este Registro?");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher);

                builder.setPositiveButton("Sim", new Dialog.OnClickListener(){

                    @Override
                    public  void onClick(DialogInterface dialog, int which){

                        // Deletar o Registro

                    }
            });

                builder.setNegativeButton("Cancelar", new Dialog.OnClickListener(){

                    @Override
                    public  void onClick(DialogInterface dialog, int which){

                        // Deletar o Registro

                        dialog.cancel();
                    }
                });

                alert = builder.create();
                alert.show();

                break;

        }
    }

    @NonNull
    @Override
    public View getView(int position,
                        View dataSet,
                        @NonNull ViewGroup parent) {

        MediaEscolar mediaEscolar = getItem(position);

        ViewHolder linha;

        if (dataSet == null) {

            linha = new ViewHolder();

            LayoutInflater layoutResultadoFinalList = LayoutInflater.from(getContext());

            dataSet = layoutResultadoFinalList.inflate(R.layout.lisview_resultado_final,
                    parent,
                    false);

            linha.txtMateria = dataSet.findViewById(R.id.txtMateria);
            linha.txtBimestre = dataSet.findViewById(R.id.txtBimestre);
            linha.txtSituacao = dataSet.findViewById(R.id.txtResultado);
            linha.imgLogo = dataSet.findViewById(R.id.imgLogo);
            linha.imgConsultar = dataSet.findViewById(R.id.imgConsultar);
            linha.imgDeletar = dataSet.findViewById(R.id.imgDeletar);
            linha.imgEditar = dataSet.findViewById(R.id.imgEditar);
            linha.imgSalvar = dataSet.findViewById(R.id.imgSalvar);

            dataSet.setTag(linha);


        }else {

            linha = (ViewHolder) dataSet.getTag();

        }

        linha.txtMateria.setText(mediaEscolar.getMateria());
        linha.txtBimestre.setText(mediaEscolar.getBimestre());
        linha.txtSituacao.setText(mediaEscolar.getSituacao());

        linha.imgLogo.setOnClickListener(this);
        linha.imgLogo.setTag(position);

        linha.imgDeletar.setOnClickListener(this);
        linha.imgDeletar.setTag(position);

        return dataSet;
    }

}
