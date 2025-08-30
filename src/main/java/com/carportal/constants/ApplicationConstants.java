package com.carportal.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApplicationConstants {

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

  public class Column {

    // CarDetails
    public static final String CAR_MANUFACTURER = "CAR_MANUFACTURER";
    public static final String CAR_MODEL = "CAR_MODEL";
    public static final String PRICE = "PRICE";
    public static final String MANUFACTURED_YEAR = "MANUFACTURED_YEAR";
    public static final String REGISTRATION_YEAR = "REGISTRATION_YEAR";
    public static final String KILOMETER_DRIVEN = "KILOMETER_DRIVEN";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String OWNER = "OWNER";

    // CarEngine
    public static final String MILEAGE = "OWNER";
    public static final String TRANSMISSION_TYPE = "OWNER";
    public static final String ENGINE_TYPE = "OWNER";
    public static final String ENGINE_DISPLACEMENT = "OWNER";
    public static final String MAX_POWER = "OWNER";
    public static final String MAX_TORQUE = "OWNER";
    public static final String NUMBER_OF_CYLINDER = "OWNER";
    public static final String FUEL_TYPE = "OWNER";
    public static final String DRIVETRAIN = "DRIVETRAIN";

    // CarFeatures
    public static final String AIR_CONDITIONER = "AIR_CONDITIONER";
    public static final String HEATER = "HEATER";
    public static final String SEAT_MATERIAL = "SEAT_MATERIAL";
    public static final String STEERING_WHEEL_MATERIAL = "STEERING_WHEEL_MATERIAL";
    public static final String POWER_WINDOWS = "POWER_WINDOWS";
    public static final String ADJUSTABLE_STEERING = "ADJUSTABLE_STEERING";
    public static final String REMOTE_TRUNK_OPENER = "REMOTE_TRUNK_OPENER";
    public static final String REAR_SEAT_HEADREST = "REAR_SEAT_HEADREST";
    public static final String REAR_SEAT_CENTRE_ARMREST = "REAR_SEAT_CENTRE_ARMREST";
    public static final String REAR_AC_VENTS = "REAR_AC_VENTS";
    public static final String NAVIGATION_SYSTEM = "NAVIGATION_SYSTEM";
    public static final String REVERSING_CAMERA = "REVERSING_CAMERA";
    public static final String REAR_VIEW_MIRROR_TYPE = "REAR_VIEW_MIRROR_TYPE";
    public static final String SUNROOF = "SUNROOF";
    public static final String ANTI_LOCK_BRAKING_SYSTEM = "ANTI_LOCK_BRAKING_SYSTEM";
    public static final String CENTRAL_LOCKING = "CENTRAL_LOCKING";
    public static final String POWER_DOOR_LOCKS = "POWER_DOOR_LOCKS";
    public static final String CHILD_SAFETY_LOCK = "CHILD_SAFETY_LOCK";
    public static final String ANTI_THEFT_ALARM = "ANTI_THEFT_ALARM";
    public static final String AIRBAG_CONFIG = "AIRBAG_CONFIG";

    // CarOuter
    public static final String CAR_BODY_TYPE = "CAR_BODY_TYPE";
    public static final String COLOR = "COLOR";
    public static final String LENGTH = "LENGTH";
    public static final String HEIGHT = "HEIGHT";
    public static final String WIDTH = "WIDTH";
    public static final String GROUND_CLEARANCE = "GROUND_CLEARANCE";
    public static final String BOOT_SPACE = "BOOT_SPACE";
    public static final String SEATING_CAPACITY = "SEATING_CAPACITY";
    public static final String FUEL_TANK_CAPACITY = "FUEL_TANK_CAPACITY";
    public static final String NO_OF_DOORS = "NO_OF_DOORS";
    public static final String FRONT_BRAKE_TYPE = "FRONT_BRAKE_TYPE";
    public static final String REAR_BRAKE_TYPE = "REAR_BRAKE_TYPE";

  }

}
