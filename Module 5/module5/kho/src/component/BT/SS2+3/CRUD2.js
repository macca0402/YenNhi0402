import {Component} from "react";
import "bootstrap/dist/css/bootstrap.css";

class CRUD2 extends Component {
    constructor(props) {
        super(props);
        this.state = {
            studentList: [
                {name: "nhi dep", phone: '12345678', email: 'abc@gmail.com'},
                {name: "nhi dep", phone: '12345678', email: 'abc@gmail.com'},
                {name: "nhi dep", phone: '12345678', email: 'abc@gmail.com'}

            ],
            form: {name: "", phone: "", email: ""},
            isValid: false,
            indexSelected: -1
        }
    }

    handleChange = (event) => {
        this.setState((state) => {
            const form = state.form
            form[event.target.name] = event.target.value
            return {form}
        }, () => this.checkInvalidForm())

    }

    checkInvalidForm = () => {
        const {name, phone, email} = this.state.form
        const value = name && phone && email
        this.setState({
            isValid: value
        })
    }
    handleSubmit = () => {
        if (this.state.isValid) {
            if (this.state.indexSelected > -1) {
                const arr = [...this.state.studentList].map((value, index) => {
                    if (index === this.state.indexSelected) {
                        return {...this.state.form}
                    } else {
                        return value;
                    }
                })
                this.setState({
                    ...this.state,
                    studentList: [...arr],
                    form: {name: "", phone: "", email: ""},
                    indexSelected: -1

                })
            } else {
                this.setState({
                    ...this.state,
                    studentList: [...this.state.studentList, this.state.form],
                    form: {name: "", phone: "", email: ""}
                })
            }
        }
    }
    handleSelect = (studentSelected, index) => {
        this.setState({
            form: JSON.parse(JSON.stringify(studentSelected)),
            indexSelected: index
        })
    }
    handleDelete = (index) => {
        const list = [...this.state.studentList];
        list.splice(index, 1);
        this.setState({...this.state, studentList: list})
    }

    render() {
        return (
            <>
                <div>
                    <h1>Student List</h1>
                    <div>
                        <label>Name:</label>
                        <input type="text" name="name" value={this.state.form.name} onChange={(evt) => this.handleChange(evt)}/>
                    </div>
                    <div>
                        <label>Phone:</label>
                        <input  type="text" name="phone" value={this.state.form.phone} onChange={(evt) => this.handleChange(evt)}/>
                    </div>
                    <div>
                        <label>Email:</label>
                        <input  type="text" name="email" value={this.state.form.email} onChange={(evt) => this.handleChange(evt)}/>
                    </div>
                    <button onClick={this.handleSubmit}>Submit</button>
                </div>
                <table className="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.studentList.map((student, index) => (
                            <tr key={index}>
                                <td>{student.name}</td>
                                <td>{student.phone}</td>
                                <td>{student.email}</td>
                                <td>
                                    <button onClick={(e) => this.handleSelect(student, index)}>Edit</button>
                                </td>
                                <td>
                                    <button onClick={(e) => this.handleDelete(index)}>Delete</button>
                                </td>
                            </tr>

                        ))
                    }
                    </tbody>
                </table>
            </>


        )
    }
}

export default CRUD2;