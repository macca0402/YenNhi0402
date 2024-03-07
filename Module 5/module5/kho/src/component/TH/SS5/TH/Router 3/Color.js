import {useNavigate} from "react-router";

export default function Color() {
    let navigate = useNavigate();
    const sendDataToProduct = e => {
        navigate("/color", {state: {colorID: e.target.value}});
    }
    return (
        <>
            <h2>
                Select a hobby color
            </h2>
            <select defaultValue="default" onChange={e=>sendDataToProduct(e)}>
                <option value="default" disabled hidden>Choose a color </option>
                <option value="yellow">yellow</option>
                <option value="red">red</option>
                <option value="blue">blue</option>
                <option value="white">white</option>
                <option value="pink">pink</option>

            </select>
        </>
    )

}