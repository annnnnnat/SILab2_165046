import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private List<Time> createList(Time... elems){
        return new ArrayList<Time>(Arrays.asList(elems));
    }
    private List<Integer> createInt(Integer... elems){
        return new ArrayList<>(Arrays.asList(elems));
    }
@Test
void testMultipleChoices(){
    RuntimeException ex;
    //1.hr < 0 || hr > 24
    //T || X -> hr < 0
    ex = assertThrows(RuntimeException.class,() -> SILab2.function(createList(new Time(-1,0,0))));
    assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

    //F || T -> hr > 24
    ex = assertThrows(RuntimeException.class,() -> SILab2.function(createList(new Time(25,0,0))));
    assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

    //F || F -> 0=>hr<=24
    assertEquals(createInt(0),SILab2.function(createList(new Time(0,0,0))));

    //2.min < 0 || min > 59
    //T || X -> min < 0
    ex = assertThrows(RuntimeException.class,() -> SILab2.function(createList(new Time(2,-1,0))));
    assertTrue(ex.getMessage().contains("The minutes are not valid!"));

    //F || T -> min > 59
    ex = assertThrows(RuntimeException.class,() -> SILab2.function(createList(new Time(2,66,0))));
    assertTrue(ex.getMessage().contains("The minutes are not valid!"));

    //F || F -> 0=>min<=59
    assertEquals(createInt(8520),SILab2.function(createList(new Time(2,22,0))));

    //3.sec >= 0 && sec <= 59

    //F && X -> sec < 0
    ex = assertThrows(RuntimeException.class,() -> SILab2.function(createList(new Time(2,2,-22))));
    assertTrue(ex.getMessage().contains("The seconds are not valid"));

    //T && F -> 0<=sec>59
    ex = assertThrows(RuntimeException.class,() -> SILab2.function(createList(new Time(2,2,66))));
    assertTrue(ex.getMessage().contains("The seconds are not valid"));

    //T && T -> 0<=sec<=59
    assertEquals(createInt(55),SILab2.function(createList(new Time(0,0,55))));

    //4.hr == 24 && min == 0 && sec == 0
    //F && X && X -> hr!=24,min=anything,sec=anything
    assertEquals(createInt(7200),SILab2.function(createList(new Time(2,0,0))));
    //T && F && X -> hr=24,min!=0, sec= anything
    ex = assertThrows(RuntimeException.class,() -> SILab2.function(createList(new Time(24,1,0))));
    assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

    //T && T && F -> hr=24,min=0,sec!=0
    ex = assertThrows(RuntimeException.class,() -> SILab2.function(createList(new Time(24,0,1))));
    assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

    //T && T && T -> hr=24,min=0,sec=0
    assertEquals(createInt(86400),SILab2.function(createList(new Time(24,0,0))));

}

    @Test
    void testEveryBranch() {
        RuntimeException ex;

        //timeList={ (hr=-5,min=anything,sec=anything))}
        ex = assertThrows(RuntimeException.class,() -> SILab2.function(createList(new Time(-5,0,0))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        //timeList={ (hr=27,min=anything,sec=anything)}
        ex = assertThrows(RuntimeException.class,() -> SILab2.function(createList(new Time(27,0,0))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        //timeList={ (hr=20,min=62,sec=anything)}
        ex = assertThrows(RuntimeException.class,() -> SILab2.function(createList(new Time(20,62,0))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        //timeList={ (hr=20,min=40,sec=-20)}
        ex = assertThrows(RuntimeException.class,() -> SILab2.function(createList(new Time(20,40,-20))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        //timeList={ (hr=20,min=40,sec=10),(hr=24,min=0,sec=0)}
        assertEquals(createInt(74410,86400),SILab2.function(createList(new Time(20,40,10),new Time(24,0,0))));

        //timeList={hr=24,min=2,sec = anything}
        ex = assertThrows(RuntimeException.class,() -> SILab2.function(createList(new Time(24,2,0))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

    }
}