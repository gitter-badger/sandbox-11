package jsr352;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.batch.api.AbstractBatchlet;
import javax.batch.api.BatchProperty;
import javax.inject.Inject;

/**
 * @author irof
 */
public class MyBatchlet extends AbstractBatchlet {

    private static final Logger logger = LoggerFactory.getLogger(MyBatchlet.class);

    @Inject
    @BatchProperty
    private String message;

    @Override
    public String process() throws Exception {
        logger.info("JSR352 BATCHLET PROCESS: {}", message);
        return null;
    }
}
