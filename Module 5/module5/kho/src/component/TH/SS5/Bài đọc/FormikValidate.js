function FormikValidate() {
    // Synchronous validation (đồng bộ hóa )
    const validate = (values, props) => {
        const error = {};
        if (!values.email) {
            error.email = 'Required';
        } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)) {
            error.email = "Invalid email address";
        }
        return error;
    }

    //    Async
    //     Validation(bất
    //     đồng
    //     bộ
    const sleep = ms => {
        new Promise(resolve => setTimeout(resolve, ms));
    };
    const validate2 = (values, props) => {
        const error = {};
        if (['admin', 'null', 'god'.includes(values.username)]) {
            error.username="Nice try";
        }
        return error;
    }
}