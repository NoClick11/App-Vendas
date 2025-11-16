package com.appvenda;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.appvenda.databinding.ActivityDetalheJoiaBinding;

public class DetalheJoiaActivity extends AppCompatActivity {

    private ActivityDetalheJoiaBinding binding;
    private boolean isDescricaoExpandida = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalheJoiaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarDetalhe.setNavigationOnClickListener(v -> onBackPressed());

        binding.layoutDescricao.setOnClickListener(v -> toggleDescricao());
        binding.iconArrow.setOnClickListener(v -> toggleDescricao());
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