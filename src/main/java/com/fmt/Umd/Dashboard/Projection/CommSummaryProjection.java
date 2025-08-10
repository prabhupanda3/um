package com.fmt.Umd.Dashboard.Projection;

public interface CommSummaryProjection {
	 String getCommDate();     // or LocalDate if mapped as Date in DB
	    Double getTotalComm();
}
