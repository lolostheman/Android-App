import Checkbox from "expo-checkbox";
import React, { useContext, useState } from "react";

import { Text, View } from "react-native";
// import CheckBox from "@react-native-community/checkbox";
import tailwind from "tailwind-rn";
import { AppContext } from "../../App";

interface IIngredientOption {
    ingredientName: string;
}

export default function AnIngredientOption({
    ingredientName,
}: IIngredientOption) {
    const { selectedIngredients, setSelectedIngredients } =
        useContext(AppContext);

    function toggleCheckbox() {
        if (selectedIngredients.indexOf(ingredientName) !== -1) {
            setSelectedIngredients(
                selectedIngredients.filter((el) => {
                    return el !== ingredientName;
                })
            );
        } else {
            setSelectedIngredients([...selectedIngredients, ingredientName]);
        }
    }

    return (
        <View
            style={tailwind("flex flex-row items-center flex-none mr-2 mb-3")}
        >
            {/* <CheckBox
                disabled={false}
                value={toggleCheckBox}
                onValueChange={(newValue) => setToggleCheckBox(newValue)}
            /> */}
            <Checkbox
                value={selectedIngredients.indexOf(ingredientName) !== -1}
                onValueChange={toggleCheckbox}
                style={tailwind("mr-1")}
            />
            <Text>{ingredientName}</Text>
        </View>
    );
}
