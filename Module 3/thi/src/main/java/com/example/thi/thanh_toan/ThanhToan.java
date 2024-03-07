package com.example.thi.thanh_toan;

public class ThanhToan {
    private int maThanhToan;
    private String tenThanhToan;

    public ThanhToan() {
    }

    public ThanhToan(String tenThanhToan) {
        this.tenThanhToan = tenThanhToan;
    }

    public ThanhToan(int maThanhToan, String tenThanhToan) {
        this.maThanhToan = maThanhToan;
        this.tenThanhToan = tenThanhToan;
    }

    public int getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(int maThanhToan) {
        this.maThanhToan = maThanhToan;
    }



    public String getTenThanhToan() {
        return tenThanhToan;
    }

    public void setTenThanhToan(String tenThanhToan) {
        this.tenThanhToan = tenThanhToan;
    }


}
