
public class GaussJordan{

  private double[][] augmentedMatrix;
  //constructor
  public GaussJordan(double[][] matrix) {
    augmentedMatrix = matrix;
  }

  public void eliminate() {
    int startColumn = 0;
    for (int row=0; row<augmentedMatrix.length; row++) {

      for (int i = 0; i < augmentedMatrix.length; i++){
        if (augmentedMatrix[row][startColumn] == 0 && augmentedMatrix[i][startColumn] != 0){
          double[] temp = augmentedMatrix[i];
          augmentedMatrix[i]=augmentedMatrix[row];
          augmentedMatrix[row]=temp;
        }
      }

      //se nao é um, reduz a um
      if(augmentedMatrix[row][startColumn]!=1.0 && augmentedMatrix[row][startColumn]!=0) {
        double divisor = augmentedMatrix[row][startColumn];
        for (int i=0; i<augmentedMatrix[row].length; i++) {
          augmentedMatrix[row][i] = augmentedMatrix[row][i]/divisor;
        }
      }

      //garante os primeiros zeros
      for (int i=row; i<augmentedMatrix.length; i++) {
        if (i!=row && augmentedMatrix[i][startColumn]!=0) {
          double multiple = 0-augmentedMatrix[i][startColumn];
          for (int j=startColumn; j<augmentedMatrix[row].length; j++){
            augmentedMatrix[i][j] +=
                multiple*augmentedMatrix[row][j];
          }
        }
      }


      if (startColumn < augmentedMatrix[0].length-1) startColumn++;
    }
  }

  public double[][] getMatriz(){
    return augmentedMatrix;
  }


  public String toString() {
    String text = "";
    for (int i=0; i<augmentedMatrix.length; i++) {
      for (int j=0; j<augmentedMatrix[i].length; j++) {
        text+=augmentedMatrix[i][j] + ", ";
      }
      text+="\n";
    }
    return text;
  }
}
