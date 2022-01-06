package service.vailidate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class ValidateService {
    public static final String REGEX_PHONE = "^(0|\\(84\\)\\+)(90|91)\\d{7}$";
    public static final String REGEX_SERVICE_ID = "^(DV\\-)\\d{4}$";
    public static final String REGEX_NUMBER = "^\\d+$";
    public static final String REGEX_NAME = "^[A-Za-z ]+$";
    public static final String REGEX_EMAIL = "^\\w+@\\w+[.]\\w+$";
    public static final String REGEX_ID_CARD = "^\\d{12}|\\d{9}$";
    
    public static boolean checkIsNumber(String string){
        if (string.matches("^\\d+$")) {
            return true;
        }
        return false;
    }

    public static boolean checkEmpty(String string){
        if ("".equals(string)) {
            return true;
        }
        return false;
    }

    public static boolean checkPhone(String phone){
        if (phone.matches(REGEX_PHONE)) {
            return true;
        }
        return false;
    }

    public static Boolean checkIdCustomer(String id) {
        if (id.matches("^KH-[0-9]{4}$")) {
            return true;
        }
        return false;
    }

    public static Boolean checkIdService(String id) {
        if (id.matches(REGEX_SERVICE_ID)) {
            return true;
        }
        return false;
    }

    public static Boolean checkIdCard(String idCard) {
        if (idCard.matches("^\\d{12}|\\d{9}$")) {
            return true;
        }
        return false;
    }

    public static Boolean checkEmail(String email) {
        if (email.matches(REGEX_EMAIL)) {
            return true;
        }
        return false;
    }

//    public static Boolean checkDate(String date) {
//        if (date.matches("^((19\\d{2})|(200[0-4]))-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2]\\d)+|([3][0-1])+)$")) {
//            return true;
//        }
//        return false;
//    }

    public static Boolean checkNumber(int number) {
        if (Integer.toString(number).matches(REGEX_NUMBER)) {
            return true;
        }
        return false;
    }

    public static Boolean checkNumberPositive(int number) {
        boolean flag = false;
        try {
            if (number >= 0) {
                flag = true;
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static Boolean checkName(String name) {
        if (name.matches(REGEX_NAME)) {
            return true;
        }
        return false;
    }

    public static boolean checkDateFormat(final String date) {
        boolean flag = false;
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd").withResolverStyle(ResolverStyle.STRICT));
            flag = true;
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
//    public static Boolean checkKiTu(String name) {
//        if (name.matches("^\b+$")) {
//            return true;
//        }
//        return false;
//    }
//    public static boolean checkKiTuDatBiet(String kiTu) {
//        boolean flag = true;
//        if (kiTu.matches("[`!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~]")){
//            flag=false;
//        }
//        return flag;
//    }
}
