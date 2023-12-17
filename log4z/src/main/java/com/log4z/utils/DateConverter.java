package com.log4z.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DateConverter {
    private static final List<DateTimeFormatter> FORMATS = Arrays.asList(
            DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm")
    );

    public static String normalizeDateString(String dateString) {
        for (DateTimeFormatter formatter : FORMATS) {
            try {
                LocalDateTime date = LocalDateTime.parse(dateString, formatter);
                return date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            } catch (DateTimeParseException e) {
                // Continua tentando com o próximo formato
            }
        }
        throw new IllegalArgumentException("Formato de data desconhecido: " + dateString);
    }
}
