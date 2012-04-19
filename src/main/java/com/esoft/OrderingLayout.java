package com.esoft;

import com.esoft.common.Constants;
import com.esoft.common.I18NVerticalLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

/**
 *
 * @author		Nguyen Nhu Quynh
 * @since		1.0
 * @date_created	Apr 18, 2012
 *
 */

public class OrderingLayout extends I18NVerticalLayout {
	private static final long serialVersionUID = -8002840737683037206L;

	private TextField nameField;

	private Button helloButton;
	
	public OrderingLayout() {
		super(Constants.RESOURCE_BUNDLE_BASE_NAME_ORDERING);
	}
	
	@SuppressWarnings("serial")
	public void initComponents() {
		setMargin(true);
		setSpacing(true);
		
		nameField = new TextField();
		addComponent(nameField);

		helloButton = new Button();
		helloButton.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				Window greetingWindow = new Window(getI18N().getMessage("modalWindow.title"));
				greetingWindow.setModal(true);
				greetingWindow.addComponent(new Label(getI18N().getMessage("modalWindow.message", nameField.getValue())));
				getWindow().addWindow(greetingWindow);
				
			}
		});
		
		addComponent(helloButton);
	}
	
	public void updateLabels() {
		nameField.setCaption(getI18N()
				.getMessage("title"));
		helloButton.setCaption(getI18N().getMessage("Button.label"));
	}
	
}
