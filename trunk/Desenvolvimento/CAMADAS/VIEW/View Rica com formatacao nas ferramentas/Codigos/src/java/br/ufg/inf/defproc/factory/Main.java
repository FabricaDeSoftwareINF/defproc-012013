/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.defproc.factory;

import br.ufg.inf.defproc.util.Password;

/**
 *
 * @author Pedro Felipe''
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Password.hashSHA256("123456"));
        
    }
}
