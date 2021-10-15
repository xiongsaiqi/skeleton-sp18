import java.util.Arrays;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double square = Math.pow(this.xxPos - p.xxPos,2) + Math.pow(this.yyPos + p.yyPos, 2);
        return Math.pow(square, 0.5);
    }

    public double calcForceExertedBy(Planet p){
        double distance = this.calcDistance(p);
        return G * this.mass * p.mass / Math.pow(distance,2);
    }

    public double calcForceExertedByX(Planet p){
        double cosine = (p.xxPos - this.xxPos)/calcDistance(p);
        return this.calcForceExertedBy(p) * cosine;
    }

    public double calcForceExertedByY(Planet p){
        double sine = (p.yyPos - this.yyPos)/calcDistance(p);
        return this.calcForceExertedBy(p) * sine;
    }

    public double NetForceExertByX(Planet[] p) {
        double netForce = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] != this) {
                netForce += calcForceExertedByX(p[i]);
            }
        }
        return netForce;
    }

    public double NetForceExertByY(Planet[] p){
        double netForce = 0;
        for (int i = 0; i < p.length; i++) {
            if(p[i] != this){
                netForce += calcForceExertedByY(p[i]);
            }
        }
        return netForce;
        }

    public void update(double time, double Fx, double Fy){
        double Ax = Fx/this.mass;
        double Ay = Fy/this.mass;
        this.xxVel += Ax * time;
        this.yyVel += Ay * time;
        this.xxPos += this.xxVel * time + 0.5 * Ax * Math.pow(time,2);
        this.yyPos += this.yyVel * time + 0.5 * Ay * Math.pow(time,2);
    }

}