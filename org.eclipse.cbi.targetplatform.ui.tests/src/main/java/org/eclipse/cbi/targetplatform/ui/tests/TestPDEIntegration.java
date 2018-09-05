package org.eclipse.cbi.targetplatform.ui.tests;

import static org.junit.Assert.assertNotNull;

import org.eclipse.cbi.targetplatform.ui.handler.PDEIntegration;
import org.junit.Test;

public class TestPDEIntegration {

	@Test
	public void testAcquireService() {
		assertNotNull(new PDEIntegration());
	}
}
