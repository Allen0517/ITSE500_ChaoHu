import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IT on 2017/4/23.
 */
public class ReverseStringTest {


//    @Test
//    public void testReverseString() {
//        StringBuffer str = new StringBuffer("student");
//        assertEquals(ReverseString.reverseString(str),"tneduts");
//        assertEquals(reverseStr.reverseString(str.append("abc def")), "fed cba");
//        assertEquals(reverseStr.reverseString(str.append("100th Street")), "teertS ht001");
//    }

    @Test
        public void testReverseStr() {
            assertEquals(ReverseString.reverseStr("student"),"tneduts");
            assertEquals(ReverseString.reverseStr("abc def"),"fed cba");
            assertEquals(ReverseString.reverseStr("100th Street"),"teertS ht001");
        }
}