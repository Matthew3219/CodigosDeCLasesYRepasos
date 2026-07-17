
package Arbol;


public class View {
    public static void main(String[] args) {
       int[] array = {3,6,9,12,15,18,21,24};
       ArbolBinarios arbolito = new ArbolBinarios();
       arbolito.createBalancedTree(array);
        System.out.println(arbolito);
    }
  
}
