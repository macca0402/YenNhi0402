import logo from './logo.svg';
import './App.css';
import {Component} from "react";

class App extends Component {
    constructor() {
        super();
        this.state = {
            number: 0
        };
    }

    increase = (event) => {
        this.setState((a) => (
            {
                number: a.number + 1
            }
        ))
    }
    decrease = (event) => {
        this.setState((a) => (
            {
                number: a.number - 1
            }
        ))
    }



    render() {
        return (

            <div style={{textAlign: "center", padding: 30}}>
                <button onClick={this.increase}>+</button>
                <span style={{padding: 10}}>{this.state.number}</span>
                <button onClick={this.decrease}>-</button>
            </div>
        );
    }
}

export default App;
