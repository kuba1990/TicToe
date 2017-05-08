package com.TicToe.app.TicToe; /**
 * Created by lnovo on 2017-05-04.
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;


public class TestBoard {

    Board testBoard = new Board();

    @Test(expected = NoFieldException.class)
    public void testSetFieldNoFieldException(){
        Field field = new Field(2,3);

        field.setValue(Constants.X);

        testBoard.addField(field);

        Field fieldResult = testBoard.getField(2,2);

        Assert.assertEquals(fieldResult.getValue(),field.getValue());

    }


    @Test
        public void testSetField(){
        Field field = new Field(2,2);

        field.setValue(Constants.X);

        testBoard.addField(field);

        Field fieldResult = testBoard.getField(2,2);

        Assert.assertEquals(fieldResult.getValue(),field.getValue());

    }

}
