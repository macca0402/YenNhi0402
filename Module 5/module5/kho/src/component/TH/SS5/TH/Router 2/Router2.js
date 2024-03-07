import React from "react";
import {Route, Routes} from "react-router";
import Category from "./Category";
import Product from "./Product";

export default function Router2() {
    return(
        <Routes>
            <Route path="/" element={<Category/>}/>
            <Route path="/product/:id" element={<Product/>}/>
        </Routes>
    )

}