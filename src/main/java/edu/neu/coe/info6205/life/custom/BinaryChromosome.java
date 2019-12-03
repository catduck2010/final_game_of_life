/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.life.custom;

import io.jenetics.Chromosome;
import io.jenetics.util.ISeq;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author lihang
 */
public class BinaryChromosome implements Chromosome<BinaryGene> {

    private ISeq<BinaryGene> iSeq;
    private final int length;

    public BinaryChromosome(ISeq<BinaryGene> iseq) {
        this.iSeq = iseq;
        this.length = iSeq.length();
    }

    public static BinaryChromosome of(ISeq<BinaryGene> genes) {
        return new BinaryChromosome(genes);
    }

    @Override
    public Chromosome<BinaryGene> newInstance(ISeq<BinaryGene> iseq) {
        return new BinaryChromosome(iseq);
    }

    @Override
    public BinaryGene getGene(int i) {
        return iSeq.get(i);
    }

    @Override
    public int length() {
        return iSeq.length();
    }

    @Override
    public ISeq<BinaryGene> toSeq() {
        return iSeq;
    }

    @Override
    public boolean isValid() {
        return iSeq.stream().allMatch(BinaryGene::isValid);
    }

    @Override
    public Iterator<BinaryGene> iterator() {
        return iSeq.iterator();
    }

    @Override
    public Chromosome<BinaryGene> newInstance() {
        ISeq<BinaryGene> genes = ISeq.empty();
        for (int i = 0; i < length; i++) {
            genes = genes.append(BinaryGene.of(ThreadLocalRandom.current().nextBoolean()));
        }
        return new BinaryChromosome(genes);
    }

    @Override
    public String toString() {
        String str="";
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                str+="|";
            }
            char c = (iSeq.get(i).getAllele()) ? 'T' : 'F';
            str+=String.valueOf(c);
        }
        return str;
    }

}
