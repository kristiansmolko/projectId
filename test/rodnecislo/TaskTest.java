package rodnecislo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void suc(){
        Task task = new Task();
        assertEquals(0, task.suc(0,0));
        assertEquals(0, task.suc(5, -5));
        assertEquals(0, task.suc(-9999, 9999));
        assertEquals(47, task.suc(12, 35));
    }

    @Test
    void isPrimeNumber(){
        Task task = new Task();
        assertTrue(task.isPrimeNumber(7));
        assertTrue(task.isPrimeNumber(97));
        assertTrue(task.isPrimeNumber(13));
        assertTrue(task.isPrimeNumber(997));
        assertTrue(task.isPrimeNumber(859844473));
        assertFalse(task.isPrimeNumber(10));
        assertFalse(task.isPrimeNumber(8000));
        assertFalse(task.isPrimeNumber(50));
        assertFalse(task.isPrimeNumber(420000));
        assertFalse(task.isPrimeNumber(-2));
        assertFalse(task.isPrimeNumber(1 ));
    }

    @Test
    void isRectangular(){
        Task task = new Task();
        assertTrue(task.isRectangular(3,4,5));
        assertTrue(task.isRectangular(3,5,4));
        assertTrue(task.isRectangular(5,4,3));
        assertFalse(task.isRectangular(0,0,0));
        assertFalse(task.isRectangular(-3,-4,-5));
    }

    @Test void reversed(){
        Task task = new Task();
        assertEquals("joha", task.reverse("ahoj"));
        assertEquals("a dog", task.reverse("god a"));
    }

    @Test
    void calculateSquare(){
        Task task = new Task();
        assertEquals(4, task.calculateSquare(2));
        assertEquals(16, task.calculateSquare(4));
        assertEquals(25, task.calculateSquare(5));
        assertEquals(100, task.calculateSquare(10));
    }

    @Test
    void isNumberInString(){
        Task task = new Task();
        assertTrue(task.isNumberInString("ano1"));
        assertFalse(task.isNumberInString("ano"));
        assertFalse(task.isNumberInString("idk what to say"));
    }

    @Test
    void isThisTrue(){
        Task task = new Task();
        assertTrue(task.isThisTrue());
    }

    @Test
    void terminovanyVklad(){
        Task task = new Task();
        assertEquals(1100, task.terminovanyVklad(1000, 1, 10, false));
        assertEquals(1080, task.terminovanyVklad(1000, 1, 10, true));
        assertEquals(1259.71, task.terminovanyVklad(1000, 3, 10, true));
        assertEquals(1331, task.terminovanyVklad(1000, 3, 10, false));
        assertEquals(2000, task.terminovanyVklad(2000, 0, 10, false));
        assertEquals(100, task.terminovanyVklad(100, 10, 0, true));
        assertEquals(0, task.terminovanyVklad(100, -10, 10, true));
        assertEquals(0, task.terminovanyVklad(-100, 10, 20, true));
        assertEquals(100, task.terminovanyVklad(100, 10, -0, true));
        assertEquals(1500, task.terminovanyVklad(500, 1, 250, true));
    }

    @Test
    void priceForTransport(){
        Task task = new Task();
        assertEquals(30.94, task.priceForTransport(450, 5.5, 1.25));
        assertEquals(40.63, task.priceForTransport(500, 6.5, 1.25));
        assertEquals(7.35, task.priceForTransport(100, 4.9, 1.50));
        assertEquals(31.12, task.priceForTransport(540, 5.1, 1.13));
        assertEquals(1.51, task.priceForTransport(20, 7.7, 0.98));
        assertEquals(0, task.priceForTransport(-20, 5.5, 1.25));
        assertEquals(0, task.priceForTransport(450, -10, 1.25));
        assertEquals(0, task.priceForTransport(450, 5.5, -20));
    }

    @Test
    void max(){
        Task task = new Task();
        assertEquals(3, task.max(new int[]{0,1,2,3}));
        assertEquals(10, task.max(new int[]{10}));
        assertEquals(0, task.max(new int[]{}));
        assertEquals(9, task.max(new int[]{0,1,2,3,4,5,6,7,8,9}));
        assertEquals(3000, task.max(new int[]{0,100,-5,60,-52,3000}));
    }

    @Test
    void max2(){
        Task task = new Task();
        assertEquals(2, task.max2(new int[] {0,1,2,3}));
        assertEquals(1, task.max2(new int[] {3,3,3,3,3,3,1}));
        assertEquals(20, task.max2(new int[] {20,0,-5,6,10,60,19}));
        assertEquals(0, task.max2(new int[] {50}));
        assertEquals(0, task.max2(new int[] {}));
    }

    @Test
    void isPalindrom(){
        Task task = new Task();
        assertTrue(task.isPalindrom(121));
        assertTrue(task.isPalindrom(1001));
        assertTrue(task.isPalindrom(123321));
        assertTrue(task.isPalindrom(1));
        assertFalse(task.isPalindrom(12));
        assertFalse(task.isPalindrom(100));
        assertFalse(task.isPalindrom(1235));
    }

}