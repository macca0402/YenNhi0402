import React from "react";
import {Link} from "react-router-dom";
import {Route, Routes} from "react-router";
import About from "./About";
import Contract from "./Contract";
import Home from "./Home";

export default function Router1() {
    return(
        <div>
            <ul>
                <li>
                    <Link to="/">Home</Link>
                </li>
                <li>
                    <Link to="/about">About</Link>
                </li>
                <li>
                    <Link to="/contact">Contact</Link>
                </li>
            </ul>
            <hr/>
            <h1>Home</h1>
            <Routes>
                <Route path="/" element={<Home/>}></Route>
                <Route path="/about" element={<About/>}/>
                <Route path="/contact" element={<Contract/>}></Route>
            </Routes>
        </div>
    )

}