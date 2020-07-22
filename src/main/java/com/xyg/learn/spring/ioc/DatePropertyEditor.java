package com.xyg.learn.spring.ioc;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 97994
 * @since 2020-07-18
 */
public class DatePropertyEditor extends PropertyEditorSupport {
    private String datePattern;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Date parse = null;
        try {
            parse = new SimpleDateFormat(getDatePattern()).parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        setValue(parse);
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

}
