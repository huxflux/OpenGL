import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Window {
    public static void main(String[] args) {
        final int       SCREEN_WIDTH = 800;
        final int       SCREEN_HEIGHT = 600;
        float           triangle_X1 = 300;
        float           triangle_Y1 = 200;
        float           triangle_X2 = 500;
        float           triangle_Y2 = 200;
        float           triangle_X3 = 400;
        float           triangle_Y3 = 400;
        float           x = 400;
        float           y = 300;
        float           rotation = 0;
        float           angleStep = 3.0f;

        try {
            Display.setDisplayMode(new DisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT));
            Display.create();
            Display.setTitle("Ad Astra");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        System.out.println(GL11.glGetString(GL11.GL_VERSION));
        System.out.println(GL11.glGetString(GL11.GL_VENDOR));
        System.out.println(GL11.glGetString(GL11.GL_POINT_SIZE));

        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glViewport(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        GL11.glPolygonMode( GL11.GL_FRONT_AND_BACK, GL11.GL_LINES);

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, SCREEN_WIDTH, 0, SCREEN_HEIGHT, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLineWidth(3);

        while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
            GL11.glColor3f(0.0f, 0.6f, 0.3f);

            if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
                rotation += angleStep;
            } else if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
                rotation -= angleStep;
            }

            GL11.glPushMatrix();
            GL11.glTranslatef(x, y, 0);
            GL11.glRotatef(rotation, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-x, -y, 0);

//            GL11.glTranslatef(triangle_X1, triangle_Y1, 0.0f);
//            GL11.glRotatef(rotation, 0.0f, 0.0f, 1.0f);
//            GL11.glTranslatef(-triangle_X1, -triangle_Y1, 0.0f);

            GL11.glBegin(GL11.GL_TRIANGLES);
            GL11.glVertex2f(triangle_X1, triangle_Y1);
            GL11.glVertex2f(triangle_X2, triangle_Y2);
            GL11.glVertex2f(triangle_X3, triangle_Y3);
            GL11.glEnd();
            GL11.glPopMatrix();

            Display.sync(60);
            Display.update();
        }
        Display.destroy();
    }
}
