package ec.app.batch;

public class JavaCallCPlus {
	static{  
        System.loadLibrary("libModifiedClassA"); 
    }  
   
public JavaCallCPlus() {}    


//native·½·¨ÉùÃ÷    
public native double getobj(String heuristic,long seed);  

public native double getsimpleobj(String heuristic);  
public native double getsimpleobjwithseed(String heuristic,long seed);  
} 