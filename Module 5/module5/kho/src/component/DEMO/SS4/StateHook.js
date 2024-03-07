import {useState} from "react";
// Function components trong React có 2 dạng :
// dạng 1:
function Example() {
    // Khai báo một biến trạng thái mới đặt tên là count
    const [count,setCount] =useState(0);
    return(
        <div>
            <p>Bạn đã click {count} lần</p>
            <button onClick={()=>setCount(count+1)}>
                Click vào tôi
            </button>
        </div>
    )
}
// trong 1 file chỉ dduocj sử dụng 1 default
export default Example;
// dạng 2:
export const Sum=()=>{
    const [a,setA]=useState("");
    const [b,setB]=useState("");
    const sum=parseInt(a)+parseInt(b);
    return(
        <div>
            <input type="text" value={a} onChange={(e)=>setA(e.target.value)} placeholder={"Nhap a:"}/>
            <br/>
            <input type="text" value={b} onChange={(e)=>setB(e.target.value)} placeholder={"Nhap b:"}/>
            <br/>
            // sử dụng dấu || để thiết lập cho giá trị của sum hiển thị khi chưa xác định được giá trị nhé
            Tổng là : {sum||0}
        </div>
        )
}

