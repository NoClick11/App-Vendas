package com.appvenda;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.appvenda.adapter.CarrinhoAdapter;
import com.appvenda.databinding.ActivityCarrinhoBinding;
import com.appvenda.model.Joia;
import com.appvenda.util.CarrinhoManager;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CarrinhoActivity extends AppCompatActivity implements CarrinhoAdapter.OnCarrinhoInteractionListener {

    private ActivityCarrinhoBinding binding;
    private CarrinhoAdapter adapter;
    private CarrinhoManager carrinhoManager;
    private final Locale ptBr = new Locale("pt", "BR");
    private final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(ptBr);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarrinhoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        carrinhoManager = CarrinhoManager.getInstance();

        binding.toolbarCarrinho.setNavigationOnClickListener(v -> onBackPressed());

        setupRecyclerView();
        atualizarTotal();

        binding.btnFinalizar.setOnClickListener(v -> {
            startActivity(new Intent(CarrinhoActivity.this, FinalizarPedidoActivity.class));
        });
    }

    private void setupRecyclerView() {
        List<Joia> itens = carrinhoManager.getItensDoCarrinho();
        adapter = new CarrinhoAdapter(itens, this);
        binding.recyclerViewCarrinho.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewCarrinho.setAdapter(adapter);
    }

    private void atualizarTotal() {
        double total = carrinhoManager.getValorTotal();
        binding.tvValorTotal.setText(currencyFormat.format(total));
    }

    @Override
    public void onQuantidadeChange(Joia joia, int novaQuantidade) {
        carrinhoManager.atualizarQuantidade(joia, novaQuantidade);

        if (novaQuantidade <= 0) {
            setupRecyclerView();
        }

        atualizarTotal();
    }

    @Override
    public void onItemSelectedChange(boolean isSelected) {
        atualizarTotal();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupRecyclerView();
        atualizarTotal();
    }
}