/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.life.custom;

import io.jenetics.Gene;
import io.jenetics.util.Factory;
import io.jenetics.util.ISeq;
import io.jenetics.util.MSeq;
import io.jenetics.util.Verifiable;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author lihang
 */
public class BinaryGene implements Gene<Boolean, BinaryGene>, Verifiable, Factory<BinaryGene> {

    private Boolean value;

    private BinaryGene(Boolean value) {
        this.value = value;
    }

    public static BinaryGene of(Boolean value) {
        return new BinaryGene(value);
    }

    public static ISeq<BinaryGene> seq(int length) {
        return MSeq.<BinaryGene>ofLength(length).fill(()
                -> new BinaryGene(ThreadLocalRandom.current().nextBoolean()))
                .toISeq();
    }

    @Override
    public Boolean getAllele() {
        return value;
    }

    @Override
    public BinaryGene newInstance() {
        return new BinaryGene(ThreadLocalRandom.current().nextBoolean());
    }

    @Override
    public BinaryGene newInstance(Boolean a) {
        return new BinaryGene(a);
    }

    @Override
    public boolean isValid() {
        return value || !value;
    }

}
