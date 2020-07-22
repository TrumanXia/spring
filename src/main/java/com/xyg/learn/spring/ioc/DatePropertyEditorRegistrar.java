package com.xyg.learn.spring.ioc;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditor;

/**
 * @author 97994
 * @since 2020-07-18
 */
public class DatePropertyEditorRegistrar implements PropertyEditorRegistrar {
    private PropertyEditor propertyEditor;
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(java.util.Date.class, getPropertyEditor());
    }

    public PropertyEditor getPropertyEditor() {
        return propertyEditor;
    }

    public void setPropertyEditor(PropertyEditor propertyEditor) {
        this.propertyEditor = propertyEditor;
    }
}
