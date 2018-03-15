import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class TamagotchiService extends ScheduledService<Object> {
    @Override
    protected Task<Object> createTask() {
        // ui thread
        return new TamagotchiTask();
    }


    private static class TamagotchiTask extends Task<Object> {

        @Override
        protected Object call() throws Exception {
            Thread.sleep(5000);
            return null;
        }
    }
}
