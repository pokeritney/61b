public class Body {
    //parameters
    private static final double GConst = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    //Create an instance of the Body class
    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    //Create a copy of Body b
    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    //calculate dx and dy
    public double calcDx(Body b) {
        return this.xxPos - b.xxPos;
    }

    public double calcDy(Body b) {
        return this.yyPos - b.yyPos;
    }

    //calculates the distance between two Bodys
    public double calcDistance(Body b) {
        double dX = this.calcDx(b);
        double dY = this.calcDy(b);
        return Math.sqrt(dX * dX + dY * dY);
    }

    //returns a double describing the force exerted on this body by the given body
    public double calcForceExertedBy(Body b) {
        double r = this.calcDistance(b);
        return (GConst * this.mass * b.mass) / (r * r);
    }

    //force exerted in the X and Y directions
    public double calcForceExertedByX(Body b) {
        double r = this.calcDistance(b);
        double dX = this.calcDx(b);
        double F1 = calcForceExertedBy(b);
        return (-1) * F1 * dX / r;
    }

    public double calcForceExertedByY(Body b) {
        double r = this.calcDistance(b);
        double dY = this.calcDy(b);
        double F1 = calcForceExertedBy(b);
        return (-1) * F1 * dY / r;
    }

    //calculates the net X and net Y force exerted by all bodies in that array
    public double calcNetForceExertedByX(Body[] allBodys) {
        double res = 0;
        for (Body i: allBodys) {
            //if it is itself, skip
            if (this.equals(i)) {
                continue;
            }
            res += this.calcForceExertedByX(i);
        }
        return res;
    }

    public double calcNetForceExertedByY(Body[] allBodys) {
        double res = 0;
        for (Body i: allBodys) {
            //if it is itself, skip
            if (this.equals(i)) {
                continue;
            }
            res += this.calcForceExertedByY(i);
        }
        return res;
    }

    //adjust the velocity and position if an x force of xForce Newtons
    //and a y force of yForce Newtons were applied for time seconds
    public void update(double dt, double xForce, double yForce) {
        //calculate acceleration
        double aX = xForce / this.mass;
        double aY = yForce / this.mass;
        //calculate new velocity
        this.xxVel += dt * aX;
        this.yyVel += dt * aY;
        //calculate new position
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    //draw itself at the appropriate position
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/".concat(this.imgFileName));
    }
}