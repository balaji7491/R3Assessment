package hooks;

import exchange.v6.testUSD.TestUSD;
import org.testng.annotations.BeforeClass;
import restProtocol.Base;

public class Hooks {
    TestUSD testUSD = new TestUSD();

    @BeforeClass
    public void setup(){
        testUSD.testUSDEndpoint();
    }

}
