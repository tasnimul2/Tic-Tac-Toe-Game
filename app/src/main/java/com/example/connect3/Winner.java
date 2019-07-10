package com.example.connect3;
//class that checks the requirements for player 1 or player 2 to win
public class Winner  {
    private int[] a;


    public Winner(int[] a) {
        this.a = a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public int[] getA() {
        return a;
    }

    public boolean player1Win(int[] a){
        if ((a[0] == 1 && a[1] == 1 && a[2] == 1)) {
            return true;
        }
        if ((a[3] == 1 && a[4] == 1 && a[5] == 1)) {
            return true;
        }
        if ((a[6] == 1 && a[7] == 1 && a[8] == 1)) {
            return true;
        }
        if ((a[0] == 1 && a[4] == 1 && a[8] == 1)) {
            return true;
        }
        if ((a[2] == 1 && a[4] == 1 && a[6] == 1)) {
            return true;
        }
        if ((a[0] == 1 && a[3] == 1 && a[6] == 1)) {
            return true;
        }
        if ((a[1] == 1 && a[4] == 1 && a[7] == 1)) {
            return true;
        }
        if ((a[2] == 1 && a[5] == 1 && a[8] == 1)) {
            return true;
        }
        return false;
    }

    public boolean player2Win(int[] a){
        if ((a[0] == 2 && a[1] == 2 && a[2] == 2)) {
            return true;
        }
        if ((a[3] == 2 && a[4] == 2 && a[5] == 2)) {
            return true;
        }
        if ((a[6] == 2 && a[7] == 2 && a[8] == 2)) {
            return true;
        }
        if ((a[0] == 2 && a[4] == 2 && a[8] == 2)) {
            return true;
        }
        if ((a[2] == 2 && a[4] == 2 && a[6] == 2)) {
            return true;
        }
        if ((a[0] == 2 && a[3] == 2 && a[6] == 2)) {
            return true;
        }
        if ((a[1] == 2 && a[4] == 2 && a[7] == 2)) {
            return true;
        }
        if ((a[2] == 2 && a[5] == 2 && a[8] == 2)) {
            return true;
        }
        return false;
    }


}
