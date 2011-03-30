package com.iss.gda;

import java.io.BufferedInputStream;
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.util.Arrays;  
import java.util.Comparator;  
import java.util.Enumeration;  
import java.util.HashMap;  
import java.util.Map;  
import java.util.Properties;  
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;  
import java.util.Set;  

public class Test {

	  public static void main(String[] args) throws Exception{  
	        
		    for(int i=0;i<4;i++){
		    Map<String, String> map1 = new HashMap<String, String>();  
	        map1.put("aa", "7");  
	        map1.put("bb", "9");  
	        map1.put("cc", "3");  
	        writeProperties("test", map1);  
		    } 
	        Map map = getBundleInfoMap("test");  
	          
	        Map.Entry<String, Integer>[] entry = getSortedHashtableByValue(map);  
	          
	        for (int i = 0; i < entry.length; i++) {  
	            System.out.println(entry[i]);  
	        }  
	          
	    }  
	      
	    public static Map<String, Integer> getBundleInfoMap(String bundleName)throws Exception {  
	        //ResourceBundle rb = ResourceBundle.getBundle(bundleName);  
	        
	        String path = "E:\\iESBtest\\axis2-1.5.2\\bin\\src\\config"+"\\"+bundleName+".properties";
	        //ResourceBundle rb = ResourceBundle.getBundle(bundleName);
	        
		    InputStream in = new BufferedInputStream(new FileInputStream(path));
		    
		   
		    ResourceBundle rb = new PropertyResourceBundle(in);
	        Map<String, Integer> map = new HashMap<String, Integer>();  
	          
	        Enumeration<String> en = rb.getKeys();  
	          
	        while(en.hasMoreElements()) {  
	        String key = en.nextElement();  
	            map.put(key, Integer.valueOf(rb.getString(key)));  
	        }  
	        return map;  
	    }  
	 
	    /** 
	     * @param map 
	     * @return the entries of the map after being sorted 
	     */ 
	    @SuppressWarnings("unchecked")  
	    public static Map.Entry[] getSortedHashtableByValue(Map<String, Integer> map) {  
	        Set set = map.entrySet();  
	        Map.Entry[] entries = (Map.Entry[]) set.toArray(new Map.Entry[set.size()]);  
	        Arrays.sort(entries, new Comparator() {  
	            public int compare(Object arg0, Object arg1) {  
	                Long key1 = Long.valueOf(((Map.Entry) arg0).getValue().toString());  
	                Long key2 = Long.valueOf(((Map.Entry) arg1).getValue().toString());  
	                return key1.compareTo(key2);  
	            }  
	        });  
	 
	        return entries;  
	    }  
	      
	    @SuppressWarnings("unchecked")  
	    public static void writeProperties(String filePath, Map<String, String> map) { 
	    	
	    	 filePath = "E:\\iESBtest\\axis2-1.5.2\\bin\\src\\config"+"\\"+filePath+".properties";
	        Properties prop = new Properties();  
	        InputStream fis = null;  
	        OutputStream fos = null;  
	        try {  
	            fis = new FileInputStream(filePath);  
	            
	            prop.load(fis);  
	            fos = new FileOutputStream(filePath);  
	               
	            Set set = map.entrySet();  
	            Map.Entry[] entries = (Map.Entry[]) set.toArray(new Map.Entry[set.size()]);  
	              
	            for (int i = 0; i < entries.length; i++) {  
	                String key = (String)entries[i].getKey();  
	                String value = (String)entries[i].getValue();  
	                prop.setProperty(key, value);  
	                prop.store(fos, "Update key :"+key+" value :"+value); 
	              
	            }  
	            fos.flush();  
	        } catch (IOException e) {  
	            System.err.println("error occurred");  
	        } finally {  
	            try {  
	                fos.close();  
	                fis.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
}
