@StreamListener(UserEventStream.INPUT)
public void onMessage(Message<UserEventPayload> message) {

        UserEventType eventType = message.getPayload().getEventType();

        log.info("received message to process user {} eventType {}",
        message.getPayload().getUsername(),
        eventType.name());

        Acknowledgment acknowledgment =
        message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);

        User user = convertTo(message.getPayload());

        switch (eventType) {
        case CREATED:
        userService.addUser(user);
        break;
        case UPDATED:
        userService.updateUser(user);
        break;
        }

        if(acknowledgment != null) {
        acknowledgment.acknowledge();
        }
        }