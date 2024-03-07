import {useState} from "react";

export function Count() {
    const [count1, setCount1] = useState(0);
    const [count2, setCount2] = useState(0);
    const increase = (addAmount) => {
        if (addAmount == 1) {
            setCount1(count1+1);
        } else{
            setCount2(count2+2);
        }

    }

    return (
        <div>
            <h1>
                Count : {count1}
            </h1>
            <br/>
            <button onClick={()=>increase(1)}>Add 1</button>
            <br/>
            <h1>
                Count : {count2}
            </h1>
            <br/>
            <button onClick={()=>increase(2)}>Add 2</button>
        </div>
    )

}