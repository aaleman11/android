package com.thenerdjock.aaleman.conversion;

import java.text.DecimalFormat;

/**
 * Created by aaleman on 1/31/17.
 */

public class Quantity {

    final double value;
    final Unit unit;

    public Quantity(double v, Unit newUnit) {
    }

    public static enum Unit {
        tsp(1.0d), tbs(0.3333d), cup(0.0208d), oz(0.1666d), pint(0.0104d),
        quart(0.0052d), gallon(.0013d), pound(0.0125d), ml(4.9289d),
        liter(0.0049d), mg(5678.5d), kg(0.0057d);

        final static Unit baseUnit = tsp;

        final double byBaseUnit;

        private Unit(double inTsp) {
            this.byBaseUnit = inTsp;
        }

        public double toBaseUnit(double value) {

            return value/byBaseUnit;

        }

        public double fromBaseUnit(double value) {

            return value*byBaseUnit;
        }
    }

    public Quantity to(Unit newUnit){

        Unit oldUnit = this.unit;
        return new Quantity(newUnit.fromBaseUnit(oldUnit.toBaseUnit(value)), newUnit);

    }

    @Override
    public String toString(){

        DecimalFormat df = new DecimalFormat("#.0000");

        return df.format(value) + " " + unit.name();

    }

}