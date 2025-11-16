package com.appvenda.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.appvenda.databinding.ItemCarrinhoBinding;
import com.appvenda.model.Joia;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder> {

    private final List<Joia> itens;
    private final OnCarrinhoInteractionListener listener;
    private final Locale ptBr = new Locale("pt", "BR");
    private final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(ptBr);

    public interface OnCarrinhoInteractionListener {
        void onQuantidadeChange(Joia joia, int novaQuantidade);
        void onItemSelectedChange(boolean isSelected);
    }

    public CarrinhoAdapter(List<Joia> itens, OnCarrinhoInteractionListener listener) {
        this.itens = itens;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CarrinhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemCarrinhoBinding binding = ItemCarrinhoBinding.inflate(inflater, parent, false);
        return new CarrinhoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CarrinhoViewHolder holder, int position) {
        Joia joia = itens.get(position);
        holder.bind(joia, listener, currencyFormat);
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    static class CarrinhoViewHolder extends RecyclerView.ViewHolder {
        private final ItemCarrinhoBinding binding;

        public CarrinhoViewHolder(ItemCarrinhoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(final Joia joia, final OnCarrinhoInteractionListener listener, final NumberFormat currencyFormat) {
            binding.tvNomeItem.setText(joia.getNome());
            binding.tvValorItem.setText(currencyFormat.format(joia.getValor()));
            binding.tvTamanhoItem.setText("Tamanho: " + joia.getTamanho());
            binding.tvQuantidade.setText(String.valueOf(joia.getQuantidade()));
            binding.imgItemCarrinho.setImageResource(joia.getImagemResourceId());

            binding.checkboxSelecionar.setChecked(true);

            binding.btnAumentar.setOnClickListener(v -> {
                int novaQtde = joia.getQuantidade() + 1;
                binding.tvQuantidade.setText(String.valueOf(novaQtde));
                listener.onQuantidadeChange(joia, novaQtde);
            });

            binding.btnDiminuir.setOnClickListener(v -> {
                int novaQtde = joia.getQuantidade() - 1;
                binding.tvQuantidade.setText(String.valueOf(novaQtde));
                listener.onQuantidadeChange(joia, novaQtde);
            });

            // Listener do Checkbox
            binding.checkboxSelecionar.setOnCheckedChangeListener((buttonView, isChecked) -> {
                listener.onItemSelectedChange(isChecked);
            });
        }
    }
}