package stc.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",
				features= {"src/test/resources/features/plan-type.feature"},
				glue={"stc.definitions"}, plugin= {})
public class CucumberRunner extends AbstractTestNGCucumberTests{

}
