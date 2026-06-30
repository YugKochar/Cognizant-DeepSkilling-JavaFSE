

public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Starting Singleton Pattern Verification ===");

        System.out.println("Requesting Instance Reference 1...");
        Logger loggerA = Logger.getInstance();

        System.out.println("Requesting Instance Reference 2...");
        Logger loggerB = Logger.getInstance();

        loggerA.log("Transaction successfully completed by User 1.");
        loggerB.log("System memory profile flushed completely.");

        System.out.println("\n=== Memory Allocation Identity Check ===");
        System.out.println("Logger A Memory Hash Code: " + loggerA.hashCode());
        System.out.println("Logger B Memory Hash Code: " + loggerB.hashCode());

        if (loggerA == loggerB) {
            System.out.println("\n[STATUS: SUCCESS] Both references point directly to the exact same object.");
            System.out.println("Singleton pattern constraints have been perfectly satisfied!");
        } else {
            System.out.println("\n[STATUS: FAILURE] Multiple logger instances exist in runtime memory.");
        }
    }
}