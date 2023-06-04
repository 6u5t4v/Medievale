import dev.gostav.medievale.utils.Window;

import java.awt.*;

public class Main implements Runnable {
    static Window Window;

    public static void main(String[] args) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Window = new Window("Mediavale", screen.width / 2, screen.height / 2);

        new Thread(new Main()).start();
    }

    @Override
    public void run() {
        try {
            Window.loop(this::init, this::update);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void init() {

    }

    private void update() {
    }
}