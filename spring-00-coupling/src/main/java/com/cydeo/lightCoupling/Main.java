package com.cydeo.lightCoupling;

public class Main {
    public static void main(String[] args) {
        Mentor fullTimeMentor = new FullTimeMentor();
        Mentor partTimeMentor = new PartTimeMentor();

        MentorAccount fm = new MentorAccount(fullTimeMentor);
        MentorAccount pm = new MentorAccount(partTimeMentor);
        fm.manageAccount();
        pm.manageAccount();
    }
}