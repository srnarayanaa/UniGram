
public interface UserEventStream {

    String OUTPUT = "momentsUserChanged";

    @Output(OUTPUT)
    MessageChannel momentsUserChanged();
}