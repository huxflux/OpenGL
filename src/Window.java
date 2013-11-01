import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

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
        float           rotationX = 0;
        float           rotationY = 0;
        float           rotationZ = 0;
        float           angleStep = 3.0f;
        float           testZ = 0.0f;

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

        GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f); // Sets the background color to black

        GL11.glMatrixMode(GL11.GL_PROJECTION); // Select The Projection Matrix
        GL11.glLoadIdentity(); // Reset the view matrix to the identity matrix
        GLU.gluPerspective(80.0f, 1.0f, 1f, -5.0f); // Spesifize the projection matrix (fov, w/h, near plane, far plane)
        GLU.gluLookAt(0.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);

        while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
                rotationY -= angleStep;
            } else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
                rotationY += angleStep;
            } else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
                rotationX -= angleStep;
            } else if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
                rotationX += angleStep;
            } else if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
                testZ += 1.0f;
            } else if (Keyboard.isKeyDown(Keyboard.KEY_X)) {
                testZ -= 1.0f;
            }

            System.out.println(testZ);
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	// Clear Screen And Depth Buffer
            GL11.glLoadIdentity();									// Reset The Current Modelview Matrix
            GL11.glRotatef(rotationX, 0, 1, 0);
            GL11.glRotatef(rotationY, 1, 0, 0);

            GL11.glColor3f(0.0f, 1.0f, 0.0f);
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
            GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
            GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
            GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
            GL11.glEnd();
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
            GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
            GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
            GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
            GL11.glEnd();

            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
            GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
            GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
            GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
            GL11.glEnd();

            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
            GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
            GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
            GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
            GL11.glEnd();

            Display.sync(60);
            Display.update();
        }
        Display.destroy();
    }
}