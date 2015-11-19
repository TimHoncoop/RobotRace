package robotrace;

import java.awt.Color;
import static java.lang.Math.*;
import javax.media.opengl.GL;
import static javax.media.opengl.GL.GL_BLEND;
import static javax.media.opengl.GL.GL_COLOR_BUFFER_BIT;
import static javax.media.opengl.GL.GL_DEPTH_BUFFER_BIT;
import static javax.media.opengl.GL.GL_DEPTH_TEST;
import static javax.media.opengl.GL.GL_FRONT_AND_BACK;
import static javax.media.opengl.GL.GL_LESS;
import static javax.media.opengl.GL.GL_NICEST;
import static javax.media.opengl.GL.GL_ONE_MINUS_SRC_ALPHA;
import static javax.media.opengl.GL.GL_SRC_ALPHA;
import static javax.media.opengl.GL.GL_TEXTURE_2D;
import static javax.media.opengl.GL2.*;
import static javax.media.opengl.GL2ES1.GL_PERSPECTIVE_CORRECTION_HINT;
import static javax.media.opengl.GL2GL3.GL_FILL;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_NORMALIZE;
import static javax.media.opengl.fixedfunc.GLMatrixFunc.GL_MODELVIEW;
import static javax.media.opengl.fixedfunc.GLMatrixFunc.GL_PROJECTION;

/**
 * Handles all of the RobotRace graphics functionality,
 * which should be extended per the assignment.
 * 
 * OpenGL functionality:
 * - Basic commands are called via the gl object;
 * - Utility commands are called via the glu and
 *   glut objects;
 * 
 * GlobalState:
 * The gs object contains the GlobalState as described
 * in the assignment:
 * - The camera viewpoint angles, phi and theta, are
 *   changed interactively by holding the left mouse
 *   button and dragging;
 * - The camera view width, vWidth, is changed
 *   interactively by holding the right mouse button
 *   and dragging upwards or downwards;
 * - The center point can be moved up and down by
 *   pressing the 'q' and 'z' keys, forwards and
 *   backwards with the 'w' and 's' keys, and
 *   left and right with the 'a' and 'd' keys;
 * - Other settings are changed via the menus
 *   at the top of the screen.
 * 
 * Textures:
 * Place your "track.jpg", "brick.jpg", "head.jpg",
 * and "torso.jpg" files in the same folder as this
 * file. These will then be loaded as the texture
 * objects track, bricks, head, and torso respectively.
 * Be aware, these objects are already defined and
 * cannot be used for other purposes. The texture
 * objects can be used as follows:
 * 
 * gl.glColor3f(1f, 1f, 1f);
 * track.bind(gl);
 * gl.glBegin(GL_QUADS);
 * gl.glTexCoord2d(0, 0);
 * gl.glVertex3d(0, 0, 0);
 * gl.glTexCoord2d(1, 0);
 * gl.glVertex3d(1, 0, 0);
 * gl.glTexCoord2d(1, 1);
 * gl.glVertex3d(1, 1, 0);
 * gl.glTexCoord2d(0, 1);
 * gl.glVertex3d(0, 1, 0);
 * gl.glEnd(); 
 * 
 * Note that it is hard or impossible to texture
 * objects drawn with GLUT. Either define the
 * primitives of the object yourself (as seen
 * above) or add additional textured primitives
 * to the GLUT object.
 */
public class RobotRace extends Base {
    
    /** Array of the four robots. */
    private final Robot[] robots;
    
    /** Instance of the camera. */
    private final Camera camera;
    
    /** Instance of the race track. */
    private final RaceTrack[] raceTracks;
    
    /** Instance of the terrain. */
    private final Terrain terrain;
    
