# event-bus-demo

Steps:
1. Run project using `./gradlew bootRun`.
2. Run `curl localhost:8080/publish/demo-name` to publish an event with `demo-name`.
3. You should return `Published event for name: demo-name` as result of your curl command.
4. On your server console you should see `EventListener : Received event for demo-name`.
