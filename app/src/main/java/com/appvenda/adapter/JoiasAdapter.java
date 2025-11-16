package com.appvenda.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.appvenda.databinding.ItemJoiaBinding;
import com.appvenda.model.Joia;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class JoiasAdapter extends RecyclerView.Adapter<JoiasAdapter.JoiaViewHolder> {

    private final List<Joia> joias;
    private final OnJoiaClickListener clickListener;

    // Interface para o clique
    public interface OnJoiaClickListener {
        void onJoiaClick(Joia joia);
    }

    public JoiasAdapter(List<Joia> joias, OnJoiaClickListener clickListener) {
        this.joias = joias;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public JoiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Usa o ViewBinding para inflar o layout do item
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemJoiaBinding binding = ItemJoiaBinding.inflate(inflater, parent, false);
        return new JoiaViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull JoiaViewHolder holder, int position) {
        Joia joia = joias.get(position);
        holder.bind(joia, clickListener);
    }

    @Override
    public int getItemCount() {
        return joias.size();
    }

    // ViewHolder
    static class JoiaViewHolder extends RecyclerView.ViewHolder {
        private final ItemJoiaBinding binding;
        private final Locale ptBr = new Locale("pt", "BR");
        private final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(ptBr);

        public JoiaViewHolder(ItemJoiaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(final Joia joia, final OnJoiaClickListener clickListener) {
            binding.tvNomeJoia.setText(joia.getNome());
            binding.tvPrecoJoia.setText(currencyFormat.format(joia.getValor()));
            binding.imgJoia.setImageResource(joia.getImagemResourceId());

            // Define o clique no item inteiro
            itemView.setOnClickListener(v -> clickListener.onJoiaClick(joia));
        }
    }
}