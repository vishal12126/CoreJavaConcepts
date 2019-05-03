import static org.junit.Assert.*;

public class ReverseStringWithDotsTest {

    private ReverseStringWithDots rsv;

    @org.junit.Before
    public void setUp() throws Exception {
        this.rsv = new ReverseStringWithDots();

    }

    @org.junit.Test
    public void main() {
        String stest = "i.am.everywhere";
        String expected = "everywhere.am.i";
        String notExpected = "am.everywhere.i";
        assertEquals(expected , this.rsv.stringReverse(stest));
        assertNotEquals(notExpected , this.rsv.stringReverse(stest));
    }
}