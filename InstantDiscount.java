package monthlyexpenses;

import java.io.IOException;
import java.util.Iterator;

public class InstantDiscount implements Discount {

	@Override
	public double calculateDiscount(double amount) {
		double amountAfterInstantDiscount=0;
		Slabs slabsObj = new Slabs();
		System.out.println("merge test");
		Iterator<SlabEntry> itr;
		try {
		itr = slabsObj.getInstantDiscountSlabList().iterator();
		while(itr.hasNext())
		{
			SlabEntry slabEntryObj = itr.next();
			if(amount<=slabEntryObj.getMax() && amount>=slabEntryObj.getMin())
			{
				amountAfterInstantDiscount = amount-((slabEntryObj.getPercentDiscount()/100)*amount);
				//System.out.println("amountAfterInstantDiscount"+amountAfterInstantDiscount);
			}
		}
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return amountAfterInstantDiscount;
	}

}
