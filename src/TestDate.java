import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


//
/////////////////////////////////////////////////////////////////
//                 C O P Y R I G H T  (c) 2014
//             A G F A - G E V A E R T  G R O U P
//                    All Rights Reserved
/////////////////////////////////////////////////////////////////
//
//       THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
//                    Agfa-Gevaert Group
//      The copyright notice above does not evidence any
//     actual or intended publication of such source code.
//
/////////////////////////////////////////////////////////////////
//
//

public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Calendar dobC = Calendar.getInstance();
		dobC.set(2015, Calendar.FEBRUARY, 16, 0,0,0);
		System.out.println(dobC.getTime());
		Calendar createC = Calendar.getInstance();
		createC.set(2014, Calendar.APRIL, 13, 0,0,0);
		Calendar nowC = Calendar.getInstance();
		nowC.set(2014, Calendar.APRIL, 13, 0,51,31);
		Calendar nowC2 = Calendar.getInstance();
		nowC2.set(2014, Calendar.APRIL, 13);
		
		TestDate client = new TestDate();
		System.out.println(createC.getTime());
		System.out.println(client.format(dobC.getTime(), createC.getTime()));
		System.out.println(nowC.getTime());
		System.out.println(client.format(dobC.getTime(), nowC.getTime()));
		System.out.println(nowC2.getTime());
		System.out.println(client.format(dobC.getTime(), nowC2.getTime()));

	}

	protected static final long MILLIS_PER_DAY = 1000L * 60L * 60L * 24L;
    public String format(Date birthDate, Date fromDate) {
    	{
	        long ageMillis = fromDate.getTime() - birthDate.getTime();
	        int days = (int) (ageMillis / MILLIS_PER_DAY);
	        if (days <= 15){
	        	return days + " " + ("AgeFormat_UnitDay"); //$NON-NLS-1$
	        }
	        int asWeeks = days/7;
	        if (asWeeks <= 12){
	        	return asWeeks + " " + ("AgeFormat_UnitWeek"); //$NON-NLS-1$
	        }
    	}
        
    	{
    		// only use year, month and day otherwise if a person was born at 5pm on 5/5/2000
        	// then at 4pm 5/5/2020 he would not be considered 20 years but still 19 years
        	Calendar c = GregorianCalendar.getInstance();
        	Calendar c2 = GregorianCalendar.getInstance();

        	c.setTime(birthDate);
        	c2.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        	Date birthDateStripped = c2.getTime();
        	
        	c.setTime(fromDate);
        	c2.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        	Date fromDateStripped = c2.getTime();
    		
        	long ageMillis = fromDateStripped.getTime() - birthDateStripped.getTime();
	        int days = (int) (ageMillis / MILLIS_PER_DAY);
        	
	        Calendar cal = GregorianCalendar.getInstance();
	        cal.setTime(birthDateStripped);
//	        int asYears = this.countTimeUnits(Calendar.DAY_OF_YEAR, cal, days);
	        int asYears = getNumberOfYears(birthDateStripped, fromDateStripped);
	        if (asYears >= 3){ //this will probably be the most common case
	        	return asYears + " " + ("AgeFormat_UnitYear"); //$NON-NLS-1$
	        }
	        cal.setTime(birthDateStripped);
			int asMonths = this.countTimeUnits(Calendar.DAY_OF_MONTH, cal, days);
			if (asMonths <= 24){
				return asMonths + " " + ("AgeFormat_UnitMonth"); //$NON-NLS-1$
			}
			return asYears + " " + ("AgeFormat_UnitYear"); //$NON-NLS-1$
    	}
    }
    
    private int getNumberOfYears(Date birthDate, Date fromDate) {
    	Calendar cal = new GregorianCalendar();
    	cal.setTime(birthDate);
    	
	     Calendar now = new GregorianCalendar();
	     now.setTime(fromDate);
	     int res = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
	     if((cal.get(Calendar.MONTH) > now.get(Calendar.MONTH))
	       || (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH)
	       && cal.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH))) {
	        res--;
	     }
	     return res;
    }
    
    protected int countTimeUnits(int field,Calendar from, int days){
        int count = 0;
        int daysLeft = days;
        while(true)
        {
            int daysInUnit = from.getActualMaximum(field);
            daysLeft -= daysInUnit;
            
            if(daysLeft < 0)
            {
                // We are done!
                break;
            }
            
            // Add to the calendar and try again
            from.add(field, daysInUnit);
            count++;
            
        }
        
        return count;
    }
}
