import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Window {
    public static void main(String[] args) {
        final int       SCREEN_WIDTH = 800;
        final int       SCREEN_HEIGHT = 600;

        try {
            Display.setDisplayMode(new DisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT));
            Display.create();
            Display.setTitle("Ad Astra");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        GL11.glClearColor(0.9f, 0.0f, 0.0f, 0.0f);
        GL11.glViewport(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
            Display.update();
        }
        Display.destroy();
    }
}
