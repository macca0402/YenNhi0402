import {Component} from "react";

class Hello extends Component{
    // phương thức này sẽ thực thi khi component này bị tháo gỡ
    componentWillUnmount() {
        alert('The component is going to be unmounted');
    }
    render() {
        return <h1>Hello nhi yeu dau </h1>
    }
}
export default Hello;