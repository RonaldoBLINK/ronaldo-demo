package org.ronaldo;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(char c  : s.toCharArray()){
            switch (c){
                case '{':
                case '[':
                case '(':
                stack.push(c);
                break;

                case'}':
                    if (stack.empty() || stack.pop() != '{'){
                        return false;
                    }
                    break;

                case']':
                    if (stack.empty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }

        return stack.empty();

    }

    public static void main(String[] args) {

        System.out.println(isValid("{[()]}")); // true
        System.out.println(isValid("{()}"));   // true
        System.out.println(isValid("{[}]"));   // false
        System.out.println(isValid("([]"));    // false
        System.out.println(isValid(")("));     // false




        // Dado un string que contiene solo los caracteres mostrados determinar si el string es válido

        // {[()]} -> true
        // {()}   -> true
        // {[}]   -> false
        // ([]    -> false
        // )(     -> false
        //los corchetes deben estar cerrados y ordenados por el mismo tipo




/*        //System.out.println("Hello world!");

*//*
        int[] arreglo = {3, 5, 6, 3, 7, 8, 1, 2};

        // Método para ordenar el arreglo
        Arrays.sort(arreglo);

        // Imprimir el arreglo ordenado
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));

 *//*


      *//*  int[] A = {2, 3, 4, 6};
        int[] B = {7, 9, 5, 8};

        // Unir los dos arreglos en uno nuevo
        int[] C = new int[A.length + B.length];
        System.arraycopy(A, 0, C, 0, A.length);
        System.arraycopy(B, 0, C, A.length, B.length);

        // Ordenar el nuevo arreglo
        Arrays.sort(C);

        // Imprimir el arreglo ordenado
        System.out.println("Arreglo unido y ordenado: " + Arrays.toString(C));*//*


        int[] A = {2, 3, 4, 6};
        int[] B = {7, 9, 5, 8};

        // Unir los dos arreglos en uno nuevo y ordenarlo en forma descendente
        int[] C = IntStream.concat(Arrays.stream(A), Arrays.stream(B))
                .boxed()
                .sorted((x, y) -> y - x) // Ordenar en forma descendente
                .mapToInt(Integer::intValue)
                .toArray();

        // Imprimir el arreglo ordenado en forma descendente
        System.out.println("Arreglo unido y ordenado de forma descendente: " + Arrays.toString(C));*/








    }
}