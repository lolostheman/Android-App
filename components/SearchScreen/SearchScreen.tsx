import React, { useContext, useEffect, useState } from "react";
import {
    StyleSheet,
    Text,
    View,
    ScrollView,
    TouchableOpacity,
} from "react-native";
import { getStatusBarHeight } from "react-native-status-bar-height";
import tailwind from "tailwind-rn";
import { AppContext } from "../../App";

import ASearchResult, { IASearchResult } from "./ASearchResult";

export default function SearchScreen({ navigation }: any) {
    const { selectedIngredients } = useContext(AppContext);

    const [results, setResults] = useState<Array<IASearchResult>>([]);

    async function fetchRecipes() {
        const res = await fetch(
            `https://api.spoonacular.com/recipes/findByIngredients?ingredients=${parseIngredients()}&apiKey=45ed40dde85343aa89a8d7cec3d4b4d9`
        );
        if (res.status === 200) {
            const resJson = await res.json();

            setResults(parseRecipesRes(resJson));
        }
    }

    function parseIngredients() {
        let ret = "";

        selectedIngredients.forEach((ingredient: string, i: number) => {
            if (ingredient.length === 1) {
                ret += ingredient;
            } else if (i === selectedIngredients.length) {
                ret += ingredient;
            } else {
                ret += `${ingredient},`;
            }
        });

        console.log(ret);
        return ret;
    }

    function parseRecipesRes(resJson: Array<any>) {
        const ret: Array<IASearchResult> = [];

        console.log(resJson[0]);
        resJson.forEach((recipe: any) => {
            ret.push({
                recipeId: recipe.id,
                image: recipe.image,
                missedIngredientCount: recipe.missedIngredientCount,
                title: recipe.title,
                likes: recipe.likes,
            } as IASearchResult);
        });

        return ret;
    }

    useEffect(() => {
        fetchRecipes();
    }, []);

    return (
        <View style={styles.container}>
            <View
                style={tailwind(
                    "mb-3 w-full flex flex-row justify-between items-center"
                )}
            >
                <TouchableOpacity onPress={() => navigation.navigate("Home")}>
                    <Text style={tailwind("font-black")}>Return</Text>
                </TouchableOpacity>
                <Text style={tailwind("text-3xl font-black")}>
                    Search Results
                </Text>
            </View>

            <ScrollView style={tailwind("flex flex-col w-full flex-1")}>
                {results.map((recipe: IASearchResult) => {
                    return (
                        <ASearchResult
                            key={recipe.recipeId}
                            title={recipe.title}
                            recipeId={recipe.recipeId}
                            likes={recipe.likes}
                            image={recipe.image}
                            missedIngredientCount={recipe.missedIngredientCount}
                            navigation={navigation}
                        />
                    );
                })}
            </ScrollView>
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
