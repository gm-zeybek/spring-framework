package com.cydeo.tightCoupling;

public class Main {
    public static void main(String[] args) {
        FullTimeMentor fullTimeMentor = new FullTimeMentor();
        PartTimeMentor partTimeMentor = new PartTimeMentor();
        Mentor mentor = new Mentor(fullTimeMentor,partTimeMentor);
        mentor.fullTimeMentor.createAccount();
        mentor.partTimeMentor.createAccount();
    }
}