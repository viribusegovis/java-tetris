/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import blocks.Block;
import blocks.Empty;
import blocks.Piece;

/**
 *
 * @author Vasco
 */
public class TestPiece {

    public static void main(String[] args) {
        Block[][] B = {
            {new Empty(), new Block('S'), new Block('S')},
            {new Block('S'), new Block('S'), new Empty()}
        };
        
        Piece p = new Piece(B, 1, 4);
        System.out.println("piece = " + p);
        p.moveRight();
        p.rotate();
        System.out.println("Right and rotate " + p);
    }
}
