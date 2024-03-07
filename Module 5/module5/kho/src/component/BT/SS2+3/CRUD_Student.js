import React, {Component} from "react";
import "bootstrap/dist/css/bootstrap.css";

class CRUD_Student extends Component {
    constructor(props) {
        super(props);
        this.state = {
            studentList: [{name: 'nhi ngao', phone: '09876543', email: 'asd@gmail.com'},{name: 'nhi ngao 1', phone: '09876543', email: 'asd@gmail.com'}],
            form: {name: "", phone: "", email: ""},
            isValid: false,
            indexSelected: -1
        }
    }

//Khởi tạo hàm handleChange nhận event
// làm param truyền vào,
// hàm này sẽ gọi hàm setState để cập nhật lại giá trị mới
// cho form bằng event.target.value
// và sau đó gọi hàm checkInvalidForm

    handleChange = (event) => {
        this.setState((state) => {
            const form = state.form
            form[event.target.name] = event.target.value
            return {form}
        }, () => this.checkInvalidForm())
    }
    //Khởi tạo hàm handleSelect
    // nhận studenSelected và index làm params truyền vào,
    // hàm này sẽ goị hàm setState
    // để cập nhật lại giá trị mới cho
    // form = studentSelected
    // và indexSelected = index

    handleSelect = (studentSelected, index) => {
        this.setState({
            //JSON.stringify(): được sử dụng để chuyển đổi đối tượng thành chuỗi JSON
            //JSON.parse() : được sử dụng để chuyển đổi JSON này trở lại thành một đối tượng mới.
            form: JSON.parse(JSON.stringify(studentSelected)),
            // biểu thị vị trí của sinh viên trong danh sách
            indexSelected: index
        })

    }

    //Khởi tạo hàm checkInvalidForm,
    // hàm này sẽ kiểm tra giá trị của form đã được điền hay chưa
    // và gọi hàm setState để cập nhật lại giá trị isValid
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
                // tạo mảng mới
                const arr = [...this.state.studentList].map((elm, index) => {
                    if (index === this.state.indexSelected) {
                        // trả về danh sách trong form
                        return {...this.state.form}
                    } else {
                        return elm;
                    }
                })
                // Tạo mảng mới,state: lấy ds hiện tại,form:form=rỗng ,indexSelected: trả về vị trí ban đầu
                this.setState({
                    ...this.state,
                    studentList: [...arr],
                    form: {name: "", phone: "", email: ""},
                    indexSelected: -1
                })

            } else {
                // tạo mảng sửa,state:ghi đè ds mới trong form vào ds hiện tại ,form:form=rỗng
                this.setState(({
                    ...this.state,
                    studentList: [...this.state.studentList, this.state.form],
                    form: {name: "", phone: "", email: ""}
                }))
            }
        }
    }
    handleDelete = (index) => {
        console.log(index)
        const stdl = [...this.state.studentList];
        stdl.splice(index, 1);
        this.setState({...this.state, studentList: stdl})
    }

    render() {
        const {studentList} = this.state
        return (
            <div>
                <div>
                    <h1>Student list</h1>
                    <div>
                        <label>Name:</label>
                        <input name="name" value={this.state.form.name} onChange={(evt) => this.handleChange(evt)}/>
                    </div>
                    <div>
                        <label>Phone:</label>
                        <input name="phone" value={this.state.form.phone} onChange={(evt) => this.handleChange(evt)}/>
                    </div>
                    <div>
                        <label>Email:</label>
                        <input name="email" value={this.state.form.email} onChange={(evt)=>this.handleChange(evt)}/>
                    </div>
                    <button onClick={this.handleSubmit}>Submit</button>
                </div>
                <table className="table table-success table-striped">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Action</th>
                        <th></th>
                    </tr>
                    </thead>

                    <tbody>
                    {studentList.map((student, index) => (
                        <tr key={index}>
                            <td>{student.name}</td>
                            <td>{student.phone}</td>
                            <td>{student.email}</td>
                            <td>
                                <button onClick={(e) => this.handleSelect(student, index)}>Edit</button>
                            </td>
                            <td>
                                <button onClick={() => this.handleDelete(index)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>

        )
    }
}
export default CRUD_Student;