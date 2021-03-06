import org.junit.Test;
import org.sitenv.referenceccda.validator.RefCCDAValidationResult;
import org.sitenv.referenceccda.validator.ReferenceCCDAValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

public class RefCCDATest {

	@Test
	public void test() {
		
		URL url = this.getClass().getResource("/Sample.xml");
		
		StringBuilder sb = new StringBuilder();
	    try
	    {
	    	BufferedReader br = new BufferedReader(new FileReader(url.getPath()));
	    	
	    	String sCurrentLine = "";
	    	while ((sCurrentLine = br.readLine()) != null) {
	            sb.append(sCurrentLine);
	        }
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.toString());
	    }

	    System.out.println(sb.toString());
		
	    ArrayList<RefCCDAValidationResult> results = 
	    		ReferenceCCDAValidator.validateCCDAWithReferenceFileName("Test", "Test", sb.toString());
	    
	    System.out.println("No of Entries = " + results.size());
	    
	    
		System.out.println("*****************Success******************");
	}

}
