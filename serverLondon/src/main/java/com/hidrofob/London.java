package com.hidrofob;

import org.apache.log4j.Logger;

public class London {

    final static Logger logger = Logger.getLogger(London.class);

    public void Creator(String data) {

        London obj = new London();
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
