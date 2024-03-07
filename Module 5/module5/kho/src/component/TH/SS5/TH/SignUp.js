import {useState} from "react";
import React from "react";
import {Field, Form, Formik} from "formik";
import * as Yup from "yup";

const SignUpSchema = Yup.object().shape({
    username: Yup.string()
        .matches(/^[a-zA-Z ]+$/)
        .min(2, "Tối thiểu 2 ký tự"),
    email: Yup.string()
        .matches(/^[a-zA-Z0-9._+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/, "Email không hợp lệ"),
    password: Yup.string()
        .matches(/^[a-zA-Z0-9!@#$%^&+=._-]+$/)
        .min(6, "Tối thiếu 6 kí tự "),
    confirm: Yup.string()
        .oneOf([Yup.ref("password")], "Passwords không trùng")

})

function SignUp() {
    const [form, setForm] = useState({});
    const handleChange = (e) => {
        setForm({...form, [e.target.name]: e.target.value});
    }

    function handleSubmit(value) {
        const isValid = value.username && value.email && value.password && value.confirm;
        alert(isValid ? "Sign in success !!!" : "Please fill out all the fields!!!");
    }

    return (
        <div>
            <h1>Sign up</h1>
            <Formik initialValues={{username: "", email: "", password: "", confirm: ""}}
                    validationSchema={SignUpSchema}
                    onSubmit={handleSubmit}
            >
                {
                    ({errors, touched}) => (
                        <Form>
                            <label htmlFor="username">Username</label>
                            <br/>
                            <Field name="username"/>
                            {errors.username && touched.username ? (<div style={{color: "red"}}>{errors.username}</div>) : null}

                            <br/>
                            <label htmlFor="email">Email</label>
                            <br/>
                            <Field name="email"/>
                            {errors.email && touched.email ? (<div style={{color: "red"}}>{errors.email}</div>) : null}

                            <br/>
                            <label htmlFor="password">Password</label>
                            <br/>
                            <Field name="password" type="password"/>
                            {errors.password && touched.password ? (<div style={{color: "red"}}>{errors.password}</div>) : null}

                            <br/>
                            <label htmlFor="confirm" type="password">Confirm password</label>
                            <br/>
                            <Field name="confirm" type="password"/>
                            {errors.confirm && touched.confirm ? (<div style={{color: "red"}}>{errors.confirm}</div>) : null}
                            <br/>
                            <button type="submit">Submit</button>
                        </Form>
                    )
                }
            </Formik>
        </div>
    )
}

export default SignUp;