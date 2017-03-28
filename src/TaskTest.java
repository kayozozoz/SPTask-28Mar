import static org.junit.Assert.*;

import java.io.IOException;

import javax.swing.text.BadLocationException;

import org.junit.Test;


public class TaskTest {
	
	public TaskTest() throws IOException, BadLocationException{
		Task.preprocessing();
	}
	
	@Test
	public void testQnOne(){
		assertEquals(13, Task.qnOne("hello"));
		assertEquals(8, Task.qnOne("apple"));
		assertEquals(9, Task.qnOne("banana"));
		assertEquals(5, Task.qnOne("cat"));
		assertEquals(13, Task.qnOne("donkey"));
	}

	@Test
	public void testQnTwo(){
		assertEquals("43556", Task.qnTwo("hello"));
		assertEquals("27753", Task.qnTwo("apple"));
		assertEquals("226262", Task.qnTwo("banana"));
		assertEquals("228", Task.qnTwo("cat"));
		assertEquals("366539", Task.qnTwo("donkey"));
	}

	@Test
	public void testQnThree(){
		assertEquals("[a, b, c]", Task.qnThree("2").toString());
		assertEquals("[ad, ae, af, bd, be, bf, cd, ce, cf]", Task.qnThree("23").toString());
		assertEquals("[gj, gk, gl, hj, hk, hl, ij, ik, il]", Task.qnThree("45").toString());
		assertEquals("[jad, jae, jaf, jbd, jbe, jbf, jcd, jce, jcf, kad, kae, kaf, kbd, kbe, kbf, kcd, kce, kcf, lad, lae, laf, lbd, lbe, lbf, lcd, lce, lcf]", Task.qnThree("523").toString());
		assertEquals(null, Task.qnThree("01"));		
	}

	@Test
	public void testQnFour(){
		assertEquals("[bell, cell]", Task.qnFour("2355").toString());
		assertEquals("[gone, good, goof, home, hone, hood, hoof]", Task.qnFour("4663").toString());
		assertEquals("[aardvark]", Task.qnFour("22738275").toString());
		assertEquals("[untilt]", Task.qnFour("868458").toString());
		assertEquals(null, Task.qnFour("012"));		
	}
}
