import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static java.awt.Color.*;

public class Squares extends JPanel implements ActionListener {
    Numbers n = new Numbers();
    Solver solv = new Solver();
    Grids grid = new Grids();
    int i;
    FileWriter fWriter;
    PrintWriter pWriter;
    Thread t1,t2,t3,tOrta,t4;
    {
        try {
            fWriter = new FileWriter("C:\\Users\\Rahime\\IdeaProjects\\SamuraiSudoku\\Solutions.txt");
            pWriter = new PrintWriter(fWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int[][] box = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},

    };

    // KARELERİ ÇİZDİRME
    public void paint(Graphics g) {

        super.paint(g);
        for (int row = 0; row < box[0].length; row++) {
            for (int col = 0; col < box[0].length; col++) {
                Color color;
                g.setFont(new Font("SansSerif", Font.PLAIN, 20));

                if ((box[row][col]) == 1) {
                    color = Color.BLACK;
                    g.setColor(color);
                    g.fillRect(row * 30, col * 30, 30, 30);

                } else if ((box[row][col]) == 0) {
                    color = Color.BLACK;
                    g.setColor(color);
                    g.drawRect(row * 30, col * 30, 30, 30);
                    // Kareleri doldur
                    int x = 15, y = 25;
                    for (int i = (n.temp - 1); i >= 0; i--) {
                        if (x < 630) {

                            if ((270 > x || x > 360 || y > 180 && y < 450) && (270 > y || y > 360 || x > 180 && x < 450)) {
                                if (n.number.get(i) == "*") {
                                    g.drawString("  ", x, y);
                                } else {
                                    g.drawString(n.number.get(i), x, y);
                                }

                            } else {// aralığa boşluk atamak için
                                g.drawString(" ", x, y);
                                i++;
                            }
                            x += 30;
                        } else {
                            y += 30;
                            x = 15;
                            i++;
                        }
                    }


                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(row * 30, col * 30, 30, 30);
                }
            }
        }


        Graphics2D g2d = (Graphics2D) g;
        int width = 3;
        g2d.setStroke(new BasicStroke(width));
        for (i = 90; i <= 630; i = i + 90) {
            int y1 = 0, y2 = 630;
            g2d.setColor(Color.BLACK);
            g2d.drawLine(i, y1, i, y2);
            g2d.drawLine(y1, i, y2, i);
        }


         Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                box1();
                repaint();

            }
        });
        t1.stop();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                box2();
                repaint();

            }
        });
        t2.stop();


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                box3();
                repaint();
            }
        });
        t3.stop();

        Thread tOrta = new Thread(new Runnable() {
            @Override
            public void run() {
                boxOrta();
                repaint();
            }
        });
        tOrta.stop();

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                box4();
                repaint();
            }
        });
        t4.stop();

        //KUTU1 İN ÇÖZÜMÜ
        pWriter.println(" -------------------------------------- 1.ADIM");
        int xEk = 15, yEk = 25;
        if (yEk < 270) {
            for (int a = 0; a < grid.arr1.length; a++) {
                for (int b = 0; b < grid.arr1.length; b++) {
                    if (xEk < 270) {

                        grid.orta[0][0] = grid.arr1[6][6];
                        grid.orta[0][1] = grid.arr1[6][7];
                        grid.orta[0][2] = grid.arr1[6][8];
                        grid.orta[1][0] = grid.arr1[7][6];
                        grid.orta[1][1] = grid.arr1[7][7];
                        grid.orta[1][2] = grid.arr1[7][8];
                        grid.orta[2][0] = grid.arr1[8][6];
                        grid.orta[2][1] = grid.arr1[8][7];
                        grid.orta[2][2] = grid.arr1[8][8];

                        if (solv.sudoku(grid.arr1)) {
                            pWriter.println("X koordinatı: " + xEk + "  Y koordinatı: " + yEk + "  ---->   " + (grid.arr1[a][b]) + " rakamı yerleştirildi");
                        }
                        if (grid.arr1control[a][b].equals("*")) {
                            g.setColor(red);
                            g.drawString(String.valueOf(grid.arr1[a][b]), xEk, yEk);
                        }
                        xEk += 30;
                    }
                }
                yEk += 30;
                xEk = 15;
            }
        }

        //KUTU 2 ÇÖZÜMÜ
        pWriter.println(" -------------------------------------- 2.ADIM");
        int xEk2 = 375, yEk2 = 25;
        if (yEk2 < 270) {
            for (int a = 0; a < grid.arr2.length; a++) {
                for (int b = 0; b < grid.arr2.length; b++) {
                    if (xEk2 > 360) {

                        //ORTA KUTU ATAMASI
                        grid.orta[0][6] = grid.arr2[6][0];
                        grid.orta[0][7] = grid.arr2[6][1];
                        grid.orta[0][8] = grid.arr2[6][2];
                        grid.orta[1][6] = grid.arr2[7][0];
                        grid.orta[1][7] = grid.arr2[7][1];
                        grid.orta[1][8] = grid.arr2[7][2];
                        grid.orta[2][6] = grid.arr2[8][0];
                        grid.orta[2][7] = grid.arr2[8][1];
                        grid.orta[2][8] = grid.arr2[8][2];

                        if (solv.sudoku(grid.arr2)) {
                            pWriter.println("X koordinatı: " + xEk2 + "  Y koordinatı: " + yEk2 + "  ---->   " + (grid.arr2[a][b]) + " rakamı yerleştirildi");
                        } if (grid.arr2control[a][b].equals("*")) {
                            g.setColor(RED);
                            g.drawString(String.valueOf(grid.arr2[a][b]), xEk2, yEk2);
                        }
                        xEk2 += 30;
                    }
                }
                yEk2 += 30;
                xEk2 = 375;
            }
            System.out.println();

        }

        //KUTU 3 ÇÖZÜMÜ
        pWriter.println(" -------------------------------------- 3.ADIM");
        int xEk3 = 15, yEk3 = 385;
        i = (n.temp - 199);
        if (yEk3 > 360) {
            for (int a = 0; a < grid.arr3.length; a++) {
                for (int b = 0; b < grid.arr3.length; b++) {
                    if (xEk3 < 270) {

                        grid.orta[6][0] = grid.arr3[0][6];
                        grid.orta[6][1] = grid.arr3[0][7];
                        grid.orta[6][2] = grid.arr3[0][8];
                        grid.orta[7][0] = grid.arr3[1][6];
                        grid.orta[7][1] = grid.arr3[1][7];
                        grid.orta[7][2] = grid.arr3[1][8];
                        grid.orta[8][0] = grid.arr3[2][6];
                        grid.orta[8][1] = grid.arr3[2][7];
                        grid.orta[8][2] = grid.arr3[2][8];

                        if (solv.sudoku(grid.arr3)) {
                            pWriter.println("X koordinatı: " + xEk3 + "  Y koordinatı: " + yEk3 + "  ---->   " + (grid.arr3[a][b]) + " rakamı yerleştirildi");
                        } if (grid.arr3control[a][b].equals("*")) {
                            g.setColor(red);
                            g.drawString(String.valueOf(grid.arr3[a][b]), xEk3, yEk3);
                        }
                        xEk3 += 30;
                    }
                }
                yEk3 += 30;
                xEk3 = 15;
            }
        }


        //ORTA KUTU ÇÖZÜMÜ
        pWriter.println(" -------------------------------------- 4.ADIM");
        int xEko = 195, yEko = 205;
        if (yEko < 450) {
            for (int a = 0; a < 9; a++) {
                for (int b = 0; b < 9; b++) {
                    if (xEko < 450) {
                        grid.arr4[0][0] = grid.orta[6][6];
                        grid.arr4[0][1] = grid.orta[6][7];
                        grid.arr4[0][2] = grid.orta[6][8];
                        grid.arr4[1][0] = grid.orta[7][6];
                        grid.arr4[1][1] = grid.orta[7][7];
                        grid.arr4[1][2] = grid.orta[7][8];
                        grid.arr4[2][0] = grid.orta[8][6];
                        grid.arr4[2][1] = grid.orta[8][7];
                        grid.arr4[2][2] = grid.orta[8][8];


                        if (solv.sudoku(grid.orta)) {
                            pWriter.println("X koordinatı: " + xEko + "  Y koordinatı: " + yEko + "  ---->   " + (grid.orta[a][b]) + " rakamı yerleştirildi");
                        }
                        if (grid.arrOrtacontrol[a][b].equals("*")) {
                            g.setColor(red);
                            g.drawString(String.valueOf(grid.orta[a][b]), xEko, yEko);
                        }
                        xEko += 30;
                    }
                }
                yEko += 30;
                xEko = 195;
            }
        }


        pWriter.println(" -------------------------------------- 5.ADIM");
        int xEk4 = 375, yEk4 = 385;
        if (yEk4 > 360) {
            for (int a = 0; a < grid.arr4.length; a++) {
                for (int b = 0; b < grid.arr4.length; b++) {
                    if (xEk4 > 360) {

                        if (solv.sudoku(grid.arr4)) {
                            pWriter.println("X koordinatı: " + xEk4 + "  Y koordinatı: " + yEk4 + "  ---->   " + (grid.arr4[a][b]) + " rakamı yerleştirildi");
                        }
                        if (grid.arr4control[a][b].equals("*")) {
                            g.setColor(red);
                            g.drawString(String.valueOf(grid.arr4[a][b]), xEk4, yEk4);
                        }
                        xEk4 += 30;
                    }
                }
                yEk4 += 30;
                xEk4 = 375;
            }
        }



    }

    public void box1() {
        solv.sudoku(grid.arr1);
    }

    public void box2() {
        solv.sudoku(grid.arr2);
    }

    public void box3() {
        solv.sudoku(grid.arr3);
    }

    public void boxOrta() {
        solv.sudoku(grid.orta);
    }

    public void box4() {
        solv.sudoku(grid.arr4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        t1.start();
        t2.start();
        t3.start();
        tOrta.start();
        t4.start();
    }
}


