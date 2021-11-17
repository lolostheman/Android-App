import React, { useState } from "react";

import { Text, View } from "react-native";
import CheckBox from "@react-native-community/checkbox";
import tailwind from "tailwind-rn";

interface IIngredientOption {
    ingredientName: string;
}

export default function AnIngredientOption({
    ingredientName,
}: IIngredientOption) {
    const [toggleCheckBox, setToggleCheckBox] = useState(false);

    return (
        <View style={tailwind("flex items-center")}>
            <CheckBox
                disabled={false}
                value={toggleCheckBox}
                onValueChange={(newValue) => setToggleCheckBox(newValue)}
            />
            <Text>{ingredientName}</Text>
        </View>
    );
}
