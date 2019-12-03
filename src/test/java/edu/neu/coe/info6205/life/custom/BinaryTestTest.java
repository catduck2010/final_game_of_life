/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.life.custom;

import edu.neu.coe.info6205.life.custom.BinaryChromosome;
import edu.neu.coe.info6205.life.custom.BinaryGene;
import edu.neu.coe.info6205.life.custom.BinaryTest;
import io.jenetics.Genotype;
import io.jenetics.util.Factory;
import org.junit.Test;
import io.jenetics.util.ISeq;

import static org.junit.Assert.assertEquals;
/**
 *
 * @author apple
 */
public class BinaryTestTest {
    
    @Test
    public void explainer(){        
        Genotype bc = Genotype.of(BinaryChromosome.of(BinaryGene.seq(1)));
        assertEquals(Long.valueOf(0), BinaryTest.fitness(bc));
    }
}
