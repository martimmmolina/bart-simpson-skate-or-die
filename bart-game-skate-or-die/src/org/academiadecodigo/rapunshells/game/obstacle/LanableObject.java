package org.academiadecodigo.rapunshells.game.obstacle;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class LanableObject implements Comparable<LanableObject>{
    protected int lane;
    protected int z;

    public int getLane(){
        return lane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lane);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanableObject that = (LanableObject) o;
        return false;
    }

    @Override
    public int compareTo(LanableObject o) {
        return o.lane - this.lane;
    }

}
