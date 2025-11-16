package com.appvenda;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.appvenda.adapter.JoiasAdapter;
import com.appvenda.adapter.PromocoesAdapter;
import com.appvenda.databinding.ActivityMainBinding;
import com.appvenda.model.Joia;
import com.appvenda.util.MockData;
import com.google.android.material.navigation.NavigationView;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JoiasAdapter.OnJoiaClickListener {

    private ActivityMainBinding binding;
    private JoiasAdapter joiasAdapter;
    private PromocoesAdapter promocoesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.iconMenu.setOnClickListener(v -> {
            binding.drawerLayout.openDrawer(GravityCompat.END);
        });

        binding.iconCarrinho.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, CarrinhoActivity.class));
        });

        setupPromocoesRecyclerView();
        setupJoiasRecyclerView();
    }

    private void setupPromocoesRecyclerView() {
        List<Joia> promocoes = MockData.getPromocoes();
        promocoesAdapter = new PromocoesAdapter(promocoes);
        binding.recyclerViewPromocoes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerViewPromocoes.setAdapter(promocoesAdapter);
    }

    private void setupJoiasRecyclerView() {
        List<Joia> joias = MockData.getJoias();
        joiasAdapter = new JoiasAdapter(joias, this);
        binding.recyclerViewJoias.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recyclerViewJoias.setAdapter(joiasAdapter);
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
            binding.drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onJoiaClick(Joia joia) {
        Intent intent = new Intent(this, DetalheJoiaActivity.class);
        intent.putExtra("JOIA_EXTRA", joia);
        startActivity(intent);
    }
}