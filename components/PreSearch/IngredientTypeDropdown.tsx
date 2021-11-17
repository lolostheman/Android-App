import React, { useState } from "react";

import { View } from "react-native";
import tailwind from "tailwind-rn";
import AnIngredientOption from "./AnIngredientOption";

interface IIngredientTypeDropdown {
    ingredientCategory: string;
}

export default function IngredientTypeDropdown({
    ingredientCategory,
}: IIngredientTypeDropdown) {
    const [isOpen, setIsOpen] = useState(false);

    return (
        <View style={tailwind("flex flex-col")}>
            <AnIngredientOption ingredientName="ice cream" />
        </View>
    );
}
