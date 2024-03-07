import {Routes, Route, Link} from "react-router-dom"
import {Home} from "./Home";
import {About} from "./About";

export default function App_Routing() {
    return (
        <div className="App">
            <h1>Welcome to react router</h1>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="about" element={<About/>}/>
            </Routes>
        </div>
    )
}



