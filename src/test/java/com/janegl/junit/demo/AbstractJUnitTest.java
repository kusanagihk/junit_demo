package com.janegl.junit.demo;

import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by jl on 19/6/16.
 */
public class AbstractJUnitTest {

    public void logMethodStart(Logger log, String methodName) {
        log.info("*** " + methodName + " starts " + new Date() + " ***");
    }

    public void logMethodEnd(Logger log, String methodName) {
        log.info("*** " + methodName + " ends : " + new Date() + " ***\r\n");
    }
}
