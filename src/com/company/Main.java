package com.company;

public class Main {

    public static void main(String[] args) {
        Function fun = new Function();
        fun.invokeBrowser("firefox");
        fun.login("bhidet2@gmail.com","TMKOC");
        fun.wait(3000);
        fun.addNote("Let's Learn Django","First Learn Python","Dev");
        fun.wait(3000);
        fun.editNote("Let's Learn Flask","First Learn Git","Dev");
        fun.wait(3000);
        fun.sendMail();
        fun.wait(6000);
        fun.deleteNote();
        fun.wait(3000);
        fun.logout();
        fun.closeBrowser();
    }
}
