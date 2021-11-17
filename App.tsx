import { StatusBar } from "expo-status-bar";
import React, { createContext, useState } from "react";

import { ScrollView, StyleSheet, Text, View } from "react-native";
import { getStatusBarHeight } from "react-native-status-bar-height";
import tailwind from "tailwind-rn";
import IngredientTypeDropdown from "./components/PreSearch/IngredientTypeDropdown";

interface IIngredientContext {
    selectedIngredients: Array<string>;
    setSelectedIngredients: Function;
}

export const IngredientContext = createContext({
    selectedIngredients: [],
    setSelectedIngredients: () => {},
} as IIngredientContext);

export default function App() {
    const [selectedIngredients, setSelectedIngredients] = useState([]);

    return (
        <IngredientContext.Provider
            value={{ selectedIngredients, setSelectedIngredients }}
        >
            <StatusBar style="auto" />
            <View style={styles.container}>
                <Text style={tailwind("text-3xl font-black self-start")}>
                    Cook with what you already have!
                </Text>

                <IngredientTypeDropdown ingredientCategory="Dairy" />
            </View>
        </IngredientContext.Provider>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: "#fff",
        alignItems: "center",
        marginTop: getStatusBarHeight(),
        padding: "5%",
        flexDirection: "column",
    },
});
