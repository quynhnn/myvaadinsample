package com.esoft;

import java.util.Date;
import java.util.Locale;

import com.github.peholmst.i18n4vaadin.I18N;
import com.github.peholmst.i18n4vaadin.I18NComponent;
import com.github.peholmst.i18n4vaadin.I18NListener;
import com.github.peholmst.i18n4vaadin.ResourceBundleI18N;
import com.github.peholmst.i18n4vaadin.support.I18NComponentSupport;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author		Nguyen Nhu Quynh
 * @since		1.0
 * @date_created	Apr 18, 2012
 *
 */

public class BookingLayout extends VerticalLayout implements I18NComponent,
		I18NListener {
	private static final long serialVersionUID = -8002840737683037206L;
	private final I18NComponentSupport support = new I18NComponentSupport(this);

	private TextField nameField;

	private Button helloButton;
	
	public BookingLayout() {
		I18N i18n = new ResourceBundleI18N(Constants.RESOURCE_BUNDLE_BASE_NAME_BOOKING, Constants.LIST_SUPPORTED_LOCALE);
		i18n.setCurrentLocale(Constants.DEFAULT_LOCALE);
		setI18N(i18n);

		initComponents();
	}
	
	public void localeChanged(I18N sender, Locale oldLocale, Locale newLocale) {
		updateLabels();

	}

	public void setI18N(I18N i18n) {
		support.setI18N(i18n);

	}

	public I18N getI18N() {
		// TODO Auto-generated method stub
		return support.getI18N();
	}
	
	@Override
	public void attach() {
		super.attach();
		getI18N().addListener(this);
		updateLabels();
	}

	@Override
	public void detach() {
		getI18N().removeListener(this);
		super.detach();
	}
	

	@SuppressWarnings("serial")
	private void initComponents() {
		setMargin(true);
		setSpacing(true);
		
		nameField = new TextField();
		addComponent(nameField);

		helloButton = new Button();
		helloButton.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				Window greetingWindow = new Window(getI18N().getMessage(
						"modalWindow.title"));
				greetingWindow.setModal(true);
				greetingWindow.addComponent(new Label(getI18N().getMessage(
						"modalWindow.message", nameField.getValue(),
						new Date())));
				getWindow().addWindow(greetingWindow);
				
			}
		});
		
		addComponent(helloButton);
	}
	
	private void updateLabels() {
		nameField.setCaption(getI18N()
				.getMessage("title"));
		helloButton.setCaption(getI18N().getMessage(
				"Button.label"));
	}
	
}
