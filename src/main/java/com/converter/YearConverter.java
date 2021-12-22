package com.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Year;

@Converter
public class YearConverter implements AttributeConverter<Year, String> {

    @Override
    public String convertToDatabaseColumn(Year year) {
        return year.toString();
    }

    @Override
    public Year convertToEntityAttribute(String year) {
        return Year.parse(year);
    }
}
