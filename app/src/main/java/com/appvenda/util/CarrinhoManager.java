package com.appvenda.util;

import com.appvenda.model.Joia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarrinhoManager {

    private static CarrinhoManager instance;
    private Map<String, Joia> itensDoCarrinho;

    private CarrinhoManager() {
        itensDoCarrinho = new HashMap<>();
    }

    public static synchronized CarrinhoManager getInstance() {
        if (instance == null) {
            instance = new CarrinhoManager();
        }
        return instance;
    }

    public void adicionarAoCarrinho(Joia joia) {
        if (itensDoCarrinho.containsKey(joia.getId())) {
            Joia joiaExistente = itensDoCarrinho.get(joia.getId());
            if (joiaExistente != null) {
                joiaExistente.setQuantidade(joiaExistente.getQuantidade() + 1);
            }
        } else {
            joia.setQuantidade(1);
            itensDoCarrinho.put(joia.getId(), joia);
        }
    }

    public void removerDoCarrinho(Joia joia) {
        itensDoCarrinho.remove(joia.getId());
    }

    public void atualizarQuantidade(Joia joia, int novaQuantidade) {
        if (itensDoCarrinho.containsKey(joia.getId())) {
            if (novaQuantidade <= 0) {
                removerDoCarrinho(joia);
            } else {
                Joia joiaExistente = itensDoCarrinho.get(joia.getId());
                if (joiaExistente != null) {
                    joiaExistente.setQuantidade(novaQuantidade);
                }
            }
        }
    }

    public List<Joia> getItensDoCarrinho() {
        return new ArrayList<>(itensDoCarrinho.values());
    }

    public double getValorTotal() {
        double total = 0.0;
        for (Joia joia : itensDoCarrinho.values()) {
            total += joia.getValor() * joia.getQuantidade();
        }
        return total;
    }

    public void limparCarrinho() {
        itensDoCarrinho.clear();
    }
}