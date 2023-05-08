/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import blocks.Block;
import blocks.Empty;

/**
 *
 * @author Vasco
 */
public class TestEmpty {

    public static void main(String[] args) {
        //construtor
        Empty e = new Empty();
        //to string
        System.out.println("e = " + e);
        //clone
        Block e2 = e.getClone();
        System.out.println("e2 = " + e2.getClass());

    }
}
