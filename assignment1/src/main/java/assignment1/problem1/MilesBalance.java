package assignment1.problem1;

import java.util.Objects;

/**
 * Miles balance provide information about total miles available, miles earned this year, miles expiring by the end of this calendar year
 * @author Ambika Kabra, kabraambika19
 */
public class MilesBalance {
  private int totalMileAvl;
  private int milesEarnCurrYr;
  private int mileExpCurrYr;

  /**
   * @param totalMileAvl An integer value, representing total miles available
   * @param milesEarnCurrYr An integer value, representing miles earned this year,
   * @param mileExpCurrYr An integer value, representing miles expiring by the end of this calendar year.
   */
  public MilesBalance(int totalMileAvl, int milesEarnCurrYr,
      int mileExpCurrYr) {
    this.totalMileAvl = totalMileAvl;
    this.milesEarnCurrYr = milesEarnCurrYr;
    this.mileExpCurrYr = mileExpCurrYr;
  }

  /**
   * @return this.totalMileAvl
   */
  public int getTotalMileAvl() {
    return this.totalMileAvl;
  }

  /**
   * @return this.milesEarnCurrYr
   */
  public int getMilesEarnCurrYr() {
    return this.milesEarnCurrYr;
  }

  /**
   * @return this.mileExpCurrYr
   */
  public int getMileExpCurrYr() {
    return this.mileExpCurrYr;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    MilesBalance that = (MilesBalance) obj;
    return getTotalMileAvl() == that.getTotalMileAvl()
        && getMilesEarnCurrYr() == that.getMilesEarnCurrYr()
        && getMileExpCurrYr() == that.getMileExpCurrYr();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTotalMileAvl(), getMilesEarnCurrYr(), getMileExpCurrYr());
  }

  @Override
  public String toString() {
    return "MilesBalance{" +
        "totalMileAvl=" + getTotalMileAvl() +
        ", milesEarnCurrYr=" + getMilesEarnCurrYr() +
        ", mileExpCurrYr=" + getMileExpCurrYr() +
        '}';
  }
}
