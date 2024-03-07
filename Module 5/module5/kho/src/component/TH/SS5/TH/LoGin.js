import {useState} from "react";

export default function Login() {
    const [form, setForm] = useState({})
    const REGEX = {
        email: /^[\w.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
        password: /^[\w\s]{6,}$/
    }
    const MESSAGE_ERROR = {
        email: "Email invalid",
        password: "Password invalid"
    }
    const handleChange = (e) => {
        let error = REGEX[e.target.name].test(e.target.value) ? "" : MESSAGE_ERROR[e.target.name];
        setForm({
            ...form,
            [e.target.name]: {value: e.target.value, error: error}
        })


    }
    const handleSubmit = () => {
        // form.email,form.password : có nhiệm vụ lưu giá trị của thẻ input có tên là email và password
        let isFilled = form.email && form.email.value && form.password && form.password.value;
        // isError : TRUE nếu isFilled true và 1 trong 2 giá trị trong ngoặc có giá trị ERROR => TRUE => CÓ GIÁ TRỊ LỖI
        // isError : FALSE nếu isFilled true và 1 trong 2 giá trị trong ngoặc KHÔNG có giá trị ERROR => FALSE => KHÔNG CÓ GÁI TRỊ LỖI

        let isError = isFilled && (form.email.error || form.password.error);
        // THÔNG BÁO SUCCESS KHI :
        // isFilled =true isError =false : đã có dữ liệu và không có thông điệp báo lỗi => isError =false
        alert((isFilled && isError == false) ? "Success login !!!" : "Please fill out all the fields!!! ")

    }
    return (
        <div>
            <h1>Login</h1><br/>
            <form onSubmit={handleSubmit}>
                <label htmlFor="">Email</label><br/>
                <input type="text" name="email" onChange={handleChange} value={(form.email && form.email.value) || ""}/><br/>
                {form.email && form.email.error && (
                    <div><span style={{color: "red"}}>{form.email.error}</span><br/></div>

                )}
                <label htmlFor="">Password</label><br/>
                <input type="password" name="password" onChange={handleChange}
                       value={(form.password && form.password.value) || ""}/><br/>
                {form.password && form.password.error && (
                    <div><span style={{color: "red"}}>{form.password.error}</span><br/></div>
                )}
                <input type="submit" value="Submit"/><br/>
            </form>
        </div>

    )

}