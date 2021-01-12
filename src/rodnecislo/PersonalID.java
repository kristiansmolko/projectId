package rodnecislo;

import java.util.Calendar;

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
                case '2', '4', '6', '9': if (day > 30) return false;
            }
        else if (id.charAt(2) == '1' || id.charAt(2) == '6')
            switch (id.charAt(3)){
                case '0', '2': if (day > 31) return false; break;
                case '1': if (day > 30) return false;
            }


        System.out.println(day + "-" + month + "-" + year);

        return true;
    }

    public static void main(String[] args) {
        PersonalID person = new PersonalID();
        System.out.println(person.checkID("970531/1242"));
        //975228/1242 975229/1241
    }
}
