import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Matrix matrix = new Matrix();
    ElementFill element = new ElementFill();
    LinearAlgebra calc = new LinearAlgebra();
    int rows, cols;

    // ------------------------------ PRIMEIRA MATRIZ ------------------------------
    System.out.println("\n----------------- PRIMEIRA MATRIZ -----------------");
    System.out.print("Informe a quantidade de linhas da matriz: ");
    rows = input.nextInt();
    System.out.print("Informe a quantidade de colunas da matriz: ");
    cols = input.nextInt();

    double[] element1;
    element1 = element.fill(rows, cols);
    double[][] M1;
    M1 = matrix.constructor(rows, cols, element1);
    System.out.println("\nMATRIZ 1:");
    matrix.show(M1);


    /*
    System.out.println(matrix.get(0,0, M1));
    matrix.set(0,0, M1, 5);
    matrix.show(M1);
    */
    
    //--------------TRANSPOSTA E GAUSS (1)
    /*
    System.out.println("\nTransposta :");
    matrix.show(calc.transpose(M1));

    System.out.println("\nGauss-Jordan :");
    matrix.show(calc.gauss(M1));
    matrix.show(calc.solve(M1));
    */

    // ------------------------------ SEGUNDA MATRIZ ------------------------------
    System.out.println("\n----------------- SEGUNDA MATRIZ ------------------");
    System.out.print("\nInforme a quantidade de linhas da matriz: ");
    rows = input.nextInt();
    System.out.print("Informe a quantidade de colunas da matriz: ");
    cols = input.nextInt();

    double[] element2;
    element2 = element.fill(rows, cols);
    double[][] M2;
    M2 = matrix.constructor(rows, cols, element2);
    System.out.println("\nMATRIZ 2:");
    matrix.show(M2);
    
    
    //--------------TRANSPOSTA E GAUSS (2)
    
    System.out.println("\nTransposta :");
    matrix.show(calc.transpose(M2));

    System.out.println("\nGauss-Jordan :");
    matrix.show(calc.gauss(M2));
    matrix.show(calc.solve(M2));
    

    // ------------------------------ CÁLCULOS ------------------------------
    System.out.println("\n-------------------- CÁLCULOS ---------------------");

    
    System.out.println("\nSUM");
    matrix.show(calc.sum(M1,M2));
    
    
    System.out.println("\nTIMES");
    matrix.show(calc.times(M1,M2));
    //System.out.println("Metodo times com 1 número e 1 matriz");
    //matrix.show(calc.times(5,M2));

    System.out.println("\nDOT");
    matrix.show(calc.dot(M1,M2));
    
  }
  
}