import {Component} from "react";


class ToDoApp extends Component {
    constructor(props) {
        super(props);
        this.state = {
            list: [],
            item: ''
        }
    }

    handleChange = (event) => {
        this.setState({item: event.target.value})
    }
    handleAddItem = () => {
        if (this.state.item !== '') {
            this.setState({
                list: [...this.state.list, this.state.item],
                item: ''
            })

        }
    }

    render() {
        return (
            <div>
                <h1>To do list</h1>
                <input type="text" value={this.state.item} onChange={this.handleChange}/>
                <button onClick={this.handleAddItem}>Add</button>
                {
                    this.state.list.map((item, index) => (
                        <div>
                            <input type="checkbox" key={index} value={item}/>
                            <label>{item}</label>
                        </div>
                    ))
                }


            </div>
        )
    }
}


export default ToDoApp;