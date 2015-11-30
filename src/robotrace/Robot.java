package robotrace;

import com.jogamp.opengl.util.gl2.GLUT;
import static javax.media.opengl.GL.GL_FRONT_AND_BACK;
import javax.media.opengl.GL2;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_SHININESS;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_SPECULAR;
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

            //left upperleg
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0, 0.5625f);
            gl.glScalef(0.1f, 0.1f, 0.375f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();

            //left hip
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0, 0.75f);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();
            
            //left knee
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0, 0.375f);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();
            
            //left lowerleg
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0, 0.1875f);
            gl.glScalef(0.1f, 0.1f, 0.375f);
            glut.glutSolidCube(1f);
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

            //right upperleg
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0, 0.5625f);
            gl.glScalef(0.1f, 0.1f, 0.375f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();

            //right hip
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0, 0.75f);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();
            
            //right knee
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0, 0.375f);
            glut.glutSolidSphere(1/10f, 10, 10);
            gl.glPopMatrix();
            
            //right lowerleg
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0, 0.1875f);
            gl.glScalef(0.1f, 0.1f, 0.375f);
            glut.glutSolidCube(1f);
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
            
            gl.glColor3f(material.diffuse[0], material.diffuse[1],material.diffuse[2]);
            gl.glMaterialfv(GL_FRONT_AND_BACK, GL_SPECULAR, material.specular, 0);
            gl.glMaterialf(GL_FRONT_AND_BACK, GL_SHININESS, material.shininess); //The shininess parameter
            //torso
            gl.glPushMatrix();
            gl.glTranslatef(0, 0, 1.125f);
            gl.glScalef(0.5f, 0.3f, 1.0f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();
            
            //right upperleg
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0, 0.6125f);
            gl.glScalef(0.25f, 0.25f, 0.475f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();
            
            //right lowerleg
            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0, 0.1875f);
            gl.glScalef(0.25f, 0.25f, 0.375f);
            glut.glutSolidCube(1f);
            gl.glPopMatrix();
            

            
            //draw left leg based on rotation
            drawLeftLeg(gl, glu, glut, 60);

            
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
    
    
    public void drawLeftLeg(GL2 gl, GLU glu, GLUT glut, float rotation) {  
        
        gl.glPushMatrix();
        gl.glTranslatef(-0.25f, 0, 0.75f);
        gl.glRotatef(rotation, 1.0f, 0f, 0f);
        
        gl.glTranslatef(0, 0, -0.1875f);
        
        gl.glPushMatrix();
        gl.glScalef(0.25f, 0.25f, 0.475f);
        glut.glutSolidCube(1f);
        gl.glPopMatrix();
        
        
        gl.glTranslatef(0, 0, -0.1875f);
        
        
        gl.glScalef(0.25f, 0.25f, 0.375f);
        gl.glRotatef(30,1f,0f,0f);
        gl.glTranslatef(0f, 0f, -0.1875f);
        glut.glutSolidCube(1f);  
        gl.glPopMatrix();

        //left upperleg
        //gl.glPushMatrix();
        //gl.glTranslatef(-0.25f, 0, 0.6125f);
        
        //gl.glRotatef(rotation, 1.0f, 0f, 0f);
        //gl.glTranslatef(0f, 0f,-0.1875f);
                
        //gl.glScalef(0.25f, 0.25f, 0.475f);
        //glut.glutSolidCube(1f);
       //gl.glPopMatrix();
        
        //left lowerleg
        //gl.glPushMatrix();
        //gl.glTranslatef(-0.25f, 0, 0.1875f);
              
        //gl.glPopMatrix();
        
        

    }
}


