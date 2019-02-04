package monthlyexpenses;
import java.io.*;
import java.util.*;

public class Slabs {
	List <SlabEntry> getInstantDiscountSlabList() throws NumberFormatException, IOException{
		FileReader file = new FileReader("D:\\Unnati_Novopay\\Instant.txt");
		BufferedReader br = new BufferedReader(file);
		
		List<SlabEntry> instantDiscountSlabList = new ArrayList<SlabEntry>(); 
		String st= null;
		while((st = br.readLine())!=null)
		{
			SlabEntry slabEntryObj = new SlabEntry();
			String[] stArr=st.split(" ");
			double discount = Double.parseDouble(stArr[1]);
			String[] stArr2=stArr[0].split("-");
			double min = Double.parseDouble(stArr2[0]);
			double max = Double.parseDouble(stArr2[1]);
			slabEntryObj.setMin(min);
			slabEntryObj.setMax(max);
			slabEntryObj.setPercentDiscount(discount);
			instantDiscountSlabList.add(slabEntryObj);
			
		}
		br.close();
		return instantDiscountSlabList;
	}
	
	List <SlabEntry> getMonthlyDiscountSlabList() throws NumberFormatException, IOException{
		FileReader file = new FileReader("D:\\Unnati_Novopay\\Monthly.txt");
		BufferedReader br = new BufferedReader(file);
		List<SlabEntry> monthlyDiscountSlabList = new ArrayList<SlabEntry>(); 
		String st= null;
		while((st = br.readLine())!=null)
		{
			SlabEntry slabEntryObj = new SlabEntry();
			String[] stArr=st.split(" ");
			double discount = Double.parseDouble(stArr[1]);
			String[] stArr2=stArr[0].split("-");
			double min = Double.parseDouble(stArr2[0]);
			double max = Double.parseDouble(stArr2[1]);
			slabEntryObj.setMin(min);
			slabEntryObj.setMax(max);
			slabEntryObj.setPercentDiscount(discount);
			monthlyDiscountSlabList.add(slabEntryObj);
		}
		br.close();
		return monthlyDiscountSlabList;

		
	}

}
