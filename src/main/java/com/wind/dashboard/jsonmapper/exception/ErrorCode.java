package com.wind.dashboard.jsonmapper.exception;

/**
 * The Interface ErrorCode.
 */
public interface ErrorCode {

    /**
     * Gets the code
     *
     * @return the code
     */
    default String code() {
        if (this instanceof Enum) {
            return ((Enum) this).name();
        } else {
            return "UNDEFINED";
        }
    }


    /**
     * Gets the description
     *
     * @return the description
     */
    String description();

}
