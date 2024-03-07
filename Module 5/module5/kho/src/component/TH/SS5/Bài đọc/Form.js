import {useState} from "react";

const MyForm = () => {
    const [state, setState] = useState({
        userName:"",
        age:null
    });

    const submitHandler = e => {
        e.preventDefault();
        alert("You are submitting " +state.userName);
    };
    const handleChange = e => {
        setState({
            ...state,[e.target.name]:e.target.value
        })
    }
    // let header;
    // if (username) {
    //     header = <h1>Hello {username}</h1>
    // } else {
    //     header = "";
    // }
    return (
        <form onSubmit={submitHandler}>
            <h1>Hello {state.userName} {state.age}</h1>
            {/*{header}*/}
            <p>Enter your name: </p>
            <input type="text" name="userName" onChange={handleChange}/>
            <p>Enter your age: </p>
            <input type="text" name="age" onChange={handleChange}/>
            <input type="submit"/>
        </form>
    )
}
export default MyForm;