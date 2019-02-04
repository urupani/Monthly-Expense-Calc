package monthlyexpenses;

import java.io.IOException;
import java.util.Iterator;

public class MonthlyDiscount implements Discount {

	@Override
	public double calculateDiscount(double amount) {
		double finalBill=0;
		Slabs slabsObj = new Slabs();
		Iterator<SlabEntry> itr;
		try {
		itr = slabsObj.getMonthlyDiscountSlabList().iterator();
		while(itr.hasNext())
		{
			SlabEntry slabEntryObj = itr.next();	
			if(amount<=slabEntryObj.getMax() && amount>=slabEntryObj.getMin())
			{
				finalBill = amount-((slabEntryObj.getPercentDiscount()/100)*amount);
				//System.out.println("final bill"+finalBill);
			}
		}
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return finalBill;
	}

}
