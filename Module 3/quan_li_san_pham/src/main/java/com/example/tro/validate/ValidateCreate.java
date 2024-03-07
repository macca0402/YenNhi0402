package com.example.tro.validate;

public class ValidateCreate extends Validate {
    //tên sản phẩm không để trống
    public boolean tenSanPham(String input) {
        if (super.validate("^\\s*$", input) || super.validate("^[a-zA-Z0-9 ]*$", input) ==false) {
            return true;
        }
        return false;
    }

    // giá sản phẩm lớn hơn 1000
    public boolean gia(int input) {
        if (input >= 1000 && super.validate("^\\s*$", String.valueOf(input)) == false) {
            // thoa man
            return false;
        }
        // khong thoa man
        return true;
    }

    // Số lượng phải là số nguyên dương

    private boolean check_real_integer_number(double n) {
        //flag = true => số nguyên
        //flag = false => số thực

        boolean flag = true;
        if (Math.ceil(n) != Math.floor(n)) flag = false;
        return flag;
    }

    public boolean soLuong(double input) {
        if (input > 0 && check_real_integer_number(input)) {
            // thoa man
            return false;
        } else {
            // khong thoa man
            return true;
        }
    }

    public static void main(String[] args) {
        ValidateCreate validateCreate = new ValidateCreate();
        System.out.println(validateCreate.tenSanPham("@@@"));
        ;
    }
}
