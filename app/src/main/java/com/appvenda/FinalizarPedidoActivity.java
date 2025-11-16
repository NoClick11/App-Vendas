package com.appvenda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.appvenda.databinding.ActivityFinalizarPedidoBinding;
import com.appvenda.util.CarrinhoManager;
import java.text.NumberFormat;
import java.util.Locale;

public class FinalizarPedidoActivity extends AppCompatActivity {

    private ActivityFinalizarPedidoBinding binding;
    private CarrinhoManager carrinhoManager;
    private final Locale ptBr = new Locale("pt", "BR");
    private final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(ptBr);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFinalizarPedidoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        carrinhoManager = CarrinhoManager.getInstance();

        binding.toolbarFinalizar.setNavigationOnClickListener(v -> onBackPressed());

        double total = carrinhoManager.getValorTotal();
        binding.tvValorTotalFinal.setText(currencyFormat.format(total));

        binding.btnFinalizarPedido.setOnClickListener(v -> {
            Toast.makeText(this, "Pedido realizado com sucesso!", Toast.LENGTH_LONG).show();

            carrinhoManager.limparCarrinho();

            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}