package com.hidrofob;

import org.apache.log4j.Logger;

public class Moscow {

    final static Logger logger = Logger.getLogger(Moscow.class);

    public void Creator(String data) {

        Moscow obj = new Moscow();
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
