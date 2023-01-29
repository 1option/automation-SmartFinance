package tests.suite;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages({"tests.pages.authorization", "tests.pages.LK"})
@SuiteDisplayName("Test Suites JoyMoney")
@ExcludeTags("Loan")
@Suite
public class TestSuite {

}
