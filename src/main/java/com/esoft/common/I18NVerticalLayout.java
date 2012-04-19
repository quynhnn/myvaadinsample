package com.esoft.common;

import java.util.Locale;

import com.github.peholmst.i18n4vaadin.I18N;
import com.github.peholmst.i18n4vaadin.I18NComponent;
import com.github.peholmst.i18n4vaadin.I18NListener;
import com.github.peholmst.i18n4vaadin.ResourceBundleI18N;
import com.github.peholmst.i18n4vaadin.support.I18NComponentSupport;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author		Nguyen Nhu Quynh
 * @since		1.0
 * @date_created	Apr 19, 2012
 *
 */

public abstract class I18NVerticalLayout extends VerticalLayout implements
		I18NComponent, I18NListener {
	private static final long serialVersionUID = -1070124201217275368L;
	private final I18NComponentSupport support = new I18NComponentSupport(this);
	
	private String baseBundleName;
	
	public I18NVerticalLayout() {
		super();
		I18N i18n = new ResourceBundleI18N(Constants.RESOURCE_BUNDLE_BASE_NAME, Constants.LIST_SUPPORTED_LOCALE);
		i18n.setCurrentLocale(Constants.DEFAULT_LOCALE);
		setI18N(i18n);

		initComponents();
	}

	public I18NVerticalLayout(String baseBundleName) {
		super();
		this.baseBundleName = baseBundleName;

		I18N i18n = new ResourceBundleI18N(baseBundleName, Constants.LIST_SUPPORTED_LOCALE);
		i18n.setCurrentLocale(Constants.DEFAULT_LOCALE);
		setI18N(i18n);

		initComponents();
	}

	@Override
	public void localeChanged(I18N sender, Locale oldLocale, Locale newLocale) {
		updateLabels();
	}

	@Override
	public void setI18N(I18N i18n) {
		support.setI18N(i18n);
	}

	@Override
	public I18N getI18N() {
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

	public String getBaseBundleName() {
		return baseBundleName;
	}

	public void setBaseBundleName(String baseBundleName) {
		this.baseBundleName = baseBundleName;
	}
	
	public abstract void initComponents();

	protected abstract void updateLabels();
}
