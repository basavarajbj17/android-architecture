package co.techmagic.architecturetemplate.strategies;


import co.techmagic.common.events.UserCreatedEvent;
import co.techmagic.common.events.UserCreationErrorEvent;

public interface CreateUserStrategy {
    /**
     * Called when user created
     *
     * @param event event
     */
    void handleUserCreated(UserCreatedEvent event);

    /**
     * Called when error occurs while creating user
     *
     * @param event event
     */
    void handleUserCreationError(UserCreationErrorEvent event);
}
