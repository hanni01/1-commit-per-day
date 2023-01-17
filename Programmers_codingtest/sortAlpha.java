package Programmers_codingtest;

import java.util.Scanner;

class sortAlpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split("");

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((int) arr[i].charAt(0) < (int) arr[j].charAt(0)) {
                    String tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        String answer = String.join("", arr);
        System.out.println(answer);;
    }
}
