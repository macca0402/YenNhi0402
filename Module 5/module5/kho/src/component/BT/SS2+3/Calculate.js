
import {Component} from "react";


class Calculator extends Component {
    constructor(props) {
        super(props);
        this.state = {
            number1: "",
            number2: "",
            result: ""

        }
    };

// Sự kiện để lấy giá trị ở ô input
    handleNumber1 = (e) => {
        this.setState({number1: e.target.value})
    };
    handleNumber2 = (e) => {
        this.setState({number2: e.target.value})
    };
    // Hàm xử lý các phép tính
    add = () => {
        this.setState({result: Number(this.state.number1) + Number(this.state.number2)})
    }
    sub = () => {
        this.setState({result: Number(this.state.number1) - Number(this.state.number2)})
    }
    divide = () => {
        this.setState({result: Number(this.state.number1) / Number(this.state.number2)})
    }
    multiply = () => {
        this.setState({result: Number(this.state.number1) * Number(this.state.number2)})
    }
    reset = () => {
        this.setState({number1:"",number2:"",result:""});
    }

    render() {
        return (
            <div>
                <input type="text" value={this.state.number1} onChange={this.handleNumber1}
                       placeholder="Nhập số thứ nhất: "/>
                       <br/>
                <input type="text" value={this.state.number2} onChange={this.handleNumber2}
                       placeholder="Nhập số thứ hai: "/>
                <br/>
                <button onClick={this.add}>+</button>
                <button onClick={this.sub}>-</button>
                <button onClick={this.divide}>/</button>
                <button onClick={this.multiply}>*</button>
                <br/>
                <button onClick={this.reset}>Reset</button>
                <br/>
                <h1>Result: <span style={{color:"red"}}>{this.state.result}</span></h1>
            </div>
        )
    }

}

export default Calculator;
