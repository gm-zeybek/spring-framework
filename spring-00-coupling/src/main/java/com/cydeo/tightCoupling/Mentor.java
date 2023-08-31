package com.cydeo.tightCoupling;

public class Mentor {
    FullTimeMentor fullTimeMentor = new FullTimeMentor();
    PartTimeMentor partTimeMentor = new PartTimeMentor();


    public Mentor(FullTimeMentor fullTimeMentor, PartTimeMentor partTimeMentor) {
        this.fullTimeMentor = fullTimeMentor;
        this.partTimeMentor = partTimeMentor;
    }


}
