import {useState} from "react";

function SS5_BaiDoc_2() {
    const [state, setState] = useState({
        description: "Toi yeu Viet nam",
        mycar:""
    })
    return (
        <div>
            <form action="">
                   <textarea value={state.description}>
                   </textarea>
                <br/>4\
                <select name="" id="" value={state.mycar}>
                    <option value="Ford">Ford</option>
                    <option value="Volvo">Volvo</option>
                    <option value="Fiat">Fiat</option>
                </select>
            </form>

        </div>

    )

}

export default SS5_BaiDoc_2;