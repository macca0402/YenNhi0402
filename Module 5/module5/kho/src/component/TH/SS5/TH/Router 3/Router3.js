import React from "react";
import {Route, Routes} from "react-router";
import Category from "../Router 2/Category";
import Result from "./Result";
import Color from "./Color";

export default function Router3() {
    return(
        <div>
            <Routes>
                <Route path="/" element={<Color/>}/>
                <Route path="/color" element={<Result/>}/>
            </Routes>
        </div>
    )

}