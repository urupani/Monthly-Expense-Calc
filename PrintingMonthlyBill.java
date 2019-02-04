package monthlyexpenses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
public class PrintingMonthlyBill {

	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("D:\\Unnati_Novopay\\testFile.txt");
		BufferedReader br = new BufferedReader(file);
		//Discount discount;
		InstantDiscount instDiscObj = new InstantDiscount();
		MonthlyDiscount monDiscObj = new MonthlyDiscount();
		Map <Integer, Double> hmap = new HashMap<Integer, Double>();
		//Set<Entry<Integer, Double>> set = hmap.entrySet();
		double calcAmountForMonthlyDisc ;
		//long lineCount = br.lines().count();
		br = new BufferedReader(file);
		String line = br.readLine();
		while(line != null && line.length() > 0)
		{
			String[] lineArr = line.split(" ");
			String[] lineArr2 = lineArr[0].split("/");
			double amount =(double) Double.parseDouble(lineArr[1]);
		    int month =(int) Integer.parseInt(lineArr2[1]);
			Double amountAfterInstantDiscount = instDiscObj.calculateDiscount(amount);
			if(hmap.containsKey(month))
			{
				calcAmountForMonthlyDisc = amountAfterInstantDiscount + hmap.get(month);
				hmap.put(month,calcAmountForMonthlyDisc);
			}
			else
			{
				
			hmap.put(month,amountAfterInstantDiscount);
			//System.out.println(hmap.values());
			}
			line = br.readLine();
		}
		Iterator<Entry<Integer, Double>> hmIterator =  hmap.entrySet().iterator();
		while(hmIterator.hasNext())
		{
			Map.Entry<Integer,Double> mapElement = hmIterator.next(); 
			double finalBill = monDiscObj.calculateDiscount(mapElement.getValue());
			System.out.println("Monthly Expense: " + finalBill);
		}
		br.close();		
		
	}

}
