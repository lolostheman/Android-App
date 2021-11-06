package com.example.cmscapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cmscapp.R;
import com.example.cmscapp.ResultsActivity;
import com.example.cmscapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private Button button;
    public static ArrayList<String> checkedIngredients = new ArrayList<String>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

       // View view = inflater.inflate(R.layout.fragment_home, container, false);
       // button = view.findViewById(R.id.fragement_fragement_home_button)
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
        //Fruits
        final CheckBox checkBoxApples = binding.checkBoxApples;
        final CheckBox checkBoxApricots = binding.checkBoxApricots;
        final CheckBox checkBoxBananas = binding.checkBoxBananas;
        final CheckBox checkBoxPineapple = binding.checkBoxPineapple;
        final CheckBox checkBoxPeaches = binding.checkBoxPeaches;
        final CheckBox checkBoxPlums = binding.checkBoxPlums;
        final CheckBox checkBoxPears = binding.checkBoxPears;
        //Meat
        final CheckBox checkBoxChicken = binding.checkBoxChicken;
        final CheckBox checkBoxPork = binding.checkBoxPork;
        final CheckBox checkBoxBeef = binding.checkBoxBeef;
        final CheckBox checkBoxLamb = binding.checkBoxLamb;
        final CheckBox checkBoxGoat = binding.checkBoxGoat;
        final CheckBox checkBoxTurkey = binding.checkBoxTurkey;
        final CheckBox checkBoxBrisket = binding.checkBoxBrisket;
        //Fish
        final CheckBox checkBoxHaddock = binding.checkBoxHaddock;
        final CheckBox checkBoxCod = binding.checkBoxCod;
        final CheckBox checkBoxSeaBass = binding.checkBoxSeaBass;
        final CheckBox checkBoxTuna = binding.checkBoxTuna;
        final CheckBox checkBoxSalmon = binding.checkBoxSalmon;
        final CheckBox checkBoxCrab = binding.checkBoxCrab;
        final CheckBox checkBoxLobster = binding.checkBoxLobster;
        final CheckBox checkBoxScallops = binding.checkBoxScallops;
        //Vegetables
        final CheckBox checkBoxTomatoes = binding.checkBoxTomatoes;
        final CheckBox checkBoxOnions = binding.checkBoxOnions;
        final CheckBox checkBoxCucumbers = binding.checkBoxCucumbers;
        final CheckBox checkBoxCarrots = binding.checkBoxCarrots;
        final CheckBox checkBoxSpinach = binding.checkBoxSpinach;
        final CheckBox checkBoxGarlic = binding.checkBoxGarlic;
        final CheckBox checkBoxPeppers = binding.checkBoxPeppers;
        final CheckBox checkBoxMushrooms = binding.checkBoxMushrooms;
        //Baking
        final CheckBox checkBoxFlour = binding.checkBoxFlour;
        final CheckBox checkBoxBakingSoda = binding.checkBoxBakingSoda;
        final CheckBox checkBoxSugar = binding.checkBoxSugar;
        final CheckBox checkBoxCinamon = binding.checkBoxCinamon;
        final CheckBox checkBoxChocolates = binding.checkBoxChocolates;
        final CheckBox checkBoxBakingPowder = binding.checkBoxBakingPowder;
        final CheckBox checkBoxYeast = binding.checkBoxYeast;
        final CheckBox checkBoxMolasses = binding.checkBoxMolasses;
        //Dairy
        final CheckBox checkBoxMilk = binding.checkBoxMilk;
        final CheckBox checkBoxIceCream = binding.checkBoxIceCream;
        final CheckBox checkBoxCheese = binding.checkBoxCheese;
        final CheckBox checkBoxYogurt = binding.checkBoxYogurt;
        final CheckBox checkBoxCream = binding.checkBoxCream;
        final CheckBox checkBoxCreamCheese = binding.checkBoxCreamCheese;
        final CheckBox checkBoxButter = binding.checkBoxButter;
        final CheckBox checkBoxEggs = binding.checkBoxEggs;
        final CheckBox checkBoxWhey = binding.checkBoxWhey;
        final CheckBox checkBoxWhippedCream = binding.checkBoxWhippedCream;








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


