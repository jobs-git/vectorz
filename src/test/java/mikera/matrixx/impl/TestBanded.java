package mikera.matrixx.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import mikera.matrixx.AMatrix;
import mikera.matrixx.Matrix;
import mikera.vectorz.Vector;

public class TestBanded {

	@Test
	public void testBandwidths() {
		Matrix m=Matrix.create(6, 6);
		
		assertEquals(0,m.upperBandwidth());
		assertEquals(5,m.upperBandwidthLimit());
		assertEquals(0,m.lowerBandwidth());
		assertEquals(5,m.lowerBandwidthLimit());
		
		m.getBand(-1).fill(1.0);
		assertEquals(0,m.upperBandwidth());
		assertEquals(1,m.lowerBandwidth());
	}
	
	@Test
	public void testBandedBandwidth() {
		AMatrix m=BandedMatrix.create(6, 6, -6, 6);
		
		assertEquals(0,m.upperBandwidth());
		assertEquals(5,m.upperBandwidthLimit());
		assertEquals(0,m.lowerBandwidth());
		assertEquals(5,m.lowerBandwidthLimit());
		
		m.getBand(-1).fill(1.0);
		assertEquals(0,m.upperBandwidth());
		assertEquals(1,m.lowerBandwidth());
	}
	
	@Test
	public void testBandedSubMatrix() {
		AMatrix m=DiagonalMatrix.create(1,2,3,4,5);
		AMatrix sm=m.subMatrix(2, 3, 1, 3);
		assertEquals(Vector.of(3,4),sm.getBand(1));
	}

}
