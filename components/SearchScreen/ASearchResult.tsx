import { LinearGradient } from "expo-linear-gradient";
import React from "react";

import { Image, Text, TouchableOpacity, View } from "react-native";
import tailwind from "tailwind-rn";

export interface IASearchResult {
    title: string;
    missedIngredientCount: number;
    image: string;
    likes: number;
    recipeId: number;
    navigation: any;
}

export default function ASearchResult({
    title,
    missedIngredientCount,
    image,
    likes,
    recipeId,
    navigation,
}: IASearchResult) {
    return (
        <TouchableOpacity
            style={tailwind(
                "w-full h-60 mb-5 bg-red-300 rounded-lg overflow-hidden"
            )}
            onPress={() =>
                navigation.navigate("Recipe", {
                    recipeId: recipeId,
                })
            }
        >
            <Image source={{ uri: image }} style={tailwind("w-full h-full")} />

            <LinearGradient
                // Background Linear Gradient
                colors={["transparent", "rgba(0,0,0,1)"]}
                style={tailwind(
                    "absolute bottom-0 left-0 w-full h-1/2 flex items-end flex-row p-2 justify-between"
                )}
            >
                <View style={tailwind("flex flex-col items-start flex-1")}>
                    <Text style={tailwind("text-white font-black text-xl")}>
                        {title}
                    </Text>
                    <Text style={tailwind("text-red-400 font-black")}>
                        {missedIngredientCount} missing ingredients
                    </Text>
                </View>
                <View style={tailwind("mb-2")}>
                    <Text style={tailwind("text-white font-black")}>
                        {likes} {likes === 1 ? "like" : "likes"}
                    </Text>
                </View>
            </LinearGradient>
        </TouchableOpacity>
    );
}
