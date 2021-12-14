import React, { useContext } from "react";
import {
    ScrollView,
    StyleSheet,
    Text,
    TouchableOpacity,
    View,
} from "react-native";
import { getStatusBarHeight } from "react-native-status-bar-height";
import tailwind from "tailwind-rn";
import { AppContext } from "../../App";
import { IngedientCategories } from "../../consts";
import IngredientTypeDropdown from "./IngredientTypeDropdown";

export default function PreSearchScreen({ navigation }: any) {
    const { selectedIngredients, setSelectedIngredients } =
        useContext(AppContext);

    return (
        <View style={styles.container}>
            <View style={tailwind("mb-3")}>
                <Text style={tailwind("text-3xl font-black self-start")}>
                    Cook with what you already have!
                </Text>
            </View>

            <ScrollView style={tailwind("flex-1 w-full flex flex-col")}>
                {IngedientCategories.map((anIngredientCategory: string) => {
                    return (
                        <IngredientTypeDropdown
                            key={anIngredientCategory}
                            ingredientCategory={anIngredientCategory}
                        />
                    );
                })}
            </ScrollView>

            <Text>{selectedIngredients}</Text>

            <View
                style={tailwind(
                    `mb-10 flex items-center justify-center w-full flex-row ${
                        selectedIngredients.length > 0 ? "flex" : "hidden"
                    }`
                )}
            >
                <View style={tailwind("bg-blue-500  flex-1 rounded-lg")}>
                    <TouchableOpacity
                        style={tailwind(
                            "flex justify-center text-center items-center w-full py-3"
                        )}
                        onPress={() => setSelectedIngredients([])}
                    >
                        <Text style={tailwind("font-black text-white text-lg")}>
                            Clear
                        </Text>
                    </TouchableOpacity>
                </View>

                <View style={tailwind("bg-blue-500 flex-1 ml-3 rounded-lg")}>
                    <TouchableOpacity
                        style={tailwind(
                            "flex justify-center text-center items-center w-full py-3"
                        )}
                        onPress={() => navigation.navigate("Search")}
                    >
                        <Text style={tailwind("font-black text-white text-lg")}>
                            Search
                        </Text>
                    </TouchableOpacity>
                </View>
            </View>
        </View>
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
