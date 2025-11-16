package com.appvenda.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.appvenda.databinding.ItemPromocaoBinding;
import com.appvenda.model.Joia;
import java.util.List;

public class PromocoesAdapter extends RecyclerView.Adapter<PromocoesAdapter.PromocaoViewHolder> {

    private final List<Joia> promocoes;

    public PromocoesAdapter(List<Joia> promocoes) {
        this.promocoes = promocoes;
    }

    @NonNull
    @Override
    public PromocaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPromocaoBinding binding = ItemPromocaoBinding.inflate(inflater, parent, false);
        return new PromocaoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PromocaoViewHolder holder, int position) {
        Joia joia = promocoes.get(position);
        holder.bind(joia);
    }

    @Override
    public int getItemCount() {
        return promocoes.size();
    }

    static class PromocaoViewHolder extends RecyclerView.ViewHolder {
        private final ItemPromocaoBinding binding;

        public PromocaoViewHolder(ItemPromocaoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Joia joia) {
            binding.imgPromocao.setImageResource(joia.getImagemResourceId());

        }
    }
}