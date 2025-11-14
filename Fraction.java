package ru.stepina.UnitFour;

public final class Fraction extends Number {
    private final int numer;
    private final int denom;

    public Fraction(int numer, int denom) {
        if (denom == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулём.");
        }

        if (denom < 0) {
            numer = -numer;
            denom = -denom;
        }

        int gcd = gcd(Math.abs(numer), Math.abs(denom));
        this.numer = numer / gcd;
        this.denom = denom / gcd;
    }

    public int getNumer() {
        return numer;
    }

    public int getDenom() {
        return denom;
    }

    public Fraction plus(Fraction other) {
        int num = this.numer * other.denom + other.numer * this.denom;
        int den = this.denom * other.denom;
        return new Fraction(num, den);
    }

    public Fraction minus(Fraction other) {
        int num = this.numer * other.denom - other.numer * this.denom;
        int den = this.denom * other.denom;
        return new Fraction(num, den);
    }

    public Fraction times(Fraction other) {
        int num = this.numer * other.numer;
        int den = this.denom * other.denom;
        return new Fraction(num, den);
    }

    public Fraction divide(Fraction other) {
        if (other.numer == 0) {
            throw new ArithmeticException("Деление на ноль.");
        }
        int num = this.numer * other.denom;
        int den = this.denom * other.numer;
        return new Fraction(num, den);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return (double) numer / denom;
    }


    @Override
    public String toString() {
        if (denom == 1) {
            return String.valueOf(numer);
        } else {
            return numer + "/" + denom;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;
        Fraction fraction = (Fraction) o;
        return numer == fraction.numer && denom == fraction.denom;
    }


}