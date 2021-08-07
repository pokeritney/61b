public class NBody {
    //background
    public static String background = "images/starfield.jpg";
    //public static String planets = "data/planets.txt";

    public static double readRadius(String path) {
        //return the radius
        In in = new In(path);
        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();
        return secondItemInFile;
    }

    public static Body[] readBodies(String path) {
        //return the bodies
        In in = new In(path);
        int count = in.readInt(); //number of bodies
        in.readDouble(); //throw
        Body[] allBodys = new Body[count];

        for (int i = 0; i < count; i++) {
            //after the first two lines, each line is a body
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();

            allBodys[i] = new Body(xP, yP, xV, yV, m, img);

        }
        return allBodys;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Body[] allBodys = readBodies(filename);

        //draw background;
        //radius
        double radius = readRadius(filename);
        // Sets up the universe
        StdDraw.setScale(-radius, radius);
        /* Clears the drawing window. */
        StdDraw.clear();
        /* Draw background */
        StdDraw.picture(0, 0, background);

        //draw each body
        for (Body b: allBodys) {
            b.draw();
        }
        StdDraw.pause(500);
        StdDraw.clear();

        // Enables double buffering.
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        //loop through time
        for (double time = 0; time <= T; time+= dt){
            double[] xForces = new double[allBodys.length];
            double[] yForces = new double[allBodys.length];
            for (int i = 0; i < allBodys.length; i++) {
                Body b = allBodys[i];
                xForces[i] = b.calcNetForceExertedByX(allBodys);
                yForces[i] = b.calcNetForceExertedByY(allBodys);
            }

            //update each body
            for (int i = 0; i < allBodys.length; i++) {
                Body b = allBodys[i];
                b.update(dt, xForces[i], yForces[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, background);

            //draw each body
            for (Body b: allBodys) {
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }


    }
}