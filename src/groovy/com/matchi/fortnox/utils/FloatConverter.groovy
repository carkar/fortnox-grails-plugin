package com.matchi.fortnox.utils

/**
 * @author Michael Astreiko
 */
class FloatConverter extends com.thoughtworks.xstream.converters.basic.FloatConverter {

    @Override
    Object fromString(String str) {
        if (!str) {
            return 0f
        }
        return super.fromString(str)
    }
}