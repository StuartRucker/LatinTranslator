import java.net.*;
import java.util.Scanner;


public class Wiktionairy {
	String[] partsSpeech = {"Noun","Adverb","Verb"};
	public Wiktionairy(){}
	public String search(String word){
		 String returns = "";
		try{
	    	URL wik = new URL("https://www.wiktionary.org/wiki/" + word+  	"?action=raw");
		    Scanner scan = new Scanner(wik.openStream());
		    
		    
		    boolean foundLatin = false;
		    boolean foundSpeechPart = false;
		    boolean foundInflection = false;
		    int count = 0;
		    while(scan.hasNextLine()){
		    	
		    	String nxt = scan.next();
		    	//System.out.println(nxt);
		    	if(foundLatin){
		    		foundLatin = !isLanguage(nxt);
		    	}
		    	if(foundLatin){	
		    		for(String worda: partsSpeech){
		    			if(nxt.indexOf("==="+worda +"===") != -1) foundSpeechPart = true;
		    		}
		    	}
		    	if(nxt.indexOf("==Latin==") !=-1){
		    		foundLatin = true;
		    	}
		    	if(nxt.indexOf("====Inflection====") !=-1){
		    		foundInflection = true;
		    	}
		    	else{
		    		if(nxt.indexOf("====") !=-1){
			    		foundInflection = false;
			    		foundSpeechPart = false;
			    	}
		    	}
		    	
		    	if(foundLatin && foundSpeechPart){
		    		returns += nxt + "\n";
		    		count ++;
		    	}
		    }

		    
		   
	   }catch(Exception e){returns = "in catch";}
	    if(returns.equals("")) returns = "null";
	    returns = returns.replaceAll("\n"," ");
	    returns = returns.replaceAll("#","\n");
	    returns = returns.replace("[", "");
	    returns = returns.replace("]", "");
	    //returns = returns.replaceAll("]", "");
	    
	    return returns;
	}
	public static boolean isLanguage(String a){
		int start = a.indexOf("==");
		if(start == -1) return false;
		
		int end = a.indexOf("==",start+3);
		if(end == -1) return false;
		
		boolean noMoreEquals = true;
		for(int i = start + 2; i < end; i ++){
			if(!Character.isLetter(a.charAt(i))) noMoreEquals = false;
		}
		return noMoreEquals;
		
		
	}
}
