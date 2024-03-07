
import {Component} from "react";

class Expand_Collapse extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isIntro: false
        }
    };

    handleExpand = () => {
        this.setState({isIntro: true})
    }
    handleCollapse = () => {
        this.setState({isIntro: false})
    };


    render() {
        const ContentIntro = () => {
            return (
                <div>
                    <button onClick={this.handleCollapse}>Đóng giới thiệu</button>
                    <h1>Gioi thieu</h1><br/>
                    <p>Trong React, chúng ta có thể tạo nhiều component khác nhau, khi đó có thể render bất kỳ component
                        nào ta muốn, bằng cách sử dụng điều kiện tại phần render.
                        Cách sử dụng câu điều kiện (câu điều kiện if else) tại phần render giống như cách sử dụng trong
                        Javascript, React sẽ dựa vào câu điều kiện để tạo thành phần đại diện cho State hiện tại, sau đó
                        sẽ dựa vào setState để cập nhập lại giao diện.
                        Xem ví dụ bên dưới để hiểu rõ thêm nhé.</p>
                </div>
            )
        }
        const NoContentIntro = () => {
            return (
                <div>
                    <button onClick={this.handleExpand}>Giới thiệu</button>
                </div>
            )
        }
        return (
            <div>
                <div style={{width: '100%', height: '50px', color: 'white', backgroundColor: 'green',textAlign:'center'}}>
                    <h1>Conditional Rendering</h1>
                </div>
                {
                    this.state.isIntro ? (<ContentIntro/>) : (<NoContentIntro/>)
                }
            </div>
        )
    }
}

export default Expand_Collapse;
