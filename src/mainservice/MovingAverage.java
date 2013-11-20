package mainservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovingAverage {
       public static double step=0.03;
	public static double[] movingaverage_foreachweight(double[] weekDemandArray) {
		double[] movingaverage_weight_array = new double[5];
		Map<String,Double> inaccuracy_array=new HashMap<String,Double>();
		Map<Double,String> inaccuracy_array_index=new HashMap<Double,String>();
		
		for (double weight_week5 = 1; weight_week5 > 0; weight_week5 = weight_week5 - step) {
			for (double weight_week4 = weight_week5 - step; weight_week4 >= 0; weight_week4 = weight_week4 - step) {
				for (double weight_week3 = weight_week4 - step; weight_week3 >= 0; weight_week3 = weight_week3 - step) {
					for (double weight_week2 = weight_week3 - step; weight_week2 >= 0; weight_week2 = weight_week2 - step) {
						for (double weight_week1 = weight_week2 - step; weight_week1 >= 0; weight_week1 = weight_week1 - step) {
                             
							movingaverage_weight_array[0] = weight_week1;
							movingaverage_weight_array[1] = weight_week2;
							movingaverage_weight_array[2] = weight_week3;
							movingaverage_weight_array[3] = weight_week4;
							movingaverage_weight_array[4] = weight_week5;
							
                       Double inaccuracy=caculatePredictValueArray( weekDemandArray,movingaverage_weight_array,false);
                       String weight_string=weight_week1+","+weight_week2+","+weight_week3+","+weight_week4+","+weight_week5+",";
                       inaccuracy_array.put(weight_string,inaccuracy);
                       inaccuracy_array_index.put(inaccuracy, weight_string);
                     System.out.println("误差"+inaccuracy);
						}

					}

				}

			}
               
		}
		String weight_String=  MapUtil.findMaXValue(inaccuracy_array, inaccuracy_array_index);
		double inaccuracy_average=inaccuracy_array.get(weight_String)/weekDemandArray.length;
        System.out.println(weight_String+"误差"+inaccuracy_average);
        double[] movingaverage_weight_array_min_inaccuracy=ArrayUtil.splitStringToDoubleArray(weight_String);
		return movingaverage_weight_array_min_inaccuracy;

	}

	public static double caculatePredictValueArray(double[] weekDemandArray,
			double[] movingaverage_weight_array,boolean outputpredictvalue) {
	 double	inaccuracy_sum=0;
		for (int i=0;i<weekDemandArray.length-5;i++){
    		double oneweek_predictarray[]=new double[5];
    		oneweek_predictarray[0]=weekDemandArray[i];
    		oneweek_predictarray[1]=weekDemandArray[i+1];
    		oneweek_predictarray[2]=weekDemandArray[i+2];
    		oneweek_predictarray[3]=weekDemandArray[i+3];
    		oneweek_predictarray[4]=weekDemandArray[i+4];    
			

			double predictvalue = oneweek_predictarray[0] * movingaverage_weight_array[0]//计算平均值
					+ oneweek_predictarray[1] * movingaverage_weight_array[1]
					+ oneweek_predictarray[2] * movingaverage_weight_array[2]
					+ oneweek_predictarray[3] * movingaverage_weight_array[3]
					+ oneweek_predictarray[4] * movingaverage_weight_array[4];
			
			
			predictvalue=predictvalue/(movingaverage_weight_array[0]+movingaverage_weight_array[1]
					+movingaverage_weight_array[2]+movingaverage_weight_array[3]+movingaverage_weight_array[4]);
			
			if((predictvalue-Math.ceil(predictvalue))>=0.2  ){//2舍3入
				predictvalue=1+Math.ceil(predictvalue);
			}
			if((predictvalue-Math.ceil(predictvalue))<0.2 ){//2舍3入
				predictvalue=0+Math.ceil(predictvalue);
			}
			if(oneweek_predictarray[4]==0 && oneweek_predictarray[3]==0){
				predictvalue=0; 
			}
			
			
			if(outputpredictvalue){
				System.out.println(predictvalue+","+weekDemandArray[i+5]);
			}
			double inaccuracy=Math.abs((predictvalue-weekDemandArray[i+5]));
			inaccuracy_sum=inaccuracy+inaccuracy_sum;
   	 }
		     return inaccuracy_sum;
		

	}

	
	
	
	public static double[] movingaverage(double[] weekDemandArray,double[] movingaverage_weight_array) {
		            Double inaccuracy=caculatePredictValueArray( weekDemandArray,
                      			 movingaverage_weight_array,true);

		double inaccuracy_average=inaccuracy/weekDemandArray.length;
        System.out.println("误差"+inaccuracy_average);
		return movingaverage_weight_array;

	}
}
