import java.util.Scanner;

public class ElementFill {

  public double[] fill(int rows, int cols){
    Scanner input = new Scanner(System.in);
    double[] element = new double[rows*cols];
    int count = 0;
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
        System.out.print("Informe o elemento ["+i+"]["+j+"]: ");
        element[count] = input.nextDouble();
        count++;
      }
    }
    return element;
  }

}
