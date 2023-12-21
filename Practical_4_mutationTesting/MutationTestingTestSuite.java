import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ MutantTest.class, OriginalProgramTest.class })
public class MutationTestingTestSuite {

}
