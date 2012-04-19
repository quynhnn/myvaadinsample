package com.esoft.common;

import java.util.Locale;

/**
 *
 * @author		Nguyen Nhu Quynh
 * @since		1.0
 * @date_created	Apr 19, 2012
 *
 */

public class Constants {
	
	public static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
	
	public static final Locale[] LIST_SUPPORTED_LOCALE = {Locale.ENGLISH, new Locale("vi")};
	
	public static final String RESOURCE_BUNDLE_BASE_NAME = "languages/messages";
	public static final String RESOURCE_BUNDLE_BASE_NAME_ORDERING = "languages/ordering/messages";
	public static final String RESOURCE_BUNDLE_BASE_NAME_BOOKING = "languages/booking/messages";
}
