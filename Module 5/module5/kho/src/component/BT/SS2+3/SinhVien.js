
import {Component} from "react";

class SinhVien extends Component {
    constructor(props) {
        super(props);
        this.state = {
            students:[
                {id:1,name:"Yen Nhi",age:20,address:'123 AbC street'},
                {id:2,name:"Ha ",age:21,address:'312 AbC street'},
                {id:3,name:"Trung",age:22,address:'324 AbC street'},
            ]
        }
    }
    render() {
        return(
            <div>
                <table border={1}>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Address</th>
                    </tr>

                        {
                            this.state.students.map(student=>(
                                <tr key={student.id}>
                                    <td>{student.id}</td>
                                    <td>{student.name}</td>
                                    <td>{student.age}</td>
                                    <td>{student.address}</td>
                                </tr>
                            ))
                        }

                </table>
            </div>
        )


    }
}

export default SinhVien;