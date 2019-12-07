/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.life.custom;

import io.jenetics.Chromosome;
import io.jenetics.Genotype;
import io.jenetics.util.ISeq;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apple
 */
public class BinaryTestTest {
    
    public BinaryTestTest() {
    }

    /**
     * Test of fitness method, of class BinaryTest.
     */
    @Test
    public void testFitness() {
        System.out.println("fitness");
       
        
        BinaryGene g1 = BinaryGene.of(Boolean.FALSE);
        BinaryGene g2 = BinaryGene.of(Boolean.TRUE);
        
        ArrayList<BinaryGene> list = new ArrayList<BinaryGene>();
        list.add(g2);list.add(g1);list.add(g1);list.add(g2);list.add(g1);list.add(g2);list.add(g1);list.add(g2);list.add(g1);
        ISeq seq = ISeq.of(list);
        Chromosome<BinaryGene> ch = BinaryChromosome.of(seq);
        Genotype<BinaryGene> gt = Genotype.of(ch);
        
        Long expResult = 0l-4;
        Long result = BinaryTest.fitness(gt);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of explainer method, of class BinaryTest.
     */
    @Test
    public void testExplainer() {
        System.out.println("explainer");

        BinaryGene g1 = BinaryGene.of(Boolean.FALSE);
        BinaryGene g2 = BinaryGene.of(Boolean.TRUE);
        BinaryGene g3 = BinaryGene.of(Boolean.FALSE);
        BinaryGene g4 = BinaryGene.of(Boolean.TRUE);
        
        ArrayList<BinaryGene> list = new ArrayList<BinaryGene>();
        list.add(g1);list.add(g2);list.add(g1);list.add(g2);
        ISeq seq = ISeq.of(list);
        Chromosome<BinaryGene> ch = BinaryChromosome.of(seq);
        
        int width = 2;
        String expResult = "0 1, 1 1";
        String result = BinaryTest.explainer(ch, width);
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class BinaryTest.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        BinaryTest.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
