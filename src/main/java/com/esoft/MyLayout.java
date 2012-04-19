package com.esoft;

import java.util.Locale;

import com.github.peholmst.i18n4vaadin.I18N;
import com.github.peholmst.i18n4vaadin.I18NComponent;
import com.github.peholmst.i18n4vaadin.I18NListener;
import com.github.peholmst.i18n4vaadin.support.I18NComponentSupport;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

/**
 *
 * @author		Nguyen Nhu Quynh
 * @since		1.0
 * @date_created	Apr 17, 2012
 *
 */

public class MyLayout extends VerticalLayout implements I18NComponent, I18NListener {
	private static final long serialVersionUID = 1545155799774362389L;

	private final I18NComponentSupport support = new I18NComponentSupport(this);
	private Label myLabel;

	private Tab orderingTab;
	private Tab bookingTab;
	
	private OrderingLayout orderingLayout;
	private BookingLayout bookingLayout;
	
	
	public void setI18N(I18N i18n) {
		support.setI18N(i18n);
	}

	public I18N getI18N() {
		return support.getI18N();
	}

	public MyLayout() {
		initComponents();
    }
	
	@Override
    public void attach() {
        super.attach();
        getI18N().addListener(this); // Register listener
        updateLabels();
    }

    @Override
    public void detach() {
        // Remember to unregister listener as well!
        getI18N().removeListener(this);
        super.detach();
    }

    public void localeChanged(I18N sender, Locale oldLocale, Locale newLocale) {
        updateLabels();
    }   
    
	@SuppressWarnings("serial")
	private void initComponents() {
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

    private void updateLabels() {
        myLabel.setValue(getI18N().getMessage("Greeting"));
        
		orderingTab.setCaption(getI18N().getMessage("orderingTab.label"));
		bookingTab.setCaption(getI18N().getMessage("bookingTab.label"));

    }
}
