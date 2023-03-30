public class SystemEquations {
  //teste se é possivel
  boolean isPossible(double[][] a){
    for (int i = 0; i < a.length; i++){
      int zerosInRow = 0;
      for (int j = 0; j < a[0].length; j++){
        if (a[i][j] == 0){
          zerosInRow++;
        }
      }
      if (zerosInRow == a[0].length-1) {
        return false;
      }
    }
    return true;
  }
  //teste se é determinado
  boolean isDeterminated(double[][] a) {
    int pivotAmount = 0;
    for (int i = 0; i < a.length; i++) {
      if (a.length == a[0].length - 1 && a[i][i] == 1) pivotAmount++;
    }
    if (pivotAmount == a[0].length-1) {return true;} else {return false;}
  }

  //solve do determinado 
  String[][] solveDeterminate(double[][] a) {
    double[][] results = new double[a.length][1];
    double z = a[a.length-1][a[0].length-1];
    results[a.length-1][0] = z;
    for (int i = 2; i <= a.length; i++){
      double last = a[a.length-i][a[0].length-1];
      double func = 0;
      for (int j = 2; j<=i; j++){
        func += a[a.length-i][a[0].length-j]*results[a.length-j+1][0];
      }
      results[a.length-i][0] = (last-func);
    }

    String[][] finalResult = new String[a.length][1];

    for (int i = 0; i<finalResult.length; i++){
      for (int j = 0; j<finalResult[0].length; j++){
        finalResult[i][j] = String.valueOf(results[i][j]);
      }
    }

    return finalResult;

  }

  //solve do inderteminado
  String[][] solveIndeterminate(double[][] a) {
    double[][] coeficientMatrix = new double[a.length][a[0].length-2];
    int independentCol = a[0].length-2;
    for (int col = 0; col < a[0].length; col++){
      int zerosInCol = 0;
      for (int row = 0; row < a.length; row++){
        if (a[row][col] == 0) zerosInCol++;
        if (zerosInCol == a.length) independentCol = col;
      }
    }

    int colum = 0;
    for (int row = 0; row<a.length; row++){
      for (int col = 0; col < a[0].length; col++){
        if (col != independentCol && col != a[0].length-1){
          coeficientMatrix[row][colum] =  a[row][col];
          colum++;
          if (colum == coeficientMatrix[0].length){
            colum = 0;
          }
        }
      }
    }

    
    String[][] results = new String[a[0].length-1][1];
    results[results.length-1][0] = "i";
    for (int i = 1; i <= a.length; i++){
      String last = String.valueOf(a[a.length-i][a[0].length-1]);
      String func = "";
      for (int j = 2; j<=i+1; j++){
        func += "-("+a[a.length-i][a[0].length-j]+"*"+results[a.length-j+2][0]+")";
      }
      results[results.length-i-1][0] = (last+"-["+func+"]");
    }

    return results;
  }

}




//        for (int row=0; row<a.length; row++) {
//          int startColumn = 0;
//          for (int i=0; i<a.length; i++) {
//            if (i!=row && a[i][startColumn]!=0) {
//              double multiple = 0-a[i][startColumn];
//              for (int j=startColumn; j<a[row].length; j++){
//                a[i][j] += multiple*a[row][j];
//              }
//            }
//          }
//          if (startColumn < a[0].length-1) startColumn++;
//        }
//        for (int i = 0; i < a.length; i++){
//          for (int j = 0; j < a[0].length; j++){
//            System.out.print(a[i][j]+" ");
//          }
//          System.out.println("");
//        }