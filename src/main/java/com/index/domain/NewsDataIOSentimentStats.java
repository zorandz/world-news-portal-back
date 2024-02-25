package com.index.domain;

public class NewsDataIOSentimentStats {

	private double positive;
    private double neutral;
    private double negative;

    public NewsDataIOSentimentStats(double positive, double neutral, double negative) {
        this.positive = positive;
        this.neutral = neutral;
        this.negative = negative;
    }

    public double getPositive() {
        return positive;
    }

    public void setPositive(double positive) {
        this.positive = positive;
    }

    public double getNeutral() {
        return neutral;
    }

    public void setNeutral(double neutral) {
        this.neutral = neutral;
    }

    public double getNegative() {
        return negative;
    }

    public void setNegative(double negative) {
        this.negative = negative;
    }
}
