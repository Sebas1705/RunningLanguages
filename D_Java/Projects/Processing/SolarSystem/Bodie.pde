
class Bodie{
    
    float radius,theta,distance,orbitSpeed;
    PVector v;
    PShape globe;
    PImage image;

    Bodie(float r,float d,float o,PImage texture){
        v=PVector.random3D();
        radius = r;
        theta = random(TWO_PI);
        distance = d;
        v.mult(distance);
        orbitSpeed = o;
        image=texture; 
        noStroke();
        noFill();
        globe = createShape(SPHERE,radius);
        globe.setTexture(image);
    }

    Bodie[] childs;

    private void spawnChildrenRecursive(int n,int level,int maxLevel){
        childs = new Bodie[n];
        float d = radius;
        for(int i=0;i<n;i++){
            float r=radius*random(0.1,0.3);
            d+=r+(i!=0?childs[i-1].radius:r)*random(4,8);
            float o=(random(0,1)>=0.5?1:-1)*random(0.01,0.02);
            String p = childsImages[int(random(0,childsImages.length))];
            childs[i] = new Bodie(r,d,o,loadImage(p));
            if(level<maxLevel){
                childs[i].spawnChildrenRecursive(int(random(1,n-1)),level+1,maxLevel);
            }
        }
    }

    void spawnChildren(int n,int maxLevel){
        spawnChildrenRecursive(n,0,maxLevel);
    }

    void show(){
        pushMatrix();
        PVector v2 = new PVector(1,0,1);
        PVector p = v.cross(v2);
        rotate(theta,p.x,p.y,p.z);
        translate(v.x,v.y,v.z);
        shape(globe);
        if(childs!=null){
            for(Bodie c: childs){
                c.show();
            }
        }
        popMatrix();
    }

    void orbit(){
        theta+=orbitSpeed;
        if(childs!=null){
            for(Bodie c: childs){
                c.orbit();
            }
        }
    }
}