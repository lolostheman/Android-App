import { StatusBar } from "expo-status-bar";
import React, { createContext, useState } from "react";

import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import PreSearchScreen from "./components/PreSearchScreen/PreSearchScreen";
import SearchScreen from "./components/SearchScreen/SearchScreen";
import ARecipeScreen from "./components/ARecipeScreen/ARecipeScreen";

interface IAppContext {
    selectedIngredients: Array<string>;
    setSelectedIngredients: Function;
}

export const AppContext = createContext({
    selectedIngredients: [],
    setSelectedIngredients: () => {},
} as IAppContext);

const Stack = createNativeStackNavigator();

export default function App() {
    const [selectedIngredients, setSelectedIngredients] = useState([]);

    return (
        <AppContext.Provider
            value={{ selectedIngredients, setSelectedIngredients }}
        >
            <StatusBar style="auto" />

            <NavigationContainer>
                <Stack.Navigator
                    screenOptions={{
                        headerShown: false,
                    }}
                    initialRouteName="Home"
                >
                    <Stack.Screen name="Home" component={PreSearchScreen} />
                    <Stack.Screen name="Search" component={SearchScreen} />
                    <Stack.Screen name="Recipe" component={ARecipeScreen} />
                </Stack.Navigator>
            </NavigationContainer>
        </AppContext.Provider>
    );
}
