import React, { useState } from "react";
import { Field, Form, Formik } from "formik";

export default function ContactForm() {
    const [form, setForm] = useState({});
    const REGEX = {
        email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
        name: /^\S+$/,
        phone: /^\S+$/
    }
    const MESSAGE_ERROR = {
        email: "Email không hợp lệ",
        name: "Required",
        phone: "Required"
    }

    const handleChange = (e) => {
        let error = REGEX[e.target.name].test(e.target.value) ? "" : MESSAGE_ERROR[e.target.name];
        setForm({
            ...form,
            [e.target.name]: { value: e.target.value, error: error }
        })
    }

    const handleSubmit = () => {
        let isFilled = form.name && form.name.value && form.email && form.email.value && form.phone && form.phone.value && form.message && form.message.value;
        let isError = isFilled && (form.name.error || form.email.error || form.phone.error || (form.message && form.message.error));
        alert((isFilled && !isError) ? "Successfully contact " : "Please fill out all fields.")
    }

    return (
        <div>
            <Formik initialValues={{ name: "", email: "", phone: "", message: "" }}
                    onSubmit={handleSubmit}>
                {
                    <Form>
                        <label htmlFor="">Name</label><br />
                        <input type="text" name="name" value={(form.name && form.name.value) || ""}
                               onChange={handleChange} /><br />
                        {form.name && form.name.error && (
                            <div><span style={{ color: "red" }}>{form.name.error}</span><br /></div>
                        )}

                        <label htmlFor="">Email</label><br />
                        <input type="text" name="email" value={(form.email && form.email.value) || ""}
                               onChange={handleChange} /><br />
                        {form.email && form.email.error && (
                            <div><span style={{ color: "red" }}>{form.email.error}</span><br /></div>
                        )}

                        <label htmlFor="">Phone</label><br />
                        <input type="text" name="phone" value={(form.phone && form.phone.value) || ""}
                               onChange={handleChange} /><br />
                        {form.phone && form.phone.error && (
                            <div><span style={{ color: "red" }}>{form.phone.error}</span><br /></div>
                        )}

                        <label htmlFor="">Message</label><br />
                        <textarea name="message" value={(form.message && form.message.value) || ""}
                                  onChange={handleChange} /><br />
                        {form.message && form.message.error && (
                            <div><span style={{ color: "red" }}>{form.message.error}</span><br /></div>
                        )}
                        <button type="submit">Submit</button>
                    </Form>
                }
            </Formik>
        </div>
    )
}
