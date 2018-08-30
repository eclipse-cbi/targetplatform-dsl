package org.eclipse.cbi.targetplatform.tests.stubs.p2;

import java.net.URI;
import java.util.List;

public interface IQueryResultProvider<T> {

	List<T> listIUs(URI location);
	
}
