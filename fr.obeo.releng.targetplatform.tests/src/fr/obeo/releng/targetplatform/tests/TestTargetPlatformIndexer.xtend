package fr.obeo.releng.targetplatform.tests

import com.google.inject.Inject
import com.google.inject.Provider
import fr.obeo.releng.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(TargetPlatformInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestTargetPlatformIndexer {
	
	@Inject
	ParseHelper<TargetPlatform> parser
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider
	
	@Inject
	LocationIndexBuilder indexBuilder
	
	@Test
	def testIncludeOverrideOrder() {
		val resourceSet = resourceSetProvider.get
		val o = parser.parse('''target "o" include "a.tpd" include "b.tpd" include "c.tpd"''', 
			URI.createURI("tmp:/o.tpd"), resourceSet
		)
		parser.parse('''target "a" include "d.tpd" include "e.tpd" include "f.tpd"''', 
			URI.createURI("tmp:/a.tpd"), resourceSet
		)
		parser.parse('''target "b" include "g.tpd" include "h.tpd" include "i.tpd"''', 
			URI.createURI("tmp:/b.tpd"), resourceSet
		)
		parser.parse('''target "c" include "j.tpd" include "k.tpd" include "l.tpd"''', 
			URI.createURI("tmp:/c.tpd"), resourceSet
		)
		for (tp : #['d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l']) {
			parser.parse('''target "«tp»"''', 
			URI.createURI('''tmp:/«tp».tpd'''), resourceSet)
		}
		assertEquals(
			#['c', 'b', 'a', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd'],
			indexBuilder.getImportedTargetPlatforms(o).map[name]
		)
	}
	
	@Test
	def testIncludeOverrideOrder2() {
		val resourceSet = resourceSetProvider.get
		val o = parser.parse('''target "o" include "a.tpd" include "b.tpd" include "c.tpd"
		location "o1"
		''', 
			URI.createURI("tmp:/o.tpd"), resourceSet
		)
		parser.parse('''target "a" include "d.tpd" include "e.tpd" include "f.tpd"
		location "a1"
		''', 
			URI.createURI("tmp:/a.tpd"), resourceSet
		)
		parser.parse('''target "b" include "g.tpd" include "h.tpd" include "i.tpd"
		location "b1"''', 
			URI.createURI("tmp:/b.tpd"), resourceSet
		)
		parser.parse('''target "c" include "j.tpd" include "k.tpd" include "l.tpd"
		location "c1"''', 
			URI.createURI("tmp:/c.tpd"), resourceSet
		)
		for (tp : #['d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l']) {
			parser.parse('''target "«tp»"
			location "«tp»1"''', 
			URI.createURI('''tmp:/«tp».tpd'''), resourceSet)
		}
		
		assertArrayEquals(
			#['o1', 'c1','l1', 'k1', 'j1',  'b1', 'i1', 'h1', 'g1', 'a1', 'f1', 'e1', 'd1'],
			indexBuilder.getLocationIndex(o).keySet
		)
	}
	
	@Test
	def testIncludeOverrideOrder3() {
		val resourceSet = resourceSetProvider.get
		val o = parser.parse('''target "o" 
		include "a.tpd" 
		include "b.tpd" 
		location "o1"
		include "c.tpd"
		''', 
			URI.createURI("tmp:/o.tpd"), resourceSet
		)
		parser.parse('''target "a" 
		include "d.tpd" 
		location "a1"
		include "e.tpd" 
		include "f.tpd"
		''', 
			URI.createURI("tmp:/a.tpd"), resourceSet
		)
		parser.parse('''target "b" 
		location "b1"
		include "g.tpd" 
		include "h.tpd" 
		include "i.tpd"''', 
			URI.createURI("tmp:/b.tpd"), resourceSet
		)
		parser.parse('''target "c" 
		include "j.tpd" 
		include "k.tpd" 
		include "l.tpd"
		location "c1"''', 
			URI.createURI("tmp:/c.tpd"), resourceSet
		)
		for (tp : #['d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l']) {
			parser.parse('''target "«tp»"
			location "«tp»1"''', 
			URI.createURI('''tmp:/«tp».tpd'''), resourceSet)
		}
		
		assertArrayEquals(
			#['c1', 'l1', 'k1', 'j1', 'o1', 'i1', 'h1', 'g1', 'b1', 'f1', 'e1', 'a1', 'd1'],
			indexBuilder.getLocationIndex(o).keySet
		)
	}
	
	@Test
	def testRemoteInclude() {
		val resourceSet = resourceSetProvider.get
		val o = parser.parse('''
			target "o" 
			include "http://git.eclipse.org/c/emfcompare/org.eclipse.emf.compare.git/plain/org.eclipse.emf.compare-parent/targetPlatforms/kepler-sdk.targetplatform?id=e9fbfd866f648083df83174d566ee1b9d61daeca" 
			''', 
			URI.createURI("tmp:/o.tpd"), resourceSet
		)
		val index = indexBuilder.getLocationIndex(o)
		assertEquals(4, index.size)
	}
}