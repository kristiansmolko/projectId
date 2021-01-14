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
}
