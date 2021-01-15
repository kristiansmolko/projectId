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
        assertEquals(0, task.terminovanyVklad(2000, 0, 10, false));
        assertEquals(0, task.terminovanyVklad(100, 10, 0, true));
    }

}