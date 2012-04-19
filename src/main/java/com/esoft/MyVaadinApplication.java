/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.esoft;

import com.esoft.common.Constants;
import com.github.peholmst.i18n4vaadin.I18N;
import com.github.peholmst.i18n4vaadin.ResourceBundleI18N;
import com.vaadin.Application;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application
{
    @Override
    public void init()
    {
		I18N i18n = new ResourceBundleI18N(Constants.RESOURCE_BUNDLE_BASE_NAME, Constants.LIST_SUPPORTED_LOCALE);
		i18n.setCurrentLocale(Constants.DEFAULT_LOCALE);
		Window mainWindow = new MyWindow(i18n);
		setMainWindow(mainWindow);
		
    }
    
}
