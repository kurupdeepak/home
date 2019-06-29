package com.rxtracker.common;

public interface TestConstants {
	
	int DUMMY_USER_ID = 1;
	
	String BASE_URL = "/api/users/"+ DUMMY_USER_ID;
	
	String PRESCRIPTION_URL = BASE_URL + "/prescriptions";
	
	String PRESCRIPTION_DAILY_LOG_URL = PRESCRIPTION_URL + "/entries";

	String GLUCO_MONITOR_URL = BASE_URL + "/monitor/entries";
}
