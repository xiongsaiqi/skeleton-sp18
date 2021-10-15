public class NBody {

    public static void main(String args[]){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double Radius = ReadRadius(filename);
        Planet[] planets = ReadPlanets(filename);
    }






    public static double ReadRadius(String data){
        In in = new In(data);
        int number = in.readInt();
        double radius = in.readInt();
        return radius;
    }

    public static Planet[] ReadPlanets(String data){
        In in = new In(data);
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[number];
         for (int i = 0; i < number; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String gif = in.readString();
            Planet p = new Planet(xxPos,yyPos,xxVel,yyVel,mass,gif);
            planets[i] = p;
        }
         return planets;
    }


 }
