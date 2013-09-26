import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {
    public static void main(String[] args) {
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
            Display.setTitle("Ad Astra");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        while (!Display.isCloseRequested()) {
            Display.update();
        }
        Display.destroy();
    }
}
