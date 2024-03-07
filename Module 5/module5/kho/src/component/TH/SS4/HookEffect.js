import {useEffect, useState} from "react";


export function Course(){
    const [select,setSelect]=useState(0);
    const [subject,setSubject]=useState("");
    const choice =(e)=>
    {
        setSelect(e.target.value);
    }


        useEffect(()=>{
            switch (select) {
                case "0":
                    setSubject("Java");
                    break;
                case "1":
                    setSubject("Angular");
                    break;
                case "2":
                    setSubject("Javascript");
                    break;
                case "3":
                    setSubject("PHP");
                    break;
                default:

            }
        },[subject,select])



    return(
        <div>
            <h1>Khóa học </h1>
            <select onChange={(e)=>{choice(e)}}>
                <option value="0">Java</option>
                <option value="1">Angular</option>
                <option value="2">Javascript</option>
                <option value="3">PHP</option>
            </select>
            <h2>Your selected : {subject}</h2>
        </div>
    )
}