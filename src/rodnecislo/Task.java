package rodnecislo;

public class Task {
    public int suc(int a, int b){
        return a + b;
    }

    public boolean isPrimeNumber(int a){
        if (a <= 1)
            return false;
        for (int i = 2; i < Math.sqrt(a); i++)
            if (a % i == 0)
                return false;
        return true;
    }

    public boolean isRectangular(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <= 0)
            return false;
        return a * a == b * b + c * c || b * b == a * a + c * c || c * c == a * a + b * b;
    }

    public String reverse(String text){
        String reversed = "";
        for (int i = 0; i < text.length(); i++){
            char z = text.charAt(text.length()-1-i);
            reversed += z;
        }
        return reversed;
    }

    public int calculateSquare(int a){
        return a*a;
    }

    public boolean isNumberInString(String text){
        for (int i = 0; i < text.length(); i++){
            char z = text.charAt(i);
            if (z >= '0' && z <= '9')
                return true;
        }
        return false;
    }

    public boolean isThisTrue(){
        return true;
    }

    public double terminovanyVklad(int value, int year, double interest, boolean DPH){
        double newValue = value;
        if (year <= 0 || interest <= 0 || value <= 0)
            if (interest == 0 || year == 0)
                return value;
            else
                return 0;
        if (!DPH){
            for (int i = 0; i < year; i++)
                newValue = newValue + (newValue/100 * interest);
        }
        else {
            for (int i = 0; i < year; i++){
                newValue = newValue + (newValue/100 * interest)*0.8;
            }
        }

        return Math.round(newValue*100) / 100.0;
    }

    public double priceForTransport(int distance, double consumption, double petrolPrice){
        if (consumption < 0 || petrolPrice <= 0 || distance <= 0)
            return 0;
        double price = (distance/100.0) * consumption * petrolPrice;

        return Math.round(price*100)/100.0;
    }

    public int max(int[] array){
        int max = 0;
        if (array.length == 0)
            return 0;
        for (Integer integer : array){
            if (integer > max)
                max = integer;
        }
        return max;
    }

    public int max2(int[] array){
        int max1 = 0, max = 0;
        int repeat = 0;
        if (array.length <= 1)
            return 0;
        for (Integer integer : array){
            if (integer > max1)
                max1 = integer;
            else if (integer == max1)
                repeat -= -1;
        }
        if (repeat == array.length)
            return 0;
        for (Integer integer : array){
            if (integer > max && integer < max1)
                max = integer;
        }
        return max;
    }

    public boolean isPalindrom(int a){
        String text = String.valueOf(a);
        String reversed = "";
        for (int i = text.length()-1; i >= 0; i--){
            reversed += text.charAt(i);
        }
        return text.equals(reversed);
    }
}
