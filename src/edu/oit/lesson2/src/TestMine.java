/**
 * Created by IT on 2017/4/20.
 */

import org.junit.*;


public class TestMine {
     @Test
     public void firstTest() {
          Assert.assertTrue(true);
     }

     @Test
     public void testDaycountTest(){
          Assert.assertEquals(Main.daycount(2017,2),28);
     }
}

