package org.eclipse.cbi.targetplatform.ui.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestContentAssist.class,
	TargetPlatformHyperlinkingTest.class
})
public class AllUITests {

}
