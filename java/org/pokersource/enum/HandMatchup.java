// $Id$

package org.pokersource.enum;

public class HandMatchup {
  public long matchHands[];          // matchHands[i] is player i's hand
  private int hash;

  public HandMatchup(long matchHands[]) {
    this.matchHands = (long[]) matchHands.clone();
    computeHash();
  }

  public boolean equals(Object o) {
    HandMatchup other = (HandMatchup) o;
    return java.util.Arrays.equals(this.matchHands, other.matchHands);
  }

  private void computeHash() {
    // hash = matchHands.hashCode()  --- WRONG: not equal for equal arrays
    hash = matchHands.length;
    for (int i=0; i<matchHands.length; i++)
      hash = (hash << 1) ^ (new Long(matchHands[i])).hashCode();
  }

  public int hashCode() {
    return hash;
  }
}