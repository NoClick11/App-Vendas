package com.appvenda;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.appvenda.databinding.ActivityCarrinhoBinding;

public class CarrinhoActivity extends AppCompatActivity {

    private ActivityCarrinhoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarrinhoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarCarrinho.setNavigationOnClickListener(v -> onBackPressed());

        binding.btnFinalizar.setOnClickListener(v -> {
        });
    }
}