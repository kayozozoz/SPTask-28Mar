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
	}

	@Test
	public void testQnTwo(){
		assertEquals("43556", Task.qnTwo("hello"));
		assertEquals("27753", Task.qnTwo("apple"));
	}

	@Test
	public void testQnThree(){
		assertEquals("[a, b, c]", Task.qnThree("2").toString());
	}

	@Test
	public void testQnFour(){
		assertEquals("[bell, cell]", Task.qnFour("2355").toString());
	}
}
