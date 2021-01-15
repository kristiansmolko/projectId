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
            return 0;
        if (!DPH){
            for (int i = 0; i < year; i++)
                newValue = newValue + (newValue/interest);
        }
        else {
            for (int i = 0; i < year; i++){
                double add = (newValue/interest)*0.8;
                newValue = newValue + add;
            }
        }

        return Math.round(newValue*100) / 100.0;
    }
}
