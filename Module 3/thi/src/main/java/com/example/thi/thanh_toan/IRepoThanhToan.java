package com.example.thi.thanh_toan;

import java.util.List;

public interface IRepoThanhToan {
    List<ThanhToan> danhSachThanhToan();
    ThanhToan timKiemThanhToan(int id);
}
