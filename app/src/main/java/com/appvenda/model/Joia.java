package com.appvenda.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.appvenda.R;

public class Joia implements Parcelable {
    private String id;
    private String nome;
    private String descricao;
    private double valor;
    private String tamanho;
    private int imagemResourceId;
    private int quantidade;

    public Joia(String id, String nome, String descricao, double valor, String tamanho, int imagemResourceId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.tamanho = tamanho;
        this.imagemResourceId = imagemResourceId;
        this.quantidade = 1;
    }

    // Getters e Setters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }
    public String getTamanho() { return tamanho; }
    public int getImagemResourceId() { return imagemResourceId; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = (quantidade >= 0) ? quantidade : 0; }

    protected Joia(Parcel in) {
        id = in.readString();
        nome = in.readString();
        descricao = in.readString();
        valor = in.readDouble();
        tamanho = in.readString();
        imagemResourceId = in.readInt();
        quantidade = in.readInt();
    }

    public static final Creator<Joia> CREATOR = new Creator<Joia>() {
        @Override
        public Joia createFromParcel(Parcel in) {
            return new Joia(in);
        }

        @Override
        public Joia[] newArray(int size) {
            return new Joia[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nome);
        dest.writeString(descricao);
        dest.writeDouble(valor);
        dest.writeString(tamanho);
        dest.writeInt(imagemResourceId);
        dest.writeInt(quantidade);
    }
}