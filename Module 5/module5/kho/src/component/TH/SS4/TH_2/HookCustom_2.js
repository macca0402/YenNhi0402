import {useState} from "react";

function useClock2() {
    const [time, setTime] = useState("");
    const [ampm, setAmpm] = useState("");
    const updateTime = () => {
        let dateInfo = new Date();
        let hour, minute, second;
        hour = dateInfo.getHours() < 12 ? ("0" + dateInfo.getHours()) : (dateInfo.getHours());
        minute=dateInfo.getMinutes()<10 ? ("0"+dateInfo.getMinutes()):(dateInfo.getMinutes());
        second=dateInfo.getSeconds()<10 ?("0"+dateInfo.getSeconds()):(dateInfo.getSeconds());
        setAmpm(dateInfo.getHours>12?"AM":"PM");
        setTime(`${hour}:${minute}:${second}  ${ampm}`)
    }
    setInterval(updateTime,1000);
    return [time,ampm]


}

export function MyClock2() {

    const [time, setTime] = useClock2();
    return(
        <>
            <span>{time}</span>
        </>

    )
}