package com.appvenda.util;

import com.appvenda.R;
import com.appvenda.model.Joia;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<Joia> getJoias() {
        List<Joia> lista = new ArrayList<>();
        lista.add(new Joia("001", "Anel de Prata", "Lindo anel de prata 925 com zircônia.", 150.00, "15", R.drawable.ic_placeholder_joia));
        lista.add(new Joia("002", "Colar de Ouro", "Colar 18k com pingente de coração.", 850.00, "45cm", R.drawable.ic_placeholder_joia));
        lista.add(new Joia("003", "Brinco de Pérola", "Brinco clássico de pérola natural.", 220.00, "Médio", R.drawable.ic_placeholder_joia));
        lista.add(new Joia("004", "Pulseira de Couro", "Pulseira masculina de couro e aço.", 180.00, "20cm", R.drawable.ic_placeholder_joia));
        lista.add(new Joia("005", "Anel Solitário", "Anel solitário banhado a ródio.", 120.00, "18", R.drawable.ic_placeholder_joia));
        lista.add(new Joia("006", "Tornozeleira", "Tornozeleira de prata com búzios.", 90.00, "25cm", R.drawable.ic_placeholder_joia));
        return lista;
    }
    public static List<Joia> getPromocoes() {
        List<Joia> lista = new ArrayList<>();
        lista.add(new Joia("001", "Anel de Prata", "Lindo anel de prata 925 com zircônia.", 150.00, "15", R.drawable.ic_placeholder_joia));
        lista.add(new Joia("003", "Brinco de Pérola", "Brinco clássico de pérola natural.", 220.00, "Médio", R.drawable.ic_placeholder_joia));
        lista.add(new Joia("005", "Anel Solitário", "Anel solitário banhado a ródio.", 120.00, "18", R.drawable.ic_placeholder_joia));
        return lista;
    }
}