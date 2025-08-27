package com.carportal.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApplicationConstants {

  @UtilityClass
  public class Db {

    public static final String TBL_SCHEMA_CAR_PORTAL = "car_portal";
    public static final String TBL_CAR_DETAILS = "tbl_car_details";
    public static final String TBL_CAR_ENGINE = "tbl_car_engine";
    public static final String TBL_CAR_FEATURES = "tbl_car_feature";
    public static final String TBL_CAR_OUTER = "tbl_car_outer";

  }

  public class Sequence {

    public static final String STRATEGY = "com.carportal.config.PrefixedSequenceIdGenerator";
    public static final String BASE_CUS_SEQ_NAME = "car-seq";
  }

}
