package com.mulesoft.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.annotations.param.InboundHeaders;
import org.mule.api.annotations.param.Payload;
//constructor for singleton pattern
public class MuleComponent {
	int count;
	
	public MuleComponent(){
		count = 1;
		
		
	}
	
	
	
// reflection based resolution
  public Map<String,String> processMap(Map<String,String > input) {
	  
    // processMap implementation
	  input.put("processedBy","processMap" );
    return input;
  }

  public Map<String,String> processArray(List<String> input ) {
    // processArray implementation
	Map<String, String > output = new HashMap<String, String>();
	output.put("message", input.get(0));
	output.put("processedBy", "processedArray");
	return output;
   
  }

  public Map<String,String> processString(String input) {
	  Map<String, String > output = new HashMap<String, String>();
		output.put("message", input);
		output.put("processedBy", "processedString");
		return output;
	   
  }
  //annotation based resolution
  public Map<String,Object> processAll( @Payload Object input, @InboundHeaders("http.method") String method ) {
	  Map<String, Object > output = new HashMap<String, Object>();
		output.put("message", input.toString());
		output.put("processedBy", "processedString");
		output.put("http.method", method);
		output.put("currentCount", count);
		//does not increment each time as this is prototype and then when singleton is implemented it increments every time as it is a new instance
		count++;
		return output;
	   
  }
  
  


} 
