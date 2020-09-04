import TEST.TestPage;
import org.junit.Test;


public class MainTest extends TestPage
{

    @Test
    public void testRun() throws InterruptedException
    {

        loging();
        searchComputer();
        addRnd();
        myBaskett();
        deleteProduct();

    }
}
