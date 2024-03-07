
import "bootstrap/dist/css/bootstrap.css";
import React from "react";

function Alert (props){
   return(
       <div className="alert alert-warning" role="alert">
           Cảnh báo! Tài nguyên bạn vừa truy cập không tồn tại.
       </div>
   )
}
export default Alert;