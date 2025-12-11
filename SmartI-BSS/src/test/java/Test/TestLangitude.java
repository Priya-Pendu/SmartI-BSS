package Test;

import org.testng.annotations.Test;

public class TestLangitude {

	
	page p;
	
	@Test
	public void test() throws InterruptedException {
		p.setup("28.6139", "77.2090");
	}
}
