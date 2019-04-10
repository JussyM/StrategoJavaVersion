/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53554.stratego.controller;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jussy
 */
public class ControllerTest {
    
    public ControllerTest() {
    }

    @Test
    public void testInitialized() {
        System.out.println("initialized");
        Controller instance = null;
        instance.initialized();
        
    }

    @Test
    public void testStartGame() {
        System.out.println("startGame");
        Controller instance = null;
        instance.startGame();
        
    }
    
}
