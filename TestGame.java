package com.TicToe.app.TicToe;

import org.junit.Assert;
import org.junit.Test;


public class TestGame {

    @Test
    public void testWhoFirstAsNumber() {

        int result = Game.whoFirstAsNumber();

        Assert.assertTrue(result==0|| result == 1);
    }


    @Test
    public void testWhoFirst(){

        String player = Game.changePlayer(Constants.X);

        Assert.assertEquals(Constants.O, player );
    }
}
