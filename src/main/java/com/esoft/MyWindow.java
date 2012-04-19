package com.esoft;

import com.github.peholmst.i18n4vaadin.I18N;
import com.github.peholmst.i18n4vaadin.support.I18NWindow;

/**
 *
 * @author		Nguyen Nhu Quynh
 * @since		1.0
 * @date_created	Apr 18, 2012
 *
 */

public class MyWindow extends I18NWindow {
	private static final long serialVersionUID = 1545155799774362389L;

	public MyWindow(I18N i18n) {
		super("I18N4Vaadin Demo Application", i18n);
		initComponents();
	}
	
	protected void initComponents() {
		setSizeFull();
		setContent(new MyLayout());
	}
}
