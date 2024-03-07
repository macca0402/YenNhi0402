import {useState} from "react";

export function Car() {
    const [car,setCar]=useState("");
    const [color,setColor]=useState("");
    return(
        <div>
            <h1>Select your car</h1>
            <p>Select a car</p>
            <select onChange={(e)=>{setCar(e.target.value)}}>
                <option value="Mercedes S600">Mercedes S600</option>
                <option value="Toyota Camry">Toyota Camry</option>
                <option value="Ford F-150">Ford F-150</option>
                <option value="Honda Civic">Honda Civic</option>
                <option value="BMW 7 Series">BMW 7 Series</option>
            </select>
            <br/>
            <p>Select a color </p>
            <select onChange={(e)=>{setColor(e.target.value)}}>
                <option value="Black">Black</option>
                <option value="Blue">Blue</option>
                <option value="Yellow">Yellow</option>
                <option value="Red">Red</option>
            </select>
            <br/>
            <h2>you selected a {color} - {car}</h2>

        </div>
    )

}