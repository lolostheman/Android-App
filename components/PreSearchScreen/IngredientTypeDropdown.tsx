import React, { useEffect, useState } from "react";

import { Button, Text, TouchableOpacity, View } from "react-native";
import tailwind from "tailwind-rn";
import { CategoryToIngredients } from "../../consts";
import AnIngredientOption from "./AnIngredientOption";

interface IIngredientTypeDropdown {
    ingredientCategory: string;
}

export default function IngredientTypeDropdown({
    ingredientCategory,
}: IIngredientTypeDropdown) {
    const [isOpen, setIsOpen] = useState(false);

    return (
        <View style={tailwind("flex flex-col w-full mt-3")}>
            <TouchableOpacity
                style={tailwind(
                    "bg-blue-500 w-full text-white flex font-black px-2 py-4 rounded-lg"
                )}
                onPress={() => setIsOpen(!isOpen)}
            >
                <Text style={tailwind("font-black text-white text-xl")}>
                    {ingredientCategory}
                </Text>
            </TouchableOpacity>

            <View
                style={tailwind(
                    `${
                        isOpen ? "flex" : "hidden"
                    } p-2 pt-3 pb-0 mt-2 rounded-lg w-full bg-gray-300 flex-row flex-wrap`
                )}
            >
                {CategoryToIngredients.get(ingredientCategory)?.map(
                    (anIngredient: string) => {
                        return (
                            <AnIngredientOption
                                key={anIngredient}
                                ingredientName={anIngredient}
                            />
                        );
                    }
                )}
            </View>
        </View>
    );
}
