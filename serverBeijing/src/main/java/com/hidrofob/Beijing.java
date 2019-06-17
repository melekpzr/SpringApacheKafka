package com.hidrofob;

import org.apache.log4j.Logger;

public class Beijing {

    final static Logger logger = Logger.getLogger(Beijing.class);

    public void Creator(String data) {

        Beijing obj = new Beijing();
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
