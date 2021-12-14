import { LinearGradient } from "expo-linear-gradient";
import React, { useState } from "react";

import { useEffect } from "react";
import {
    Image,
    Linking,
    ScrollView,
    StyleSheet,
    Text,
    TouchableOpacity,
    View,
} from "react-native";
import { getStatusBarHeight } from "react-native-status-bar-height";
import tailwind from "tailwind-rn";

import HTML from "react-native-render-html";

interface IRecipeInfo {
    title: string;
    image: string;
    likes: number;
    summary: string;
    readyInMinutes: number;
    sourceUrl: string;
}

export default function ARecipeScreen({ route, navigation }: any) {
    const { recipeId } = route.params;

    const [recipeInfo, setRecipeInfo] = useState<IRecipeInfo | null>(null);

    async function fetchFullRecipe() {
        const res = await fetch(
            `https://api.spoonacular.com/recipes/${recipeId}/information?apiKey=45ed40dde85343aa89a8d7cec3d4b4d9`
        );

        if (res.status === 200) {
            const resData = await res.json();

            console.log(resData);

            setRecipeInfo({
                image: resData.image,
                title: resData.title,
                likes: resData.aggregateLikes,
                summary: resData.summary,
                readyInMinutes: resData.readyInMinutes,
                sourceUrl: resData.sourceUrl,
            });
        }
    }

    useEffect(() => {
        if (recipeId) {
            fetchFullRecipe();
        }
    }, []);

    return (
        <View style={styles.container}>
            <ScrollView>
                <View
                    style={tailwind(
                        "mb-3 w-full flex flex-row justify-between items-center"
                    )}
                >
                    <TouchableOpacity
                        onPress={() => navigation.navigate("Search")}
                    >
                        <Text style={tailwind("font-black")}>Return</Text>
                    </TouchableOpacity>
                </View>
                {recipeInfo && (
                    <>
                        <TouchableOpacity
                            style={tailwind(
                                "w-full h-60 mb-5 bg-red-300 rounded-lg overflow-hidden"
                            )}
                            onPress={() => {
                                Linking.openURL(recipeInfo.sourceUrl);
                            }}
                        >
                            <Image
                                source={{ uri: recipeInfo.image }}
                                style={tailwind("w-full h-full")}
                            />

                            <LinearGradient
                                // Background Linear Gradient
                                colors={["transparent", "rgba(0,0,0,1)"]}
                                style={tailwind(
                                    "absolute bottom-0 left-0 w-full h-1/2 flex items-end flex-row p-2 justify-between"
                                )}
                            >
                                <View
                                    style={tailwind(
                                        "flex flex-col items-start flex-1"
                                    )}
                                >
                                    <Text
                                        style={tailwind(
                                            "text-white font-black text-xl"
                                        )}
                                    >
                                        {recipeInfo.title}
                                    </Text>
                                    <Text
                                        style={tailwind(
                                            "text-green-400 font-black"
                                        )}
                                    >
                                        Ready in {recipeInfo.readyInMinutes}{" "}
                                        {recipeInfo.readyInMinutes === 1
                                            ? "minute"
                                            : "minutes"}
                                    </Text>
                                </View>
                                <View style={tailwind("mb-2")}>
                                    <Text
                                        style={tailwind(
                                            "text-white font-black"
                                        )}
                                    >
                                        {recipeInfo.likes}{" "}
                                        {recipeInfo.likes === 1
                                            ? "like"
                                            : "likes"}
                                    </Text>
                                </View>
                            </LinearGradient>
                        </TouchableOpacity>

                        <Text style={tailwind("font-black text-2xl")}>
                            Summary
                        </Text>
                        <HTML
                            source={{ html: `<p>${recipeInfo.summary}</p>` }}
                        />
                    </>
                )}
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
