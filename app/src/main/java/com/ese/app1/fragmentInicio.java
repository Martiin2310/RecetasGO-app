package com.ese.app1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ese.app1.databinding.FragmentInicioBinding;
import com.ese.app1.recetas.RecetaEnsaladaCesar;
import com.ese.app1.recetas.RecetaFideoSalsa;
import com.ese.app1.recetas.RecetaRisottoChampinones;
import com.ese.app1.recetas.RecetaTacosPollo;

public class fragmentInicio extends Fragment {

    private FragmentInicioBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inicializa el binding
        binding = FragmentInicioBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupCard(binding.FideoSalsa, binding.loremFideo, binding.irFideoSalsa, RecetaFideoSalsa.class);
        setupCard(binding.EnsaladaCesar, binding.loremCesar, binding.irEnsaladaCesar, RecetaEnsaladaCesar.class);
        setupCard(binding.TacosPollo, binding.loremTacos, binding.irTacosPollo, RecetaTacosPollo.class);
        setupCard(binding.RisottoChampinones, binding.loremRisotto, binding.irRisottoChampinones, RecetaRisottoChampinones.class);

        return view;
    }

    private void setupCard(CardView cardView, TextView textView, Button button, Class<?> targetActivity) {
        // Inicialmente, el texto y el botón están ocultos
        textView.setVisibility(View.GONE);
        button.setVisibility(View.GONE);

        cardView.setOnClickListener(v -> {
            if (textView.getVisibility() == View.GONE) {
                // Expandir: mostrar el texto y el botón
                textView.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);

                // Animaciones
                textView.setAlpha(0f);
                textView.animate().alpha(1f).setDuration(300).start();
                button.setAlpha(0f);
                button.animate().alpha(1f).setDuration(300).start();
            } else {
                // Contraer: ocultar el texto y el botón
                textView.animate().alpha(0f).setDuration(300).withEndAction(() -> {
                    textView.setVisibility(View.GONE);
                }).start();
                button.animate().alpha(0f).setDuration(300).withEndAction(() -> {
                    button.setVisibility(View.GONE);
                }).start();
            }
        });

        button.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), targetActivity);
            startActivity(intent);
        });
    }
}
