import {useParams} from "react-router";
import React from "react";

export default function Product() {
    let {id}=useParams();
    return(
        <div>
            <h3>
                Id selected {id}
            </h3>
        </div>
    )
}