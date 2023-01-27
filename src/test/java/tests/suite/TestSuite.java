package tests.suite;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import tests.pages.LK.LoginPositiveTest;

@SelectClasses({LoginPositiveTest.class})
@SuiteDisplayName("TestSuiteJoyMoney")
@ExcludeTags({ "Recovery", "Loan"})
@Suite
public class TestSuite {

}
