package com.prestamo.utils;

import java.util.Objects;
import java.util.Set;


public class Architecture {

    int cores = Runtime.getRuntime().availableProcessors();
    Set<Thread> threads = Thread.getAllStackTraces().keySet();

    public Architecture() {
    }

    public Architecture(int cores, Set<Thread> threads) {
        this.cores = cores;
        this.threads = threads;
    }

    public int getCores() {
        return this.cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public Set<Thread> getThreads() {
        return this.threads;
    }

    public void setThreads(Set<Thread> threads) {
        this.threads = threads;
    }

    public Architecture cores(int cores) {
        setCores(cores);
        return this;
    }

    public Architecture threads(Set<Thread> threads) {
        setThreads(threads);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Architecture)) {
            return false;
        }
        Architecture arquitectura = (Architecture) o;
        return cores == arquitectura.cores && Objects.equals(threads, arquitectura.threads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cores, threads);
    }

    @Override
    public String toString() {
        return "{" +
            " cores='" + getCores() + "'" +
            ", threads='" + getThreads() + "'" +
            "}";
    }
}
