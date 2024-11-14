package com.P2.CBS.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
        return (locDate == null ? null : Date.from(locDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return (date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }
}
