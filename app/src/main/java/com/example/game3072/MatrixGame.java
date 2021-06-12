package com.example.game3072;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.widget.Toast;

import java.io.IOException;

public class MatrixGame {
    public static int[][] matrix;
    public int[][] recentMatrix;
    public static int score = 0;
    public static int a = 0;
    public static int g = 2;

    private static boolean one = true;
    private static boolean two = true;
    private static boolean three = true;
    private static boolean four = true;

    MatrixGame(int a) {
        this.a = a;
        this.matrix = new int[a][a];
        this.recentMatrix = new int[a][a];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
                recentMatrix[i][j] = 0;
            }
        }
        generate();
    }

    public static boolean Vibration() {
        if (score > 1000 && one) {
            one = false;
            return true;
        } else {
            if (score > 10000 && two) {
                two = false;
                return true;
            } else {
                if (score > 50000 && three) {
                    three = false;
                    return true;
                } else {
                    if (score > 100000 && four) {
                        four = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkLose(Context context) throws IOException {
        int check = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length-1; j++) {
                if (matrix[i][j] == matrix[i][j+1])
                    check++;
            }
        }
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == matrix[i+1][j])
                    check++;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    check++;
            }
        }
        if (check == 0) {
            //Toast.makeText(context,"Lose",Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    public void toZero () {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
                recentMatrix[i][j] = 0;
            }
        }
        generate();
    }

    public void setMatrix (int [][] matrix1, int [][] matrix2) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix1[i][j] = matrix2[i][j];
            }
        }
    }

    public void Left() {
        setMatrix(recentMatrix,matrix);
        matrixNormLeft();
        matrixLeft();
        matrixNormLeft();
        generate();
    }

    public void Right() {
        setMatrix(recentMatrix,matrix);
        matrixNormRight();
        matrixRight();
        matrixNormRight();
        generate();
    }

    public void Top() {
        setMatrix(recentMatrix,matrix);
        matrixNormTop();
        matrixTop();
        matrixNormTop();
        generate();
    }

    public void Bottom() {
        setMatrix(recentMatrix,matrix);
        matrixNormBottom();
        matrixBottom();
        matrixNormBottom();
        generate();
    }
    //влево

    public void matrixLeft() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1] && matrix[i][j] != 0) {
                    matrix[i][j] *= 2;
                    score += matrix[i][j];
                    matrix[i][j + 1] = 0;
                }
            }
        }
    }

    public void matrixNormLeft() {
        int c = 0;
        int[] mass = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    mass[c] = matrix[i][j];
                    c++;
                }
            }
            for (int m = 0; m < matrix.length; m++) {
                matrix[i][m] = mass[m];
            }
            for (int k = 0; k < mass.length; k++) {
                mass[k] = 0;
            }
            c = 0;
        }
    }

    //вправо

    public void matrixRight() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length - 1; j > 0; j--) {
                if (matrix[i][j] != 0 && matrix[i][j] == matrix[i][j - 1]) {
                    matrix[i][j] *= 2;
                    score += matrix[i][j];
                    matrix[i][j - 1] = 0;
                }
            }
        }
    }

    public void matrixNormRight() {
        int c = 0;
        int zero = 0;
        int[] mass = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    mass[c] = matrix[i][j];
                    c++;
                } else {
                    zero++;
                }
            }

            int count = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (j < zero)
                    matrix[i][j] = 0;
                else {
                    matrix[i][j] = mass[count];
                    count++;
                }
            }
            count = 0;

            for (int j = 0; j < mass.length; j++) {
                mass[j] = 0;
            }
            c = 0;
            zero = 0;
        }
    }

    //вверх

    public void matrixTop() {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] == matrix[i + 1][j]) {
                    matrix[i][j] *= 2;
                    score += matrix[i][j];
                    matrix[i + 1][j] = 0;
                }
            }
        }
    }

    public void matrixNormTop() {
        int c = 0;
        int[] mass = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] != 0) {
                    mass[c] = matrix[i][j];
                    c++;
                }
            }
            for (int i = c; i < mass.length; i++) {
                mass[i] = 0;
            }
            for (int i = 0; i < mass.length; i++) {
                matrix[i][j] = mass[i];
            }

            c = 0;
        }
    }

    //вниз

    public void matrixBottom() {
        for (int i = matrix.length - 1; i > 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] == matrix[i - 1][j]) {
                    matrix[i - 1][j] = 0;
                    matrix[i][j] *= 2;
                    score += matrix[i][j];
                }
            }
        }
    }

    public void matrixNormBottom() {
        int c = 0;
        int zero = 0;
        int[] mass = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] != 0) {
                    mass[c] = matrix[i][j];
                    c++;
                } else {
                    zero++;
                }
            }

            for (int i = c; i < mass.length; i++) {
                mass[i] = 0;
            }

            int count = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (i < zero)
                    matrix[i][j] = 0;
                else {
                    matrix[i][j] = mass[count];
                    count++;
                }
            }
            c = 0;
            zero = 0;
        }
    }

    public String printScore() {
        return String.valueOf(score + a);
    }

    public void generate() {
        int zero = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zero++;
                }
            }
        }
        int rand = 1 + (int) (Math.random() * zero);
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    count++;
                    if (count == rand) {
                        matrix[i][j] = this.g;
                    }
                }
            }
        }
    }
}
