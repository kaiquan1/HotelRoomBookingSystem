package Application;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = {TestCaseC001.class,
		TestCaseC002.class,
		TestCaseC003.class,
		TestCaseC004.class,
})

public class CancellationTestSuite {
}