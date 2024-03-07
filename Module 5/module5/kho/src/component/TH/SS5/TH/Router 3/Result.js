import {useLocation} from "react-router";

export default function Result() {
    const {state} = useLocation();
    const location = useLocation();
    //location.pathname cho chúng ta biết đường dẫn hiện tại của URL.
    // location.search cho biết các thông tin truy vấn nếu có.
    // location.hash cho biết phần neo của URL nếu có.
    return (
        <div>
            <h3>Color you selected
                 <span style={{color: `${state.colorID}`}}> {state.colorID}</span><br/>
                 Đường đẫn của bạn đang ở :
                 <span style={{color: `${state.colorID}`}}> {location.pathname}</span>
                 <span style={{color: `${state.colorID}`}}> {location.search}</span>
                 <span style={{color: `${state.colorID}`}}> {location.hash}</span>
            </h3>
        </div>
    )

}