//        button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                openResultsActivity();
//            }
//        });


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


        checkBoxApples.setOnClickListener(new View.OnClickListener()
        {@Override
            public void onClick (View view){
                boolean checked = ((CheckBox) view).isChecked();
                // Check which checkbox was clicked
                if (checked) {
                    checkedIngredients.add("apples");
                }else{
                    checkedIngredients.remove("apples");
                }
                }});

        checkBoxBananas.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("bananas");
            }else{
                checkedIngredients.remove("bananas");
            }
            }});
        checkBoxApricots.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("apricots");
            }else{
                checkedIngredients.remove("apricots");

            }}});
        checkBoxPineapple.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("pineapple");
            }else{
                checkedIngredients.remove("pineapple");
            }}});
        checkBoxPeaches.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("peaches");
            }else{
                checkedIngredients.remove("peaches");
            }}});
        checkBoxPlums.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("plums");
            }else{
                checkedIngredients.remove("plums");
            }}});
        checkBoxPears.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("pears");
            }else{
                checkedIngredients.remove("pears");
            }}});
        checkBoxChicken.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("chicken");
            }else{
                checkedIngredients.remove("chicken");
            }}});
        checkBoxPork.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("pork");
            }else{
                checkedIngredients.remove("pork");
            }}});
        checkBoxBeef.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("beef");
            }else{
                checkedIngredients.remove("beef");
            }}});
        checkBoxLamb.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("lamb");
            }else{
                checkedIngredients.remove("lamb");
            }}});
        checkBoxGoat.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("goat");
            }else{
                checkedIngredients.remove("goat");
            }}});
        checkBoxTurkey.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("turkey");
            }else{
                checkedIngredients.remove("turkey");
            }}});
        checkBoxBrisket.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("brisket");
            }else{
                checkedIngredients.remove("brisket");
            }}});
        checkBoxHaddock.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("haddock");
            }else{
                checkedIngredients.remove("haddock");
            }}});
        checkBoxCod.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("Cod");
            }else{
                checkedIngredients.remove("Cod");
            }}});
        checkBoxSeaBass.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("sea bass");
            }else{
                checkedIngredients.remove("sea bass");
            }}});
        checkBoxTuna.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("Tuna");
            }else{
                checkedIngredients.remove("Tuna");
            }}});
        checkBoxSalmon.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("salmon");
            }else{
                checkedIngredients.remove("salmon");
            }}});
        checkBoxCrab.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("crab");
            }else{
                checkedIngredients.remove("crab");
            }}});
        checkBoxLobster.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("lobster");
            }else{
                checkedIngredients.remove("lobster");
            }}});
        checkBoxTomatoes.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("tomatoes");
            }else{
                checkedIngredients.remove("tomatoes");
            }}});
        checkBoxOnions.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("onions");
            }else{
                checkedIngredients.remove("onions");
            }}});
        checkBoxCucumbers.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("cucumbers");
            }else{
                checkedIngredients.remove("cucumbers");
            }}});
        checkBoxCarrots.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("carrots");
            }else{
                checkedIngredients.remove("carrots");
            }}});
        checkBoxSpinach.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("spinach");
            }else{
                checkedIngredients.remove("spinach");
            }}});
        checkBoxGarlic.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("Garlic");
            }else{
                checkedIngredients.remove("Garlic");
            }}});
        checkBoxPeppers.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("peppers");
            }else{
                checkedIngredients.remove("peppers");
            }}});
        checkBoxMushrooms.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("mushrooms");
            }else{
                checkedIngredients.remove("mushrooms");
            }}});
        checkBoxFlour.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("flour");
            }else{
                checkedIngredients.remove("flour");
            }}});
        checkBoxBakingSoda.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("baking soda");
            }else{
                checkedIngredients.remove("baking soda");
            }}});
        checkBoxSugar.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("sugar");
            }else{
                checkedIngredients.remove("sugar");
            }}});
        checkBoxCinamon.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("cinamon");
            }else{
                checkedIngredients.remove("cinamon");
            }}});
        checkBoxChocolates.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("chocolate");
            }else{
                checkedIngredients.remove("chocolate");
            }}});
        checkBoxBakingPowder.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("baking powder");
            }else{
                checkedIngredients.remove("baking powder");
            }}});
        checkBoxYeast.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("yeast");
            }else{
                checkedIngredients.remove("yeast");
            }}});
        checkBoxMolasses.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("molasses");
            }else{
                checkedIngredients.remove("molasses");
            }}});
        checkBoxMilk.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("milk");
            }else{
                checkedIngredients.remove("milk");
            }}});
        checkBoxIceCream.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("ice cream");
            }else{
                checkedIngredients.remove("ice cream");
            }}});
        checkBoxCheese.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("cheese");
            }else{
                checkedIngredients.remove("cheese");
            }}});
        checkBoxYogurt.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("yogurt");
            }else{
                checkedIngredients.remove("yogurt");
            }}});
        checkBoxCream.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("cream");
            }else{
                checkedIngredients.remove("cream");
            }}});
        checkBoxCreamCheese.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("cream cheese");
            }else{
                checkedIngredients.remove("cream cheese");
            }}});
        checkBoxButter.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("butter");
            }else{
                checkedIngredients.remove("butter");
            }}});
        checkBoxEggs.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("eggs");
            }else{
                checkedIngredients.remove("eggs");
            }}});
        checkBoxWhey.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("whey");
            }else{
                checkedIngredients.remove("whey");
            }}});
        checkBoxWhippedCream.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick (View view){
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            if (checked) {
                checkedIngredients.add("whipped cream");
            }else{
                checkedIngredients.remove("whipped cream");
            }}});








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
                container.setMaxHeight(450);
                container.setMinHeight(450);
                return true;
            }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

//    public void nextPage(View view) {
//        Context context = this.getContext();
//        CharSequence text = "Hello toast!";
//        int duration = Toast.LENGTH_SHORT;
//
//        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
//    }

//    public void openResultsActivity(){
//        Intent intent = new Intent(this, ResultsActivity.class);
//        startActivity(intent);
//    }


}