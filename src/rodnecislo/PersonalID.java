package rodnecislo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class PersonalID {
    public boolean checkID(String id){
        if(id.length() < 9 || id.length() > 11)
            return false;

        int cDigits = 0;
        for (int i = 0; i < id.length(); i++)
            if (Character.isDigit(id.charAt(i)))
                cDigits++;

        if (cDigits < 9 || cDigits > 10)
                return false;
        if (id.length() == 11 && (cDigits != 10 || id.charAt(6) != '/'))
            return false;
        if (id.length() == 10 && cDigits == 9 && id.charAt(6) != '/')
            return false;
        if (id.charAt(2) != '0' && id.charAt(2) != '1' && id.charAt(2) != '5' && id.charAt(2) != '6')
            return false;
        if ((id.charAt(2) == '0' && id.charAt(3) < 0) || (id.charAt(2) == '1' && id.charAt(3) > 2))
            return false;

        if (cDigits == 9)
            id = id + '0';
        if (id.charAt(6) == '/')
            id = id.replace("/", "");

        if ((Long.parseLong(id) % 11) != 0) {
            System.out.println("Chyba, rodne cislo nie je delitelne 11");
            return false;
        }

        int day, month, year;
        day = Integer.parseInt(id.substring(4,6));
        month = Integer.parseInt(id.substring(2,4));
        if (id.charAt(2) == '5' || id.charAt(2) == '6')
            month -= 50;
        year = Integer.parseInt(id.substring(0,2));
        year = 2000 + year;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (year > currentYear) {
            year -= 100;
        }

        if (((id.charAt(2) == '0' && id.charAt(3) == '2') || (id.charAt(2) == '5' && id.charAt(3) == '2')) && year % 4 != 0)
            if (day > 28)
                return false;
        if (id.charAt(2) == '0' || id.charAt(2) == '5')
            switch (id.charAt(3)){
                case '1', '3', '5', '7', '8': if (day > 31) return false; break;
                case '4', '6', '9': if (day > 30) return false;
            }
        else if (id.charAt(2) == '1' || id.charAt(2) == '6')
            switch (id.charAt(3)){
                case '0', '2': if (day > 31) return false; break;
                case '1': if (day > 30) return false;
            }

        getDays(day, month, year);
        getRetirement(year);
        String dayIn = getDayInBirthMonth(day, month, year);
        System.out.println("You were born on " + dayIn);

        return true;
    }

    public static void main(String[] args) {
        PersonalID person = new PersonalID();
        System.out.println(person.checkID("010510/1238"));
        //975228/1242 975229/1241
    }

    public void getDays(int day, int month, int year){
        Date today = new Date();
        DateFormat y = new SimpleDateFormat("yyyy");
        DateFormat m = new SimpleDateFormat("MM");
        DateFormat d = new SimpleDateFormat("dd");
        int todayYear = Integer.parseInt(y.format(today));
        int todayMonth = Integer.parseInt(m.format(today));
        int todayDay = Integer.parseInt(d.format(today));
        int count = 0;
        int countDay = day, countMonth = month, countYear = year;
        if (month > 50)
            countMonth -= 50;
        while (todayYear >= year){
            countDay++;
            switch(countMonth){
                case 1, 3, 5, 7, 8, 10, 12: if (countDay > 31) {countMonth++; countDay = 1;} break;
                case 4, 6, 9, 11: if (countDay > 30) {countMonth++; countDay = 1;} break;
                case 2 :
                    if (countYear % 4 == 0) {
                        if (countDay > 28) {
                            countMonth++;
                            countDay = 1;
                        }
                    }
                    else
                    if (countDay > 27){
                        countMonth++;
                        countDay = 1;
                    }
            }
            if (countMonth > 12){
                countYear++;
                countMonth = 1;
            }
            count++;
            if (todayYear == countYear && todayMonth == countMonth && todayDay == countDay)
                break;
        }
        count += (todayYear - year)/4;
        System.out.println("You are " + count + " days old!");
    }

    public void getRetirement(int year){
        Date today = new Date();
        DateFormat y = new SimpleDateFormat("yyyy");
        int todayYear = Integer.parseInt(y.format(today));

        //retirement
        int retirement = 62;
        if (todayYear-year < retirement)
            System.out.println("You should go to retirement in: " + (retirement-(todayYear - year)) + " years");
        else
            System.out.println("You should already be retired");
    }

    public String getDayInBirthMonth(int day, int month, int year){
        int k = day;
        int m = month<2?month+10:month-2;
        int D = year%100;
        int C = year/100;
        int Zeller = k + ((13*m-1)/5) + D + (D/4) + (C/4) - 2*C;
        //what day of week it was
        if (Zeller%7 < 0){
            return switch((-(Zeller%7+1)*7) + Zeller){
                case 1 -> "Monday";
                case 2 -> "Tuesday";
                case 3 -> "Wednesday";
                case 4 -> "Thursday";
                case 5 -> "Friday";
                case 6 -> "Saturday";
                default-> "Sunday";
            };
        }
        return switch(Zeller%7){
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Sunday";
        };
    }
}
