package com.app.api.jhonbarondev.application.common;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Utility {
  public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
    return Period.between(birthDate, currentDate).getYears();
  }

  public static int calculateMonths(LocalDate birthDate, LocalDate currentDate) {
    return Period.between(birthDate, currentDate).getMonths();
  }

  public static int calculateDays(LocalDate birthDate, LocalDate currentDate) {
    return Period.between(birthDate, currentDate).getDays();
  }

  public static java.util.Date localDateToDate(LocalDate localDate) {
    return Date.from(localDate.atStartOfDay(ZoneId.of("America/Bogota")).toInstant());
  }

  public static LocalDate dateToLocalDate(Date date) {
    return date.toInstant().atZone(ZoneId.of("America/Bogota")).toLocalDate();
  }
}
