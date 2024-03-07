import {useEffect, useState} from "react";

export function TimeCountDown() {
    const [time, setTime] = useState(10);
    useEffect(() => {
        const interval =setInterval(() => {
                if (time <= 0) {
                    alert("Time's up");
                    setTime(10);
                } else {
                    setTime(time - 1);
                }
            },1000)
        return ()=>{
            clearInterval(interval);
        }
    },[time])


    return (
        <div>
            <h1>Bắt đầu đếm ngược : {time}</h1>
        </div>
    )

}