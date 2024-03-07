package com.example.tro.SanPham;


import com.example.tro.Category.Category;
import com.example.tro.Category.RepoCategory;
import com.example.tro.validate.ValidateCreate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "SanPhamServlet", value = "/san-pham-servlet")
public class SanPhamServlet extends HttpServlet {
    ServiceSanPham serviceSanPham = new ServiceSanPham();
    RepoCategory repoCategory = new RepoCategory();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "search":
                searchInfo(request, response);
                break;
        }
    }

    private void searchInfo(HttpServletRequest request, HttpServletResponse response) {
        String key = request.getParameter("search");
        request.setAttribute("list", serviceSanPham.search(key));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ValidateCreate validateCreate = new ValidateCreate();
        String ten = request.getParameter("ten");
        int gia = Integer.parseInt(request.getParameter("gia"));
        double soLuong = Double.parseDouble(request.getParameter("so_luong"));
        String mauSac = request.getParameter("mau");
        String moTa = request.getParameter("mo_ta");
        int maDanhMuc = Integer.parseInt(request.getParameter("id_danh_muc"));

        if (validateCreate.tenSanPham(ten)||validateCreate.gia(gia)||validateCreate.soLuong(soLuong)) {
            if (validateCreate.tenSanPham(ten)) {
                request.setAttribute("message", "Vui lòng không để trống và không có ký tự đặc biệt.");
            }
            if (validateCreate.gia(gia)) {
                request.setAttribute("message1", "giá sản phẩm > 1000");
            }
            if (validateCreate.soLuong(soLuong)) {
                request.setAttribute("message2", "số lượng > 0 và số nguyên");
            }
            formCreate(request, response);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
            requestDispatcher.forward(request, response);
        } else {
            SanPham sanPham = new SanPham(ten,gia,soLuong,mauSac,moTa,maDanhMuc);
            serviceSanPham.add(sanPham);
            request.setAttribute("list", serviceSanPham.findAll());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
            try {
                requestDispatcher.forward(request, response);
                response.sendRedirect("/san-pham-servlet");
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
                formCreate(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                danhSachSanPham(request, response);
        }
    }

    private void formCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Category> list = repoCategory.getAll();
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<SanPham> danhSach = serviceSanPham.delete(id);
        request.setAttribute("list", danhSach);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        try {
            response.sendRedirect("/san-pham-servlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void danhSachSanPham(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("list", serviceSanPham.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
