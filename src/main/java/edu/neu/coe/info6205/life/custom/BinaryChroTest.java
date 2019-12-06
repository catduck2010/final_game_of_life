/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.life.custom;

import edu.neu.coe.info6205.life.base.Game;
import edu.neu.coe.info6205.life.base.Grid;
import edu.neu.coe.info6205.life.base.Point;
import static edu.neu.coe.info6205.life.base.Point.points;
import io.jenetics.EliteSelector;
import io.jenetics.Genotype;
import io.jenetics.Optimize;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionResult;
import io.jenetics.util.Factory;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 *
 * @author lihang
 */
public class BinaryChroTest {

    private static Integer fitness(Genotype<BinaryGene> gt) {
        return gt.getChromosome()
                .as(BinaryChromosome.class)
                .length();
    }

    public static void theMain(String[] args) {
        Factory<Genotype<BinaryGene>> g
                = Genotype.of(BinaryChromosome.of(BinaryGene.seq(100)));
        Engine<BinaryGene, Integer> engine
                = Engine.builder(BinaryChroTest::fitness, g)
                        .offspringFraction(0.7)
                        .optimize(Optimize.MAXIMUM)
                        .populationSize(200)
                        .selector(new EliteSelector<>())
                        .build();

        Genotype<BinaryGene> result = engine.stream().limit(1000)
                .collect(EvolutionResult.toBestGenotype());

//        result.getChromosome().stream().forEach(i -> {
//            System.out.print(i.getAllele() + " ");
//        });
        System.out.println(result.getChromosome());
    }

    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(0,0));
        list.add(new Point(0,-1));
        list.add(new Point(0,-2));
        
        Game g = Game.create(0L, list);
        int i = 5;
        while (i-- > 0) {
            g = g.generation((t, u) -> {System.out.println(u.getGroup().getAbsolutePoints());
            });
        }
    }
}
