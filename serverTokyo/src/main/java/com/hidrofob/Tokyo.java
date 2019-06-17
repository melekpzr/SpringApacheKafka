package com.hidrofob;

import org.apache.log4j.Logger;

public class Tokyo {
    final static Logger logger = Logger.getLogger(Tokyo.class);

    public void Creator(String data) {

        Tokyo obj = new Tokyo();
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
