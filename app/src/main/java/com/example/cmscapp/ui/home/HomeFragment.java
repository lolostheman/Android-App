package com.example.cmscapp.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cmscapp.R;
import com.example.cmscapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Boolean[] isMenuOpen = new Boolean[]{false, false, false, false, false, false};

        String[] itemCategories = getResources().getStringArray(R.array.item_categories);

        final Button dairyButton = binding.dairyButton;
        final Button bakingButton = binding.bakingButton;
        final Button vegetablesButton = binding.vegetablesButton;
        final Button fruitButton = binding.fruitButton;
        final Button meatButton = binding.meatButton;
        final Button fishButton = binding.fishButton;

        final ConstraintLayout dairyDropContainer = binding.dairyDropContainer;
        final ConstraintLayout bakingDropContainer = binding.bakingDropContainer;
        final ConstraintLayout vegetablesDropContainer = binding.vegetablesDropContainer;
        final ConstraintLayout fruitDropContainer = binding.fruitDropContainer;
        final ConstraintLayout meatDropContainer = binding.meatDropContainer;
        final ConstraintLayout fishDropContainer = binding.fishDropContainer;

        dairyButton.setText(itemCategories[0]);
        bakingButton.setText(itemCategories[1]);
        vegetablesButton.setText(itemCategories[2]);
        fruitButton.setText(itemCategories[3]);
        meatButton.setText(itemCategories[4]);
        fishButton.setText(itemCategories[5]);

        dairyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMenuOpen[0] = toggleDropDown(dairyDropContainer, 0, isMenuOpen);
            }
        });

        bakingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMenuOpen[1] = toggleDropDown(bakingDropContainer, 1, isMenuOpen);
            }
        });

        vegetablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMenuOpen[2] = toggleDropDown(vegetablesDropContainer, 2, isMenuOpen);
            }
        });

        fruitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMenuOpen[3] = toggleDropDown(fruitDropContainer, 3, isMenuOpen);
            }
        });

        meatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMenuOpen[4] = toggleDropDown(meatDropContainer, 4, isMenuOpen);
            }
        });

        fishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMenuOpen[5] = toggleDropDown(fishDropContainer, 5, isMenuOpen);
            }
        });


        return root;
    }

    public Boolean toggleDropDown(ConstraintLayout container, int containerIndex, Boolean[] isMenuOpen) {
            container.setBackgroundColor(Color.parseColor("#c196ff"));
            if(isMenuOpen[containerIndex]) {
                container.setVisibility(View.GONE);
                container.setMaxHeight(0);
                container.setMinHeight(0);
                return false;
            } else {
                container.setVisibility(View.VISIBLE);
                container.setMaxHeight(250);
                container.setMinHeight(250);
                return true;
            }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}