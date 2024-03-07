package com.example.furama2.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class ServiceCustomer implements IServiceCustomer{
    RepoCustomer repoCustomer=new RepoCustomer();

    @Override
    public void add(Customer customer) {
        repoCustomer.add(customer);
    }

    @Override
    public List<Customer> getAll() {
        return repoCustomer.findAll();
    }

    @Override
    public List<Customer> delete(int id) {
        return repoCustomer.delete(id);
    }

    @Override
    public Customer findByID(int id) {
        return repoCustomer.findByID(id);
    }

    @Override
    public List<Customer> customerUseService() {
        return repoCustomer.customerUseService();
    }

    @Override
    public List<Customer> update(Customer customer) {
        return repoCustomer.update(customer);
    }

    public List<String> validateMap(Map<String,String> data){
        List<String> errorMessages = new ArrayList<>();

        for(Map.Entry<String,String> entry: data.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.equals("name")){
                if (value.isEmpty()){
                    errorMessages.add("Tên không được để trống");
                }else if(!isValidateName(value)){
                    errorMessages.add("Tên không hợp lệ");
                }
            } else if(key.equals("birthday")){
                if (!isValidateDate(value)){
                    errorMessages.add("Ngày tháng năm không đúng định dạng");
                }
            } else if(key.equals("card")){
                if(value.isEmpty()){
                    errorMessages.add("CCCD không được để trống");
                }else if(!isValidateCardID(value)){
                    errorMessages.add("CCCD không hợp lệ");
                }

            }else if(key.equals("phone")){
                if(value.isEmpty()){
                    errorMessages.add("SDT không được để trống");
                }else if(!isValidatePhone(value)){
                    errorMessages.add("SDT không hợp lệ");
                }
            }else if(key.equals("email")){
                if(value.isEmpty()){
                    errorMessages.add("Email không được để trống");
                }else if(!isValidateEmail(value)){
                    errorMessages.add("Email không hợp lệ");
                }
            }else if(key.equals("address")){
                if(value.isEmpty()){
                    errorMessages.add("Địa chỉ không được để trống");
                }
            }else if(key.equals("typeCustomer")){
                try {
                    if (value == null || value.isEmpty()) {
                        errorMessages.add("Không được để trống");
                    } else if (!isValidateTypeCustomer(Integer.parseInt(value))) {
                        errorMessages.add("Loại khách hàng không tồn tại trong csdl");
                    }
                }catch (NumberFormatException e){
                    e.printStackTrace();
                    errorMessages.add("Lỗi định dạng trong SQL");
                }
            }
        }
        return errorMessages;
    }



    public static  boolean isValidateName(String name){
        String USERNAME_REGEX ="^[\\p{L}\\s]{7,20}$";
        return Pattern.matches(USERNAME_REGEX,name);
    }
    public static boolean isValidateDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            Date dateParse = sdf.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateParse);
            int year = calendar.get(Calendar.YEAR);
            if( year >= 1900 && year <=2100){
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static  boolean isValidateCardID(String card){
        String ID_CARD_REGEX= "^[0-9]{9,12}$";
        return Pattern.matches(ID_CARD_REGEX,card);
    }
    public static  boolean isValidatePhone(String phone){
        String CELL_PHONE_REGEX= "^(0[3|5|7|8|9])+([0-9]{8})$";
        return Pattern.matches(CELL_PHONE_REGEX,phone);
    }
    public static  boolean isValidateEmail(String email){
        String EMAIL_REGEX= "^\\w+@\\w+[.]\\w+$";
        return Pattern.matches(EMAIL_REGEX,email);
    }
    public static boolean isValidateTypeCustomer(int typeID){

        if( typeID >=1 && typeID <=5){
            return true;
        }
        return false;
    }
}
