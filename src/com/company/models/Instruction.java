package com.company.models;

public class Instruction {

    private String from;
    private String to;
    private Integer element;

    public Instruction(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }


    public String getTo() {
        return to;
    }

    public Integer getElement() {
        return element;
    }

    public void setElement(Integer element) {
        this.element = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instruction)) return false;

        Instruction that = (Instruction) o;

        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        return to != null ? to.equals(that.to) : that.to == null;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", element=" + element +
                '}';
    }
}
