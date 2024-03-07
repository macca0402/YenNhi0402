import {useEffect, useState} from "react";

export function Effect(){
    const [count,setCount]=useState(0);
    // Tượng tự như componentDidMount và componentDidUpdate:
    useEffect(()=>{
        // Cập nhập document title sử dụng browser API
        document.title="You click ${count} times";
    })
    return(
        <div>
            <p>You clicked {count} times </p>
            <button onClick={()=>{setCount(count+1)}}>
                Click me
            </button>
        </div>
    )
}