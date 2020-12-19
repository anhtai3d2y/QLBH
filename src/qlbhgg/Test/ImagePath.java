/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbhgg.Test;

import java.util.Scanner;

/**
 *
 * @author acer
 */
public class ImagePath {
     public static void main(String[] args) {
         String path, checkPath = "";
         Scanner sc = new Scanner(System.in);
         System.out.println("Nhap path: ");
         path = sc.nextLine();
         for(int i = 0; i<12 ; i++){
             checkPath += path.charAt(i);
         }
         System.out.println(checkPath);
    }
}
