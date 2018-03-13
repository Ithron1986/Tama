public class Schlafen {
    private int energyValue;
    private int healthynessValue;
    Tamagotchi tamagotchi;

    Thread thread1 = new Thread(() -> {
        while (tamagotchi.getAwake() ==false) {
            try {
                Thread.sleep(600000);
                tamagotchi.setEnergie(tamagotchi.getEnergie() + 1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    });

    //t. start geht nicht??


}