    /**
     * Constructs this robot race by initializing robots,
     * camera, track, and terrain.
     */
    public RobotRace() {
        
        // Create a new array of four robots
        robots = new Robot[4];
        
        // Initialize robot 0
        robots[0] = new Robot(Material.GOLD
            /* add other parameters that characterize this robot */);
        
        // Initialize robot 1
        robots[1] = new Robot(Material.SILVER
            /* add other parameters that characterize this robot */);
        
        // Initialize robot 2
        robots[2] = new Robot(Material.WOOD
            /* add other parameters that characterize this robot */);

        // Initialize robot 3
        robots[3] = new Robot(Material.ORANGE
            /* add other parameters that characterize this robot */);
        
        // Initialize the camera
        camera = new Camera();
        
        // Initialize the race tracks
        raceTracks = new RaceTrack[5];
        
        // Test track
        raceTracks[0] = new RaceTrack();
        
        // O-track
        raceTracks[1] = new RaceTrack(new Vector[] {
            /* add control points like:
            new Vector(10, 0, 1), new Vector(10, 5, 1), new Vector(5, 10, 1),
            new Vector(..., ..., ...), ...
            */
        });
        
        // L-track
        raceTracks[2] = new RaceTrack(new Vector[] { 
            /* add control points */
        });
        
        // C-track
        raceTracks[3] = new RaceTrack(new Vector[] { 
            /* add control points */
        });
        
        // Custom track
        raceTracks[4] = new RaceTrack(new Vector[] { 
           /* add control points */
        });
        
        // Initialize the terrain
        terrain = new Terrain();
    }
    
    /**
     * Called upon the start of the application.
     * Primarily used to configure OpenGL.
     */
    @Override
    public void initialize() {
		
        // Enable blending.
        gl.glEnable(GL_BLEND);
        gl.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
                
        // Enable depth testing.
        gl.glEnable(GL_DEPTH_TEST);
        gl.glDepthFunc(GL_LESS);
		
	    // Normalize normals.
        gl.glEnable(GL_NORMALIZE);
        
        // Enable textures. 
        gl.glEnable(GL_TEXTURE_2D);
        gl.glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
        gl.glBindTexture(GL_TEXTURE_2D, 0);
		
	    // Try to load four textures, add more if you like.
        track = loadTexture("track.jpg");
        brick = loadTexture("brick.jpg");
        head = loadTexture("head.jpg");
        torso = loadTexture("torso.jpg");
    }
    
    /**
     * Configures the viewing transform.
     */
    @Override
    public void setView() {
        // Select part of window.
        gl.glViewport(0, 0, gs.w, gs.h);
        
        // Set projection matrix.
        gl.glMatrixMode(GL_PROJECTION);
        gl.glLoadIdentity();

        // Set the perspective.
        // Modify this to meet the requirements in the assignment.
        glu.gluPerspective(Math.toDegrees((2*atan((0.5*gs.vWidth)/gs.vDist))), (float)gs.w / (float)gs.h, 0.1*gs.vDist, 10*gs.vDist);
        System.out.println((2*atan((0.5*gs.vWidth)/gs.vDist)));
        System.out.println("dist:" + gs.vDist);
        System.out.println("width:" + gs.vWidth);
        // Set camera.
        gl.glMatrixMode(GL_MODELVIEW);
        gl.glLoadIdentity();
               
        // Update the view according to the camera mode and robot of interest.
        // For camera modes 1 to 4, determine which robot to focus on.
        camera.update(gs, robots[0]);
        glu.gluLookAt((gs.vDist*cos(gs.phi)*cos(gs.theta)),    (gs.vDist*cos(gs.phi)*sin(gs.theta)),    (gs.vDist*sin(gs.phi)),
                      gs.cnt.x, gs.cnt.y, gs.cnt.z,
                      0,     0,     1);
    }
    
