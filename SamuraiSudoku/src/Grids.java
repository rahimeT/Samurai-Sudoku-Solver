public class Grids {
    Numbers n = new Numbers();
    int[][] arr1 = new int[9][9]; // kutu1 arrayi
    int[][] arr2 = new int[9][9]; //kutu2 arrayi
    int[][] orta = new int[9][9]; //orta kutu arrayi
    int[][] arr3 = new int[9][9]; //kutu3 arrayi
    int[][] arr4 = new int[9][9]; //kutu4 arrayi

    String[][] arr1control = new String[9][9];
    String[][] arr2control = new String[9][9];
    String[][] arr3control = new String[9][9];
    String[][] arrOrtacontrol = new String[9][9];
    String[][] arr4control = new String[9][9];

    public Grids() {


        //KUTU1 i ALDIM
        System.out.println("-------------------KUTU1");
        int x = 0, y = 0, h = 0;
        int clean = 0;
        int i = (n.temp - 1);
        if (y < 270) {
            for (int t = 0; t < arr1.length; t++) {
                if (x < 270) {
                    for (int j = 0; j < arr1.length; j++) {
                        if (n.number.get(i) == "*") {
                            arr1[t][j] = 0;

                        } else {

                            arr1[t][j] = Integer.parseInt(n.number.get(i));
                        }
                        arr1control[t][j] = n.number.get(i);
                        clean++;
                        i--;
                        x += 30;
                    }
                }
                if (clean >= 55) {
                    i -= 3;
                }
                x = 0;
                y += 30;
                i -= 9;
            }

        }


        //2.KUTUYU ALDIKKK
        System.out.println("-------------------------- 2.KUTU");
        x = 360;
        y = 0;
        clean = 0;
        i = (n.temp - 10);
        if (y < 270) {
            for (int t = 0; t < arr2.length; t++) {
                if (x >= 360) {
                    for (int j = 0; j < arr2.length; j++) {

                        if (n.number.get(i) == "*") {
                            arr2[t][j] = 0;
                        } else {
                            arr2[t][j] = Integer.parseInt(n.number.get(i));
                        }
                        arr2control[t][j] = n.number.get(i);
                        clean++;
                        i--;
                        x += 30;
                    }
                }
                if (clean >= 54) {
                    i -= 3;
                }
                i -= 9;
                x = 360;
                y += 30;
            }

        }

        //3.KUTUYU ALDIK
        System.out.println("-------------------------- 3.KUTU");
        x = 0;
        y = 360;
        clean = 0;
        i = (n.temp - 199);
        System.out.println(i);
        if (y >= 360) {
            for (int t = 0; t < arr3.length; t++) {
                if (x < 270) {
                    for (int j = 0; j < arr3.length; j++) {
                        if (n.number.get(i) == "*") {
                            arr3[t][j] = 0;
                        } else {
                            arr3[t][j] = Integer.parseInt(n.number.get(i));
                        }
                        arr3control[t][j] = n.number.get(i);
                        clean++;
                        i--;
                        x += 30;
                    }
                }
                if (clean <= 27) {
                    i -= 3;
                }
                i -= 9;
                x = 0;
                y += 30;
            }
        }


        //ORTA KUTUYU ALDIM

        System.out.println("-------------------------ORTA KUTU");
        x = 180;
        y = 180;
        clean = 0;
        i = 254;
        if (y < 450) {
            for (int t = 0; t < orta.length; t++) {
                if (x < 450) {
                    for (int j = 0; j < orta.length; j++) {

                        if (n.number.get(i) == "*") {
                            orta[t][j] = 0;
                        } else {
                            orta[t][j] = Integer.parseInt(n.number.get(i));
                        }
                        arrOrtacontrol[t][j] = n.number.get(i);
                        clean++;
                        i--;
                        x += 30;

                    }
                    if (27 > clean) {
                        i -= 11;
                    } else if (clean == 27) {
                        i -= 5;
                    } else if (clean > 27 && clean < 54) {
                        i++;
                    } else if (clean == 54) {
                        i -= 5;
                    } else {
                        i -= 11;
                    }
                }
                i--;
                x = 180;
                y += 30;
            }
        }

        //KUTU4 i ALDIM
        System.out.println("-------------------4.KUTU");
        x = 360;
        y = 360;
        clean = 0;
        i = (n.temp - 211);
        if (y >= 360) {
            for (int t = 0; t < arr4.length; t++) {
                if (x >= 360) {
                    for (int j = 0; j < arr4.length; j++) {
                        if (n.number.get(i) == "*") {
                            arr4[t][j] = 0;
                        } else {
                            arr4[t][j] = Integer.parseInt(n.number.get(i));
                        }
                        arr4control[t][j] = n.number.get(i);
                        clean++;
                        i--;
                        x += 30;
                    }
                }
                if (clean < 27) {
                    i -= 3;
                }
                x = 360;
                y += 30;
                i -= 9;
            }
        }
    }

}
