import React, {useState} from "react";

export function useClock() {
    const [time, setTime] = useState("");
    const [ampm, setAmpm] = useState("");
    // Function cập nhập thời gian.
    const updateTime= () => {
        let dateInfo=new Date();
        let hour=0;
        /* Lấy giá trị của giờ */
        if(dateInfo.getHours()===0){
            hour=12
        } else if(dateInfo.getHours()>12){
            hour=dateInfo.getHours()-12;
        } else {
            hour=dateInfo.getHours();
        }
        /* Lấy giá trị của phút */
        let minutes = dateInfo.getMinutes()<10
            ?parseInt("0"+dateInfo.getMinutes())
            : dateInfo.getMinutes();
        /* Lấy giá trị của giây */
        let seconds = dateInfo.getSeconds()<10
            ?parseInt("0"+dateInfo.getSeconds())
            : dateInfo.getSeconds();
        /* Định dạng ngày */
        let ampm=dateInfo.getHours()>12?"PM":"AM";
        /* Cập nhập state */
        setAmpm(ampm)
        setTime(`${hour}:${minutes}:${seconds}    ${ampm}`);
    }
    setInterval(function () {
            updateTime();
    },1000);
    return [time,ampm]

}

/* Nếu một tên hàm bắt đầu với 'use'
và nó gọi các hooks khác ,
thì nó được gọi là một hook custome */
export function MyClock() {
    //
    const [time, setTime] = useClock();
    return(
        <div>
            <button>{time}</button>
        </div>
    )

}