package org.kniit.lab_2.Adapter;

public class Main {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        hole.fits(rpeg);
        hole.print(rpeg);

        SquarePeg small_sqpeg = new SquarePeg(5);
        SquarePeg large_sqpeg = new SquarePeg(10);
//        hole.fits(small_sqpeg);
        // в данном случае будет ошибка компиляции, несовместимые типы

        SquarePegAdapter small_sqpeg_adapter = new SquarePegAdapter(small_sqpeg);
        SquarePegAdapter large_sqpeg_adapter = new SquarePegAdapter(large_sqpeg);
        hole.fits(small_sqpeg_adapter);
        hole.print(small_sqpeg_adapter);
        hole.fits(large_sqpeg_adapter);
        hole.print(large_sqpeg_adapter);
    }
}
