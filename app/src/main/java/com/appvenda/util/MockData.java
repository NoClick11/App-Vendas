package com.appvenda.util;

import com.appvenda.R;
import com.appvenda.model.Joia;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<Joia> getJoias() {
        List<Joia> lista = new ArrayList<>();
        lista.add(new Joia("001", "Brinco de Ouro", "Brinco de ourou no formato de borboleta", 150.00, "15", R.drawable.joia_1));
        lista.add(new Joia("002", "Brinco Coração", "Brinco com formato de coração folheado a ouro.", 850.00, "45cm", R.drawable.joia_2));
        lista.add(new Joia("003", "Brinco Espiral", "Brinco em formato esperial folheado a ouro", 220.00, "Médio", R.drawable.joia_3));
        lista.add(new Joia("004", "Brinco Coração Duplo", "Brinco em formato de um coração cortado ao meio folheado a ouro", 180.00, "20cm", R.drawable.joia_4));
        lista.add(new Joia("005", "Brinco Borboleta", "Brinco em formato de borboleta folheado a ouro   ", 120.00, "18", R.drawable.joia_6));
        lista.add(new Joia("006", "Brinco Folha", "Brinco em formato de folha folheado a ouro", 90.00, "25cm", R.drawable.joia_7));
        return lista;
    }
    public static List<Joia> getPromocoes() {
        List<Joia> lista = new ArrayList<>();
        lista.add(new Joia("001", "Conjunto Brincos", "Conjunto de brincos ouro e prata", 150.00, "15", R.drawable.joia_5));
        lista.add(new Joia("003", "Brincos Coração", "Brinco em formato de coração .", 220.00, "Médio", R.drawable.joia_14));
        lista.add(new Joia("005", "Pulseira De Ouro", "Pulseira com detalhes de flores pretas", 120.00, "18", R.drawable.joia_11));
        return lista;
    }
}