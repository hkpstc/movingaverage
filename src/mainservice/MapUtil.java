package mainservice;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class MapUtil {
                 public static String findMaXValue(Map<String ,Double> doubleMap,Map<Double ,String> stringMap){
                	 
                	 
                	Collection<Double> values= doubleMap.values();
                	 
                	double min=Collections.min(values);
                	
                	String weight_String =stringMap.get(min);
					return weight_String;
                	 
                	 
                	 
                	 
                 }
}
