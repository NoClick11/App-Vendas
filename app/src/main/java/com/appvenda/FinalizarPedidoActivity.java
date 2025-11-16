package com.appvenda;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.appvenda.databinding.ActivityFinalizarPedidoBinding;

public class FinalizarPedidoActivity extends AppCompatActivity {

    private ActivityFinalizarPedidoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFinalizarPedidoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarFinalizar.setNavigationOnClickListener(v -> onBackPressed());

        binding.btnFinalizarPedido.setOnClickListener(v -> {
        });
    }
}