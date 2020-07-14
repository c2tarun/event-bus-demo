package com.example.sprintbooteventbus;

import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final String controllerName;
    private final EventBus eventBus;

    @Autowired
    public HelloController(String controllerName, EventBus eventBus, EventListener listener) {
        this.controllerName = controllerName;
        this.eventBus = eventBus;

        eventBus.register(listener);
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from spring boot!";
    }

    @RequestMapping("/store/{name}")
    public String storeName (@PathVariable String name) {
        return String.format("Hello %s, from %s", name, this.controllerName);
    }

    @RequestMapping("/publish/{name}")
    public String publish(@PathVariable String name) {
        eventBus.post(new MyEvent(name));
        return String.format("Published event for name: %s", name);
    }
}
