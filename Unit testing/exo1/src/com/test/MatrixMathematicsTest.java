package com.test;

import com.exception.NoSquareException;
import com.model.Matrix;
import com.service.MatrixMathematics;
import org.junit.Assert;
import org.junit.Rule;

import static org.junit.Assert.*;

public class MatrixMathematicsTest {

    //avant de lancer piTest il faut executer les Test unitaire
    @org.junit.Test
    public void determinant() throws Exception {

        double [][] data={{4,7},{21,3}};
        double [][] data1={{4}};
        double [][] data2={{4,7,7},{21,3,1},{1,2,0}};

        Matrix mat=new Matrix(data);
        Matrix mat1=new Matrix(data1);
        Matrix mat2=new Matrix(data2);

        Assert.assertEquals(MatrixMathematics.determinant(mat),-135,0);

        Assert.assertEquals(MatrixMathematics.determinant(mat1),4,0);
        Assert.assertEquals(MatrixMathematics.determinant(mat2),272,0);

    }
    @org.junit.Test(expected = NoSquareException.class)
    public void determinant1() throws NoSquareException{
        double [][] data={{4,7},{21,3},{1,2}};
        Matrix mat=new Matrix(data);
        MatrixMathematics.determinant(mat);



    }




    @org.junit.Test
    public void createSubMatrix() throws Exception {



    }

}