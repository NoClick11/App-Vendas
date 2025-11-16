package com.appvenda;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.appvenda.databinding.ActivityDetalheJoiaBinding;
import com.appvenda.model.Joia;
import com.appvenda.util.CarrinhoManager;
import java.text.NumberFormat;
import java.util.Locale;

public class DetalheJoiaActivity extends AppCompatActivity {

    private ActivityDetalheJoiaBinding binding;
    private boolean isDescricaoExpandida = false;
    private Joia joiaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalheJoiaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        joiaAtual = getIntent().getParcelableExtra("JOIA_EXTRA");

        if (joiaAtual == null) {
            Toast.makeText(this, "Erro ao carregar item.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        popularDados();

        binding.toolbarDetalhe.setNavigationOnClickListener(v -> onBackPressed());

        binding.layoutDescricao.setOnClickListener(v -> toggleDescricao());
        binding.iconArrow.setOnClickListener(v -> toggleDescricao());

        binding.btnAddCarrinho.setOnClickListener(v -> {
            CarrinhoManager.getInstance().adicionarAoCarrinho(joiaAtual);
            Toast.makeText(this, joiaAtual.getNome() + " adicionado ao carrinho!", Toast.LENGTH_SHORT).show();
        });
    }

    private void popularDados() {
        Locale ptBr = new Locale("pt", "BR");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(ptBr);

        binding.imgJoiaDetalhe.setImageResource(joiaAtual.getImagemResourceId());
        binding.tvLegenda.setText(joiaAtual.getNome());
        binding.tvDescricaoCompleta.setText(joiaAtual.getDescricao());

        String textoBotao = "Adicionar ao carrinho (" + currencyFormat.format(joiaAtual.getValor()) + ")";
        binding.btnAddCarrinho.setText(textoBotao);
    }

    private void toggleDescricao() {
        if (isDescricaoExpandida) {
            binding.tvDescricaoCompleta.setVisibility(View.GONE);
            binding.iconArrow.setRotation(0);
        } else {
            binding.tvDescricaoCompleta.setVisibility(View.VISIBLE);
            binding.iconArrow.setRotation(180);
        }
        isDescricaoExpandida = !isDescricaoExpandida;
    }
}