package com.carportal.enums;

import com.carportal.utils.enums.DbEnum;
import com.carportal.utils.enums.EnumUtil;
import com.carportal.utils.enums.NumericDbEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Owner implements DbEnum<String>, NumericDbEnum {

  FIRST("FIRST", "First Owner", 1),
  SECOND("SECOND", "Second Owner", 2),
  THIRD("THIRD", "Third Owner", 3),
  FOURTH("FOURTH", "Fourth Owner", 4);

  private final String dbValue;     // value stored in DB
  private final String description; // value shown in UI
  private final int numericValue;   // numeric representation

  public static Owner fromDbValue(String dbValue) {
    return EnumUtil.fromDbValue(Owner.class, dbValue);
  }

  public static Owner fromNumericValue(int numericValue) {
    return EnumUtil.fromNumericValue(Owner.class, numericValue);
  }


}