    /**
     * Draws the entire scene.
     */
    @Override
    public void drawScene() {
           

// Background color.
        gl.glClearColor(1f, 1f, 1f, 0f);
        
        // Clear background.
        gl.glClear(GL_COLOR_BUFFER_BIT);
        
        // Clear depth buffer.
        gl.glClear(GL_DEPTH_BUFFER_BIT);
        
        // Set color to black.
        gl.glColor3f(0f, 0f, 0f);
        
        gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        
        // Draw the axis frame.
        if (gs.showAxes) {
            drawAxisFrame();
        }
        gl.glColor3f(0f, 0f, 0f);
        // Get the position and direction of the first robot.
        robots[0].position = raceTracks[gs.trackNr].getLanePoint(0, 0);
        robots[0].direction = raceTracks[gs.trackNr].getLaneTangent(0, 0);
        
        // Draw the first robot.
        if (gs.showStick) {
        robots[0].draw(gl, glu, glut, true, gs.tAnim);
        }
        robots[0].draw(gl, glu, glut, false, gs.tAnim);
        // Draw the race track.
        raceTracks[gs.trackNr].draw(gl, glu, glut);
        
        // Draw the terrain.
        terrain.draw(gl, glu, glut);
        
        // Unit box around origin.
        
    }
    
    /**
     * Draws the x-axis (red), y-axis (green), z-axis (blue),
     * and origin (yellow).
     */
    public void drawAxisFrame() {
        // code goes here ...
        
        gl.glColor3f(256f, 256f, 0f);//yellow
        glut.glutSolidSphere(1/8f, 10, 10); // draw sphere, radius 1/8f, longitude and latitude are 10 respectively
        
        // draw x axis
        gl.glColor3f(256f, 0f, 0f); //red
        gl.glTranslatef(0.5f, 0, 0);//moves in x-direction
        gl.glScalef(1f, 0.1f, 0.1f);//scales in vertical direction
        glut.glutSolidCube(1f); //render a solid cube
        gl.glScalef(1f, 10f, 10f);//fill in the cube

        // draw the cone of x axis
        gl.glTranslatef(0.5f, 0, 0);//blah
        gl.glRotatef(90, 0, 1, 0); //90 degree rotation
        glut.glutSolidCone(0.15, 0.2, 20, 20); //render a solid cone
        gl.glRotatef(90, 0, -1f, 0);//(0,-1,0)
        gl.glTranslatef(-1f, 0, 0);//(-1,0,0)
        
         // draw y axis
        gl.glColor3f(0f, 256f, 0f); //green
        gl.glTranslatef(0, 0.5f, 0);//moves in y-direction
        gl.glScalef(0.1f, 1f, 0.1f);//scales in vertical direction
        glut.glutSolidCube(1f); //render a solid cube
        gl.glScalef(10f, 1f, 10f);//fill in the cube
        
       

        // draw the cone of y axis
        gl.glTranslatef(0, 0.5f, 0);//blah
        gl.glRotatef(90, -1, 0, 0); //90 degree rotation opposite to the normal
        glut.glutSolidCone(0.15, 0.2, 20, 20); //render a solid cone
        gl.glRotatef(90, 1f, 0, 0);//(1,0,0)
        gl.glTranslatef(0, -1f, 0);//(0,-1,0)
        
         // draw z axis
        gl.glColor3f(0f, 0f, 256f); //blue
        gl.glTranslatef(0, 0, 0.5f);//moves in y-direction
        gl.glScalef(0.1f, 0.1f, 1f);//scales in vertical direction
        glut.glutSolidCube(1f); //render a solid cube
        gl.glScalef(10f, 10f, 1f);//fill in the cube

        // draw the cone of z axis
        gl.glTranslatef(0, 0, 0.5f);//blah
        gl.glRotatef(90, 0, 0, 1); //90 degree rotation alongside normal
        glut.glutSolidCone(0.15, 0.2, 20, 20); //render a solid cone
        gl.glRotatef(90, 0, 0, -1f); //(0,0,-1)
        gl.glTranslatef(0, 0, -1f); //(0,0,-1)
        
        
    }
 
    /**
     * Main program execution body, delegates to an instance of
     * the RobotRace implementation.
     */
    public static void main(String args[]) {
        RobotRace robotRace = new RobotRace();
        robotRace.run();
    } 

    private void setColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
