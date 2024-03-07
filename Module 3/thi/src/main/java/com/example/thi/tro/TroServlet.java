package com.example.thi.tro;

import com.example.thi.thanh_toan.IRepoThanhToan;
import com.example.thi.thanh_toan.RepoThanhToan;
import com.example.thi.thanh_toan.ThanhToan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


@WebServlet(name = "TroServlet", value = "/tro-servlet")
public class TroServlet extends HttpServlet {
    ServiceTro serviceTro = new ServiceTro();
    RepoThanhToan repoThanhToan = new RepoThanhToan();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                taoMoi(request, response);
                break;
            case "search":
                searchInfo(request, response);
                break;
        }
    }

    private void searchInfo(HttpServletRequest request, HttpServletResponse response) {
        String key = request.getParameter("search");
        List<Tro> searchList=serviceTro.search(key);
        request.setAttribute("list",serviceTro.search(key));
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("tro.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void taoMoi(HttpServletRequest request, HttpServletResponse response) {
        String ten = request.getParameter("ten_nguoi_thue_tro");
        String soDienThoai = request.getParameter("so_dien_thoai");
        String ngayThue = request.getParameter("ngay_bat_dau_thue");
        int maThanhToan = Integer.parseInt(request.getParameter("ma_hinh_thuc_thanh_toan"));
        String ghiChu = request.getParameter("ghi_chu");
        Tro tro = new Tro(ten,soDienThoai,ngayThue,maThanhToan,ghiChu);
        serviceTro.add(tro);
        request.setAttribute("list", serviceTro.getAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("tro.jsp");
        try {
            requestDispatcher.forward(request, response);
            response.sendRedirect("/tro-servlet");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                mauTaoMoi(request, response);
                break;
            case "delete":
                xoa(request, response);
                break;
            default:
                danhSachTro(request, response);
        }
    }

    private void xoa(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        List<Tro> danhSach=serviceTro.delete(id);
        request.setAttribute("list",danhSach);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("tro.jsp");
        try {
            response.sendRedirect("/tro-servlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mauTaoMoi(HttpServletRequest request, HttpServletResponse response) {

        List<ThanhToan> list=repoThanhToan.danhSachThanhToan();
        request.setAttribute("list",list);
       RequestDispatcher requestDispatcher=request.getRequestDispatcher("taoMoi.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void danhSachTro(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("list", serviceTro.getAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("tro.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
