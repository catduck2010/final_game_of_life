/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.life.custom;

import edu.neu.coe.info6205.life.base.Game;
import io.jenetics.Chromosome;
import io.jenetics.EliteSelector;
import io.jenetics.Genotype;
import io.jenetics.Optimize;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.Factory;

/**
 *
 * @author lihang
 */
public class BinaryTest {

    static int WIDTH = 4;

    public static Long fitness(Genotype<BinaryGene> gt) {
        return Game.run(0L, explainer(gt.getChromosome(), WIDTH)).generation;
    }

    public static String explainer(Chromosome<BinaryGene> ch, int width) {
        String res = "";
        for (int i = 0; i < ch.length(); i++) {
            if (ch.getGene(i).getAllele()) {
                res = res + ", " + i / width + " " + i % width;
            }
        }
        return res.substring(1).trim();
    }

    public static void main(String[] args) {
        Factory<Genotype<BinaryGene>> g
                = Genotype.of(BinaryChromosome.of(BinaryGene.seq(WIDTH * WIDTH)));
        
        Engine<BinaryGene, Long> engine
                = Engine.builder(BinaryTest::fitness, g)
                        .offspringFraction(0.7)
                        .optimize(Optimize.MAXIMUM)
                        .populationSize(50)
                        .selector(new EliteSelector<>(5))
                        .build();

        Genotype<BinaryGene> result
                = engine.stream()
                        .limit(10)
                        .collect(EvolutionResult.toBestGenotype());

//        result.getChromosome().stream().forEach(i -> {
//            System.out.print(i.getAllele() + " ");
//        });
        System.out.println(result.getChromosome());
    }
}
