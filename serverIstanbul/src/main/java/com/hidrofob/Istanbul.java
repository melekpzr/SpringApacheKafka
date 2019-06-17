package com.hidrofob;

import org.apache.log4j.Logger;


public class Istanbul {

    final static Logger logger = Logger.getLogger(Istanbul.class);

    public void Creator(String data) {

        Istanbul obj = new Istanbul();
        obj.runMe(data);

    }

    private void runMe(String parameter){

        if(logger.isInfoEnabled()){
            logger.info(parameter);
        }
        if(logger.isDebugEnabled()){
            logger.debug(parameter);
        }
        logger.warn(parameter);
        logger.error(parameter);
        logger.fatal(parameter);

    }
}