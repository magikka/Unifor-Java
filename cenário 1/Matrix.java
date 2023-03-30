public class Matrix {

  //cria matriz
  public double[][] constructor(int rows, int cols, double[] elements){
    try {
      double[][] matrix = new double[rows][cols];
      int p = 0;
      for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++){
          matrix[i][j] = elements[p];
          p++;
        }
      }
      return matrix;
    } catch (Exception e){
      throw new IllegalArgumentException(e);
    }
  }
  
  //GET (recebe valor do indice indicado)
  public double get(int i, int j, double[][] m){
    try {
      return m[i][j];
    }catch (Exception e){
      throw new IllegalArgumentException("Indice invalido");
    }
  }

  // SET (seta valor)
  public void set(int i, int j, double[][] m, double value){
    try {
      m[i][j] = value;
    }catch (Exception e){
      throw new IllegalArgumentException("Indice ou matriz invalida");
    }
  }

  //mostrar
  public void show(double[][] m){
    if (m.length > 0){
      for (int i = 0; i < m.length; i++){
        System.out.print("| ");
        for (int j = 0; j < m[0].length; j++){
          System.out.print(get(i,j,m)+" ");
        }
        System.out.println("|");
      }
    }else {
      throw new IllegalArgumentException("Matriz não existe ou nula");
    }
  }
  public void show(String[][] m){
    if (m.length > 0){
      for (int i = 0; i < m.length; i++){
        System.out.print("| ");
        for (int j = 0; j < m[0].length; j++){
          System.out.print(m[i][j]+" ");
        }
        System.out.println("|");
      }
    }else {
      throw new IllegalArgumentException("Matriz não existe ou nula");
    }
  }

  public void toString(String[][] a) {
    String text = "";
    for (int i=0; i<a.length; i++) {
      System.out.print("| ");
      for (int j=0; j<a[i].length; j++) {
        System.out.print(a[i][j]+" ");
      }
      System.out.print("|");
    }
  }
}