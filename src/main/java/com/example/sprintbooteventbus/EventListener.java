package com.example.sprintbooteventbus;

import com.google.common.eventbus.Subscribe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EventListener {

    final Logger logger = LogManager.getLogger(EventListener.class.getSimpleName());

    @Subscribe
    public void listen(MyEvent event) {
        logger.info(String.format("Received event for %s", event.getName()));
    }
}
