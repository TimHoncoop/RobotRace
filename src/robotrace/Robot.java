package robotrace;

import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

/**
* Represents a Robot, to be implemented according to the Assignments.
*/
class Robot {
    
    /** The position of the robot. */
    public Vector position = new Vector(0, 1, 0);
    
    /** The direction in which the robot is running. */
    public Vector direction = new Vector(1, 0, 0);

    /** The material from which this robot is built. */
    private final Material material;

    /**
     * Constructs the robot with initial parameters.
     */
    public Robot(Material material
        /* add other parameters that characterize this robot */) {
        this.material = material;

        // code goes here ...
    }

    /**
     * Draws this robot (as a {@code stickfigure} if specified).
     */
    public void draw(GL2 gl, GLU glu, GLUT glut, boolean stickFigure, float tAnim) {
        if (stickFigure) {
            //MIDDLE
            //Caudale
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, 0.75f);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();

            //connection legs
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, 0.75f);
            gl.glScalef(0.5f, 0.1f, 0.1f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();

            //spine
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, 1.125f);
            gl.glScalef(0.1f, 0.1f, 0.75f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();

            //Cervical vertebrea
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, 1.5f);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();

            //wings
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, 1.5f);
            gl.glScalef(1.0f, 0.1f, 0.1f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();

            //neck
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, 1.65f);
            gl.glScalef(0.1f, 0.1f, 0.3f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();

            //head
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, 1.9f);
            glut.glutSolidSphere(1/5f, 10, 10);
            gl.glPopMatrix();



            //LEFT SIDE
            //left feet
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0, 0);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();

            //left leg
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0, 0.375f);
            gl.glScalef(0.1f, 0.1f, 0.75f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();

            //left hip
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0, 0.75f);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();

            //left shoulder
            gl.glPushMatrix();
            gl.glTranslatef(-0.5f, 0, 1.5f);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();

            //left arm
            gl.glPushMatrix();
            gl.glTranslatef(-0.5f, 0, 1.1f);
            gl.glScalef(0.1f, 0.1f, 0.8f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();

            //left hand
            gl.glPushMatrix();
            gl.glTranslatef(-0.5f, 0, 0.7f);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();



            //RIGHT SIDE
            //Right feet
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0, 0);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();

            //right leg
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0, 0.375f);
            gl.glScalef(0.1f, 0.1f, 0.75f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();

            //right hip
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0, 0.75f);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();

            //right shoulder
            gl.glPushMatrix();
            gl.glTranslatef(0.5f, 0, 1.5f);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();

            //right arm
            gl.glPushMatrix();
            gl.glTranslatef(0.5f, 0, 1.1f);
            gl.glScalef(0.1f, 0.1f, 0.8f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();
        
            //Right hand
            gl.glPushMatrix();
            gl.glTranslatef(0.5f, 0, 0.7f);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();
        }
        else {
            //torso
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, 1.125f);
            gl.glScalef(0.5f, 0.3f, 1.0f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();
            
            //right leg
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0, 0.385f);
            gl.glScalef(0.25f, 0.25f, 0.85f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();
            
            //left leg
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0, 0.385f);
            gl.glScalef(0.25f, 0.25f, 0.85f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();
            
            //neck
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, 1.65f);
            gl.glScalef(0.2f, 0.2f, 0.3f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();
            
            //head
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, 1.9f);
            glut.glutSolidCube(0.45f);
            gl.glPopMatrix();
            
            //right arm
            gl.glPushMatrix();
            gl.glTranslatef(0.5f, 0, 1.1f);
            gl.glScalef(0.25f, 0.25f, 0.8f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();
            
            //left arm
            gl.glPushMatrix();
            gl.glTranslatef(-0.5f, 0, 1.1f);
            gl.glScalef(0.25f, 0.25f, 0.8f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();
            
            //wings
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, 1.4f);
            gl.glScalef(1.3f, 0.25f, 0.35f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();
        }
        
        
        
        
        
        
    }
}
