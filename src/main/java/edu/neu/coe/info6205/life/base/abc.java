/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.life.base;

/**
 *
 * @author apple
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.jenetics.BitGene;
import io.jenetics.Chromosome;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import org.junit.Test;


/**
 *
 * @author apple
 */
public class abc {
//        /**
//    * Create a Game from the given PointAction stream.
//    * @param pointActions a stream of PointActions instances.
//    * @return a Game built from the stream of PointAction instances.
//    */
//    static Game createGame(Stream<PointAction> pointActions) {
//        final List<Point> points = new ArrayList<>();
//        final Cursor cursor = new Cursor();
//        pointActions.forEach(pa -> pa.updatePointList(cursor, points));
//        if (!points.isEmpty()) return Game.create(0L, points);
//        return null;
//    }
//
//    static class Cursor {
//        private Point point;
//
//        public Cursor(Point point) {
//            this.point = point;
//        }
//
//        public Cursor() {
//            this(new Point(0,0));
//        }
//
//        void move(Point point) {
//            this.point = this.point.move(point);
//        }
//    }
//        /**
//        *
//        * @param c
//        * @return
//        */
//    static Stream<PointAction> decode(Chromosome<BitGene> c) {
//        List<PointAction> pointActions = new ArrayList<>();
//        int start = 0;
//        while (start+5 < c.length()) start = addPointAction(c, start, pointActions);
//        return pointActions.stream();
//    }
//
//    static int addPointAction(Chromosome<BitGene> c, int start, List<PointAction> pointActions) {
//        int direction = decodeBits(c, start, 3);
//        int action = decodeBits(c, start+3, 2);
//        Telomere telomere = decodeBits(c, start+5);
//        pointActions.add(new PointAction(Point.createVector(direction, telomere.length), action));
//        return telomere.index;
//    }
//
//    /**
//    *
//    * TODO make private
//    *
//    * @param c the chromosome.
//    * @param start the start index for decoding.
//    * @param n the number of bits to decode.
//    * @return the decoded bits.
//    */
//    private static int decodeBits(Chromosome<BitGene> c, int start, int n) {
//        final int length = c.length();
//        if (start < 0 || (start+n) >= length) throw new LifeException("insufficient genes in this chromosome: "+c+", start="+start+", n="+n);
//        int result = 0;
//        for (int i = start; i < n+start; i++) result = 2 * result + (c.getGene(i).booleanValue() ? 1 : 0);
//        return result;
//    }
//
//    /**
//    *
//    * TODO make private
//    *
//    * @param c the chromosome.
//    * @param start the start index for decoding.
//    * @return the telomere for this Chromosome.
//    */
//    private static Telomere decodeBits(Chromosome<BitGene> c, int start) {
//        int result = 0;
//        int i = start;
//        final int length = c.length();
//        while (i < length && c.getGene(i).booleanValue()) {
//        result++;
//        i++;
//        }
//        return new Telomere(result, i);
//    }
//
//    static class Telomere {
//        private final int length;
//        private final int index;
//
//        public Telomere(int length, int index) {
//            this.length = length;
//            this.index = index;
//        }
//    }
//
//    static class PointAction {
//        private final Point point;
//        private final int action;
//
//        PointAction(Point point, int action) {
//            this.point = point;
//            this.action = action;
//        }
//
//        void updatePointList(Cursor cursor, List<Point> points) {
//            cursor.move(point);
//            Point p = cursor.point;
//            switch (action) {
//                case 0 : points.add(p); break;
//                case 1 : points.remove(p); break;
//                case 2 : if (points.contains(p)) points.remove(p); else points.add(p); break;
//                case 3 : break;
//                default: throw new LifeException("action code invalid: "+action);
//            }
//        }
//
//        @Override
//        public String toString() {
//            return "PointAction "+point+", "+action;
//        }
//    }
//    
//    @Test
//  public void testGetFitness() {
//      
//    RandomRegistry.setRandom(new Random(0L));
//    Factory<Genotype<BitGene>> gtf = Genotype.of(BitChromosome.of(20, 0.3333));
//    double fitness = Life.getFitness(gtf.newInstance());
//    assertEquals(1, fitness, 0.0001);
//  }
//  
//  Engine<BitGene, Integer> engine = Engine
//                                .builder(Life::eval, gtf)
//                                .executor(Runnable::run)
//                                .build();
}

