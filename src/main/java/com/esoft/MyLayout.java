package com.esoft;

import java.util.Locale;

import com.esoft.common.I18NVerticalLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.themes.BaseTheme;

/**
 *
 * @author		Nguyen Nhu Quynh
 * @since		1.0
 * @date_created	Apr 17, 2012
 *
 */

public class MyLayout extends I18NVerticalLayout {
	private static final long serialVersionUID = 1545155799774362389L;

	private Label myLabel;

	private Tab orderingTab;
	private Tab bookingTab;
	
	private OrderingLayout orderingLayout;
	private BookingLayout bookingLayout;
	
	public MyLayout() {
		super();
    }
	
	@SuppressWarnings("serial")
	public void initComponents() {
		setMargin(true);
		setSizeFull();

		myLabel = new Label(); // No caption is set!
        addComponent(myLabel);
        
        TabSheet tabs = new TabSheet();
		tabs.setSizeFull();
		addComponent(tabs);
		setExpandRatio(tabs, 1.0f);

		//For Ordering tab
		orderingLayout = new OrderingLayout();
		orderingTab = tabs.addTab(orderingLayout);
		
		//For Booking tab
		bookingLayout = new BookingLayout();
		bookingTab = tabs.addTab(bookingLayout);
		
		HorizontalLayout languageButtons = new HorizontalLayout();
		languageButtons.setSpacing(true);

		Button enButton = new Button("English", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				getI18N().setCurrentLocale(Locale.ENGLISH);
				orderingLayout.getI18N().setCurrentLocale(Locale.ENGLISH);
				bookingLayout.getI18N().setCurrentLocale(Locale.ENGLISH);
			}
		});
		enButton.addStyleName(BaseTheme.BUTTON_LINK);
		languageButtons.addComponent(enButton);
		languageButtons.setComponentAlignment(enButton, Alignment.MIDDLE_LEFT);

		Button viButton = new Button("VietNam", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				getI18N().setCurrentLocale(new Locale("vi"));
				orderingLayout.getI18N().setCurrentLocale(new Locale("vi"));
				bookingLayout.getI18N().setCurrentLocale(new Locale("vi"));
			}
		});
		viButton.addStyleName(BaseTheme.BUTTON_LINK);
		languageButtons.addComponent(viButton);
		languageButtons.setComponentAlignment(viButton, Alignment.MIDDLE_LEFT);

		addComponent(languageButtons);
	}

    public void updateLabels() {
        myLabel.setValue(getI18N().getMessage("Greeting"));
        
		orderingTab.setCaption(getI18N().getMessage("orderingTab.label"));
		bookingTab.setCaption(getI18N().getMessage("bookingTab.label"));

    }
}
