package com.cydeo.lightCoupling;

import com.cydeo.tightCoupling.FullTimeMentor;
import com.cydeo.tightCoupling.PartTimeMentor;

public class MentorAccount {
   Mentor mentor;

    public MentorAccount(Mentor mentor) {
        this.mentor = mentor;
    }


    public void manageAccount() {
        this.mentor.createAccount();
    }
}
